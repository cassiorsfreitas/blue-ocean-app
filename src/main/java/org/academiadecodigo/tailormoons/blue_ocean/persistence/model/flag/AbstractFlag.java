package org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.AbstractModel;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractFlag extends AbstractModel {


    @ManyToOne
    private Customer customer;

    private Float coordX;

    private Float coordY;


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Float getCoordX() {
        return coordX;
    }


    public void setCoordX(Float coordX) {
        this.coordX = coordX;
    }


    public Float getCoordY() {
        return coordY;
    }


    public void setCoordY(Float coordY) {
        this.coordY = coordY;
    }


}
