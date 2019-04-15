package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class StoreSQL implements AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    private final Config config;

    private Connection connection;

    public StoreSQL() {
        this.config = new Config();
        this.init();
        this.createTable();
    }

    /**
     * Database connection.
     *
     * @return result.
     */
    public boolean init() {
        try {
            Class.forName(this.config.getValue("jdbc.driver"));
            this.connection = DriverManager.getConnection(
                    this.config.getValue("jdbc.url"),
                    this.config.getValue("jdbc.username"),
                    this.config.getValue("jdbc.password"));
        } catch (ClassNotFoundException | SQLException e) {
            LOG.warn(e.getMessage(), e);
        }
        return this.connection != null;
    }

    /**
     * Create a vacancy table.
     */
    public void createTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(new StringBuilder("create table if not exists vacancy")
                    .append("(id serial primary key,")
                    .append("name varchar(400),")
                    .append("link text,")
                    .append("description text,")
                    .append("date bigint);").toString());
        } catch (SQLException e) {
            LOG.warn(e.getMessage(), e);
        }
    }

    /**
     * Add vacancy to table.
     *
     * @param vacancySet Set<Vacancy>.
     */
    public void addVacancy(Set<Vacancy> vacancySet) {
        try (PreparedStatement prst = this.connection.prepareStatement(
                "insert into vacancy(name, link, description, date) values (?, ?, ?, ?)")) {
            this.connection.setAutoCommit(false);
            for (Vacancy vacancy : vacancySet) {
                prst.setString(1, vacancy.getName());
                prst.setString(2, vacancy.getLink());
                prst.setString(3, vacancy.getDescription());
                prst.setLong(4, vacancy.getDate());
                prst.addBatch();
            }
            prst.executeBatch();
            this.connection.commit();
        } catch (SQLException e) {
            LOG.warn(e.getMessage(), e);
        }
    }

    /**
     * Return last date from table.
     *
     * @return time.
     * @throws SQLException
     */
    public long lastDate() throws SQLException {
        long time = 0;
        try (Statement st = this.connection.createStatement()) {
            ResultSet resultSet = st.executeQuery("select max(date) from vacancy");
            if (resultSet.next()) {
                time = resultSet.getLong("max");
            }
        }
        Calendar startYear = new GregorianCalendar();
        startYear.set(startYear.get(Calendar.YEAR), 0, 1, 0, 0);
        return time != 0 ? time : startYear.getTimeInMillis();
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
