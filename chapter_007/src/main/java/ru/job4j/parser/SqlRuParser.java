package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class SqlRuParser implements Job {

    private static final int UPPER_BOUND_TAG = 7;

    private static final int LOWER_BOUND_TAG = 3;

    private static final Logger LOG = LogManager.getLogger(SqlRuParser.class.getName());

    private final String cron = new Config().getValue("cron.time");

    private final ConvertDate date;

    private final StoreSQL storeSQL;

    public SqlRuParser() {
        this.date = new ConvertDate();
        this.storeSQL = new StoreSQL();
    }

    /**
     * Parser vacancy page from sql.ru, add vacancy to table.
     */
    public void parser() {
        Set<Vacancy> vacancySet = new HashSet<>();
        boolean continueSearch = true;
        try {
            long lastDate = this.storeSQL.lastDate();
            for (int i = 1; continueSearch; i++) {
                Document doc = Jsoup.connect("https://www.sql.ru/forum/job-offers/" + i).get();
                Elements elements = doc.getElementsByTag("tr");
                for (int j = UPPER_BOUND_TAG; j < elements.size() - LOWER_BOUND_TAG; j++) {
                    Elements elements1 = elements.get(j).getElementsByTag("td");
                    String name = elements1.get(1).getElementsByTag("a").get(0).text();
                    if (name.toLowerCase().contains("java") && !name.toLowerCase().contains("javascript")) {
                        long date = this.date.convert(elements1.get(5).getElementsByClass("altCol").text());
                        if (date <= lastDate) {
                            continueSearch = false;
                            break;
                        }
                        String link = elements1.get(1).child(0).attr("href");
                        String desc = Jsoup.connect(link).get().getElementsByClass("msgBody").get(1).text();
                        vacancySet.add(new Vacancy(name, desc, link, date));
                    }
                }
            }
            this.storeSQL.addVacancy(vacancySet);
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.parser();
    }

    public void start() {
        JobDetail j = JobBuilder.newJob(SqlRuParser.class).build();
        Trigger t = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(this.cron)).build();
        try {
            Scheduler s = StdSchedulerFactory.getDefaultScheduler();
            s.start();
            s.scheduleJob(j, t);
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        new SqlRuParser().start();
    }
}