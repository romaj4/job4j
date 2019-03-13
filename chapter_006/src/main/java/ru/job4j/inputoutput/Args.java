package ru.job4j.inputoutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Args {

    private String[] args;

    private static String keyDir = "-d";

    private static String keyExt = "-e";

    private static String keyOut = "-o";

    public Args(String[] args) {
        this.args = args;
    }

    public boolean isValid() {
        return args[0].equals(keyDir)
                && args[2].equals(keyExt)
                && args[args.length - 2].equals(keyOut);
    }

    public String getDirectory() {
        return this.args[1];
    }

    public List<String> getExclude() {
        List<String> rst = new ArrayList<>();
        for (int i = 3; i < args.length - 2; i++) {
            rst.add(this.args[i]);
        }
        return rst;
    }

    public String getOutput() {
        return this.args[this.args.length - 1];
    }
}
