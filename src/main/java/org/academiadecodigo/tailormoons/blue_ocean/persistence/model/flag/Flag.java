package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.AbstractModel;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Flag extends AbstractModel {


    @ManyToOne
    private Customer customer;

    private Float lat;

    private Float lng;


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Float getLat() {
        return lat;
    }


    public void setLat(Float lat) {
        this.lat = lat;
    }


    public Float getLng() {
        return lng;
    }


    public void setLng(Float lng) {
        this.lng = lng;
    }


}
