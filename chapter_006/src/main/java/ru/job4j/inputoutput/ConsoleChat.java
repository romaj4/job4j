package ru.job4j.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleChat {

    private static Logger logger = Logger.getLogger(ConsoleChat.class.getName());

    private boolean printRandomAnswer = true;

    private static final String STOP_WORD = "стоп";

    private static final String CONTINUE_WORD = "продолжить";

    private static final String EXIT_WORD = "закончить";

    private final String answersFile = "chapter_006/src/main/resources/answers.txt";

    private final String logFile = "chapter_006/consolechat.log";

    /**
     * Создает консольный чат.
     */
    public void start() {
        this.createLogger(this.logFile);
        List<String> answersList = this.createAnswersList(this.answersFile);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.equals(EXIT_WORD)) {
            checkWord(str);
            String answer = answersList.get((int) (Math.random() * answersList.size()));
            if (this.printRandomAnswer) {
                System.out.println(answer);
            }
            logger.info(str);
            logger.info(answer);
            str = sc.nextLine();
        }
        logger.info(str);
    }

    /**
     * Задаёт необходимые параметры для записи сообщений в лог файл.
     *
     * @param logFile путь к лог-файлу.
     */
    public void createLogger(String logFile) {
        try {
            logger.addHandler(new FileHandler(logFile));
            logger.setUseParentHandlers(false);
            logger.getHandlers()[0].setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getMessage() + "\n";
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создает список фраз из указанного файла.
     *
     * @param answersFile путь к файлу.
     * @return список фраз.
     */
    public List<String> createAnswersList(String answersFile) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(answersFile))) {
            String read;
            while ((read = br.readLine()) != null) {
                wordsList.add(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }

    /**
     * Проверяет на соответствие "контрольным" словам.
     *
     * @param word вводимое пользователем слово.
     */
    public void checkWord(String word) {
        if (word.equals(STOP_WORD)) {
            this.printRandomAnswer = false;
        }
        if (word.equals(CONTINUE_WORD)) {
            this.printRandomAnswer = true;
        }
    }

    public static void main(String[] args) {
        new ConsoleChat().start();
    }
}