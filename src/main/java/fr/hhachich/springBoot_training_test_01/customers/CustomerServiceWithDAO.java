package fr.hhachich.springBoot_training_test_01.customers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceWithDAO {
    private final CustomerDao customerDao;

    public CustomerServiceWithDAO(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public List<CustomerDTO> search(){
        return this.customerDao.search();
    }
}
