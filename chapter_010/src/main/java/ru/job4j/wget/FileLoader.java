package ru.job4j.wget;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class FileLoader implements Runnable {

    private final static String DOWNLOAD_PATH = System.getProperty("user.home") + "\\Downloads\\";

    /**
     * Path to the downloaded file
     */
    private final String url;

    /**
     * Download Limit, kilobytes per second.
     */
    private final int limit;

    public FileLoader(String url, int limit) {
        this.url = url;
        this.limit = limit;
    }

    @Override
    public void run() {
        this.loadFile();
    }

    public void loadFile() {
        HttpURLConnection urlConnection = null;
        try {
            URL urlFile = new URL(this.url);
            urlConnection = (HttpURLConnection) urlFile.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(DOWNLOAD_PATH + this.getFileName());
        try (BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
             FileOutputStream outputStream = new FileOutputStream(file)) {
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            long startTime = System.currentTimeMillis();
            int read;
            int loadKb = 0;
            while ((read = inputStream.read(buffer)) != -1) {
                loadKb = loadKb + (read / 1024);
                long timeLoad = System.currentTimeMillis() - startTime;
                if (loadKb >= this.limit && timeLoad < 1000) {
                    this.sleepThread(1000 - timeLoad);
                    loadKb = 0;
                    startTime = System.currentTimeMillis();
                }
                outputStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName() {
        return this.url.substring(this.url.lastIndexOf("/") + 1);
    }

    private void sleepThread(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Thread(new FileLoader(args[0], Integer.parseInt(args[1]))).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
