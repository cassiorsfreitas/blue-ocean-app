package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.CustomerDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public Customer get(Integer id) {
        return customerDao.findById(id);
    }


    @Transactional
    @Override
    public Customer save(Customer obj) {
        return customerDao.saveOrUpdate(obj);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        customerDao.delete(id);
    }


    @Override
    public List<Customer> list() {
        return customerDao.findAll();
    }


    @Transactional
    @Override
    public void addFlagSubmitted(int id, Flag flag) {
        Customer customer = customerDao.findById(id);
        customer.addFlagSubmitted(flag);
        customerDao.saveOrUpdate(customer);
    }

}
