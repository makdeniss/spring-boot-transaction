package org.example.data.admin;

import org.example.data.AbstractEntityRepository;
import org.example.domain.admin.Customer;
import org.springframework.dao.DataAccessException;

public interface CustomerRepository extends AbstractEntityRepository<Customer> {

    Customer findByName(String name) throws DataAccessException;
}
