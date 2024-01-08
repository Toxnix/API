package de.bacherik.API.management;

import com.google.gson.Gson;
import de.bacherik.API.database.EAuth;
import net.bytemc.evelon.repository.Filter;
import net.bytemc.evelon.repository.Repository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
public class Auth {
    private final String route = "/auth";

    @GetMapping(route + "/bla")
    public String bla(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping(route + "/createUser")
    public String createUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam(value = "userName") String userName, @RequestParam(value = "permissionLevel") String permissionLevel) {
        UUID uuid = UUID.randomUUID();
        String tokenNew = "Neuer token bitte ändern";
        var repository = Repository.create(EAuth.class);
        if (repository.query().filter(Filter.match("token", token)).database().findFirst().getPermissionLevel().equals("admin")) {
            repository.query().create(new EAuth(userName, tokenNew, permissionLevel, uuid));
            EAuth eAuth = new EAuth();
            eAuth.setUuid(uuid);
            eAuth.setPermissionLevel(permissionLevel);
            eAuth.setToken(tokenNew);
            eAuth.setUsername(userName);

            Gson gson = new Gson();
            return gson.toJson(eAuth);
        } else {
            String error = "{\n" +
                    "    \"success\": \"false\",\n" +
                    "    \"reason\": \"You don't have permission to access this resource\"\n" +
                    "}";
            return error;
        }
    }
}
