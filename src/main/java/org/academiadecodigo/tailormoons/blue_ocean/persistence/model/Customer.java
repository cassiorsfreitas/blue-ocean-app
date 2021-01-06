package org.academiadecodigo.tailormoons.blue_ocean.persistence.model;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {

    private String username;

    private String email;

    private String city;

    private Integer score;

    // TODO: 17/12/2020 Verificar tipo cascata e removal;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "customer",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private Set<Flag> flagsSubmitted = new HashSet<>();


    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "reviewer",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private Set<FlagReviewed> flagsReviewed = new HashSet<>();


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public Integer getScore() {
        return score;
    }


    public void setScore(Integer score) {
        this.score = score;
    }


    public Set<Flag> getFlagsSubmitted() {
        return flagsSubmitted;
    }


    public void setFlagsSubmitted(Set<Flag> flagsSubmitted) {
        this.flagsSubmitted = flagsSubmitted;
    }


    public Set<FlagReviewed> getFlagsReviewed() {
        return flagsReviewed;
    }


    public void setFlagsReviewed(Set<FlagReviewed> flagsReviewed) {
        this.flagsReviewed = flagsReviewed;
    }


    public void addFlagSubmitted(Flag flag) {
        flagsSubmitted.add(flag);
        flag.setCustomer(this);
    }

}
