package ru.job4j.inputoutput;

import java.io.File;
import java.util.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Search {

    /**
     * Возвращает список файлов с нужным расширением.
     *
     * @param parent путь до каталога.
     * @param exts   расширения файлов.
     * @return список файлов.
     */
    public List<File> files(String parent, List<String> exts) {
        List<File> rst = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        File file = new File(parent);
        if (file.exists()) {
            data.offer(file);
            while (!data.isEmpty()) {
                File dirFile = data.poll();
                for (File checkFile : dirFile.listFiles()) {
                    if (checkFile.isDirectory()) {
                        data.offer(checkFile);
                    } else if (exts.contains(this.getExtension(checkFile))) {
                        rst.add(checkFile);
                    }
                }
            }
        }
        return rst;
    }

    /**
     * Возвращает список всех файлов, кроме указанных.
     *
     * @param parent путь до каталога.
     * @param exts   расширения файлов.
     * @return список файлов.
     */
    public List<File> allFiles(String parent, List<String> exts) {
        List<File> rst = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        File file = new File(parent);
        if (file.exists()) {
            data.offer(file);
            while (!data.isEmpty()) {
                File dirFile = data.poll();
                for (File checkFile : dirFile.listFiles()) {
                    if (checkFile.isDirectory()) {
                        data.offer(checkFile);
                    } else if (!exts.contains(this.getExtension(checkFile))) {
                        rst.add(checkFile);
                    }
                }
            }
        }
        return rst;
    }

    /**
     * Возвращает расширение файла.
     *
     * @param file файл.
     * @return расширение.
     */
    public String getExtension(File file) {
        String fileName = file.getName();
        int index = fileName.indexOf('.');
        return index == -1 ? null : fileName.substring(index);
    }
}
