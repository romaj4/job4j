package ru.job4j.inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Archive {

    public static void main(String[] args) {
        Args arg = new Args(args);
        if (!arg.isValid()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        new Archive().archive(arg.getDirectory(), arg.getExclude(), arg.getOutput());
    }

    /**
     * Архивирует проект.
     *
     * @param directory директория, которую мы архивируем.
     * @param exclude   список расширений, которые мы хотим исклчить.
     * @param output    путь куда мы архивируем.
     */
    public void archive(String directory, List<String> exclude, String output) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(output))) {
            List<File> zipFiles = new Search().allFiles(directory, exclude);
            for (File file : zipFiles) {
                ZipEntry entry = new ZipEntry(file.getPath());
                zipOut.putNextEntry(entry);
                FileInputStream in = new FileInputStream(file);
                byte[] buffer = new byte[2048];
                while (in.read(buffer) != -1) {
                    zipOut.write(buffer);
                }
                in.close();
                zipOut.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
