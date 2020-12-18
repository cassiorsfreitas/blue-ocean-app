package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;

public interface CustomerService extends Service<Customer> {

    void addFlagSubmitted(int id, Flag flag);

}
