package dev.alexzvn.among.util;

import org.bukkit.Bukkit;

public class Util {

    public static int random_int(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void writeInfoLog(String text) {
        Bukkit.getLogger().info(text);
    }
}
