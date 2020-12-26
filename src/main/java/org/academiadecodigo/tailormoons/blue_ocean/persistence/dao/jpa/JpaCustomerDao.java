package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.CustomerDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    public JpaCustomerDao() {
        super(Customer.class);
    }

}
