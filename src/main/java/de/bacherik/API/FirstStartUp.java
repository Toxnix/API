package de.bacherik.API;

import com.google.gson.Gson;
import de.bacherik.API.database.EAuth;
import net.bytemc.evelon.DatabaseProtocol;
import net.bytemc.evelon.Evelon;
import net.bytemc.evelon.cradinates.DatabaseCradinates;
import net.bytemc.evelon.repository.Repository;

import java.util.UUID;

public class FirstStartUp {

    public static void main(String[] args) {
        // DatabaseConfig dbConfig = new DatabaseConfig("./", "database.yml");
        // dbConfig.add();
        // Evelon
        Evelon.setCradinates(new DatabaseCradinates(
                DatabaseProtocol.MYSQL, //type of sql server
                "hostname", //hostname
                "password", //password
                "username", //username
                "database", //database
                3306 //port
        ));

        UUID uuid = UUID.randomUUID();
        String permissionLevel = "admin";
        String token = "HalloIchBInDUmm";
        String userName = "admin";
        var repository = Repository.create(EAuth.class);
        repository.query().create(new EAuth(userName, token, permissionLevel, uuid));
        EAuth eAuth = new EAuth();
        eAuth.setUuid(uuid);
        eAuth.setPermissionLevel(permissionLevel);
        eAuth.setToken(token);
        eAuth.setUsername(userName);

        Gson gson = new Gson();
        System.out.println(gson.toJson(eAuth));
        System.out.println("First start up");
    }
}
