package de.bacherik.API.database;

import de.leonhard.storage.Yaml;

import java.io.File;

public class DatabaseConfig {

    private static Yaml config = null;

    public DatabaseConfig(String path, String name) {
        config = new Yaml(new File(path, name));
    }

    public static String getDbName() {
        return config.getString("dbName");
    }

    public static int getPort() {
        return config.getInt("port");
    }


    public static String getHost() {
        return config.getString("host");
    }

    public static String getPassword() {
        return config.getString("password");
    }

    public static String getUsername() {
        return config.getString("username");
    }

    public void add() {
        config.setDefault("host", "mysql33.1blu.de");
        config.setDefault("password", "&)?RIFXunxMbC8k");
        config.setDefault("username", "s314414_3557333");
        config.setDefault("dbName", "db314414x3557333");
        config.setDefault("port", 3306);
    }
}
