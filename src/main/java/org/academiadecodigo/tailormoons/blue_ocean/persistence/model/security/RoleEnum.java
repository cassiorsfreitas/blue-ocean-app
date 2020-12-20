package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security;

public enum RoleEnum {
    USER(new Role("ROLE_USER")),
    MODERATOR(new Role("ROLE_MODERATOR")),
    ADMIN(new Role("ROLE_ADMIN"));

    private final Role role;


    RoleEnum(Role role) {
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

}
