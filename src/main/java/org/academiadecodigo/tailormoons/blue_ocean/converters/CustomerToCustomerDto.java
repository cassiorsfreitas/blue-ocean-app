package org.academiadecodigo.tailormoons.blue_ocean.converters;

import org.academiadecodigo.tailormoons.blue_ocean.dto.CustomerDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A {@link Converter} implementation, responsible for {@link Customer} to {@link CustomerDto} type conversion
 */
@Component
public class CustomerToCustomerDto extends AbstractConverter<Customer, CustomerDto> {

    /**
     * Converts the customer model object into a customer DTO
     *
     * @param customer the customer
     * @return the customer DTO
     */
    @Override
    public CustomerDto convert(Customer customer) {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setUsername(customer.getUsername());
        customerDto.setEmail(customer.getEmail());
        customerDto.setCity(customer.getCity());
        customerDto.setScore(customer.getScore());


        return customerDto;
    }
}
