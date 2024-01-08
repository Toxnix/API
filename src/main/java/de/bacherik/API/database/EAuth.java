package de.bacherik.API.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.bytemc.evelon.repository.annotations.Entity;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Entity(name = "auth")
public class EAuth {
    private String username;
    private String token;
    private String permissionLevel;
    private UUID uuid;

    public EAuth() {

    }
}
