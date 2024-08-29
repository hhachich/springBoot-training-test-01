package fr.hhachich.springBoot_training_test_01.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2 )
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    @Test
    public void shouldReturnAllCustomers(){
        // Arrange / Given
        Customer customerOne= Customer.builder().id(1).email("user1@gmail.com").build();
        Customer customerTwo= Customer.builder().id(2).email("user2@gmail.com").build();
        this.customerRepository.saveAll(List.of(customerOne,customerTwo));

        // Act / When
        final List<Customer> customerList=this.customerRepository.findAll();

        // ASSERT / ThencustomerList
        Assertions.assertEquals(2,customerList.size());
    }
    @Test
    public void shouldReturnAllCustomerByEmail(){
        // Arrange / Given
        Customer customerOne= Customer.builder().id(1).email("user1@gmail.com").build();
        Customer customerTwo= Customer.builder().id(2).email("user2@gmail.com").build();
        this.customerRepository.saveAll(List.of(customerOne,customerTwo));

        // Act / When
        final Customer customer=this.customerRepository.findByEmail("user1@gmail.com");

        // ASSERT / ThencustomerList
        Assertions.assertEquals(customerOne.getId(),customer.getId());
    }
}