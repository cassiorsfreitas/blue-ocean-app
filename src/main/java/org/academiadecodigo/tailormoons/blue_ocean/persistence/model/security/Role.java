package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends AbstractModel {

    private String name;


    public Role() {
    }


    public Role(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }

}
