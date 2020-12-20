package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security;

public enum RoleEnum {
    USER(new Role("USER")),
    MODERATOR(new Role("MODERATOR")),
    ADMIN(new Role("ADMIN"));

    private final Role role;


    RoleEnum(Role role) {
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

}
