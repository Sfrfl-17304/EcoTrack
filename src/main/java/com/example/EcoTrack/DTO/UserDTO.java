package com.example.EcoTrack.DTO;

import com.example.EcoTrack.Entities.User;
import lombok.Getter;
import java.util.Set;

@Getter
public class UserDTO {
    private Long id;
    private String username;
    private Set<String> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }
}
