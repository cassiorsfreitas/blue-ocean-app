package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "flag_reviewed")
public class FlagReviewed extends Flag {


    @ManyToOne
    private Customer reviewer;

    private String state;


    public Customer getReviewer() {
        return reviewer;
    }


    public void setReviewer(Customer reviewer) {
        this.reviewer = reviewer;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }

}
