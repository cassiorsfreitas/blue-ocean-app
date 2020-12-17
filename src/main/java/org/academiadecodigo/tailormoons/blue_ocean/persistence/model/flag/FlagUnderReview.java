package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flag_under_review")
public class FlagUnderReview extends Flag {

    private String state;


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }

}
