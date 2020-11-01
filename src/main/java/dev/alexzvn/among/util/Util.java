package dev.alexzvn.among.util;

import java.io.File;

import org.bukkit.Bukkit;

public class Util {

    public static int random_int(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void writeInfoLog(String text) {
        Bukkit.getLogger().info(text);
    }

    public static void deleteDir(File dir) {
        File[] files = dir.listFiles();

        if(files != null) {
            for (final File file : files) {
                deleteDir(file);
            }
        }

        dir.delete();
    }
}
