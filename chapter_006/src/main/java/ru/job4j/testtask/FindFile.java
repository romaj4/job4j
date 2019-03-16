package ru.job4j.testtask;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import ru.job4j.inputoutput.Search;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindFile {

    /**
     * Параметры командной строки.
     */
    @Parameter(names = {"-d"})
    private String directoryToFind;
    @Parameter(names = {"-n"})
    private String fileToFind;
    @Parameter(names = {"-o"})
    private String fileToWrite;
    @Parameter(names = "-m", description = "Find by mask")
    private boolean findByMask = false;
    @Parameter(names = "-f", description = "Find by full fileToFind")
    private boolean findByFullName = false;

    private static final String LN = System.lineSeparator();

    public static void main(String[] args) {
        FindFile file = new FindFile();
        try {
            JCommander.newBuilder().addObject(file).build().parse(args);
        } catch (Exception e) {
            System.out.println("Команда введена неверно");
        }
        if (file.isValid(args)) {
            file.start();
        }
    }

    /**
     * Проверяет правильность ключей.
     *
     * @param args аргументы командной строки.
     * @return результат.
     */
    public boolean isValid(String[] args) {
        boolean rst = true;
        if (this.directoryToFind == null || this.fileToWrite == null || this.fileToFind == null
                || (!this.findByFullName && !this.findByMask) || (this.findByFullName && this.findByMask)) {
            System.out.println("Не все необходимые данные для поиска указаны");
            this.showHelp();
            rst = false;
        }
        return rst;
    }

    /**
     * Выводит на экран подсказку.
     */
    public void showHelp() {
        System.out.println(new StringBuilder()
                .append("-d - директория, в которой начинать поиск.").append(LN)
                .append("-n - имя файл, маска.").append(LN)
                .append("-m - искать по маске, либо -f - полное совпадение имени.").append(LN)
                .append("-o - результат записать в файл.").toString()
        );
    }

    /**
     * Поиск файла и запись результата.
     */
    public void start() {
        List<File> findFiles = new Search().files(this.directoryToFind,
                Arrays.asList(this.getExtension(this.fileToFind)));
        try (FileWriter writer = new FileWriter(new File(this.fileToWrite))) {
            if (this.findByFullName) {
                for (File file : findFiles) {
                    if (file.getName().equals(this.fileToFind)) {
                        writer.write(file.getAbsolutePath());
                        break;
                    }
                }
            }
            if (this.findByMask) {
                for (File file : findFiles) {
                    writer.write(file.getAbsolutePath() + LN);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает расширение из имени.
     *
     * @param name файл.
     * @return расширение.
     */
    public String getExtension(String name) {
        int index = name.lastIndexOf('.');
        return index == -1 ? null : name.substring(index);
    }
}
