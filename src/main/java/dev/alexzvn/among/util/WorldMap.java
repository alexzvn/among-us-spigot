package dev.alexzvn.among.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class WorldMap {

    public static void teleAsyncPlayerToLobby(Player player) {
        Plugin.runAsync(new Runnable() {
            @Override
            public void run() {
                telePlayerToLobby(player);
            }
        });
    }

    public static void telePlayerToLobby(Player player) {
        player.teleport(getLobbyLocation(), TeleportCause.PLUGIN);
    }

    public static boolean unload(World world) {
        return world != null && Bukkit.getServer().unloadWorld(world, false);
    }

    public static World copy(World origin, String newName) {
        copyFileStructure(
            origin.getWorldFolder(),
            new File(Bukkit.getWorldContainer(), newName)
        );

        return new WorldCreator(newName).createWorld();
    }

    public static void delete(World world) {
        if (unload(world)) {
            Util.deleteDir(new File(Bukkit.getWorldContainer(), world.getName()));
        }
    }

    public static Location getLobbyLocation() {
        FileConfiguration config = Plugin.config();

        World world = Bukkit.getWorld(
            config.getString("lobby.location.name", "world")
        );

        for (String dimension : new String[] {"x", "y", "z"}) {
            if (! config.isSet("lobby.location.".concat(dimension))) {
                return world.getSpawnLocation();
            }
        }

        return new Location(
            world,
            config.getInt("lobby.location.x"),
            config.getInt("lobby.location.y"),
            config.getInt("lobby.location.z")
        );
    }

    private static void copyFileStructure(File source, File target){

        ArrayList<String> ignore = new ArrayList<String>(Arrays.asList(
            "uid.dat",
            "session.lock"
        ));

        try {
            if(ignore.contains(source.getName())) return;

            if(source.isDirectory()) {
                createWorldDir(source, target); return;
            }

            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0)
                out.write(buffer, 0, length);
            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createWorldDir(File source, File target) throws IOException {
        if(!target.exists())
            if (!target.mkdirs())
                throw new IOException("Couldn't create world directory!");

        String files[] = source.list();

        for (String file : files) {
            File srcFile = new File(source, file);
            File destFile = new File(target, file);
            copyFileStructure(srcFile, destFile);
        }
    }
}
