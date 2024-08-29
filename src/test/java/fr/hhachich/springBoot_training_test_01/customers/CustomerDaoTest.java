package fr.hhachich.springBoot_training_test_01.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@JdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2 )
class CustomerDaoTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    CustomerDao customerDao;

    @Test
    void shouldReturnListOfCustomers() {
        // Arrange / Given
        customerDao= new CustomerDao(jdbcTemplate);
        // Act / When
        List<CustomerDTO> customerList = this.customerDao.search();
        // ASSERT / ThencustomerList
        Assertions.assertEquals(6, customerList.size());
        //Assertions.assertEquals(customerList.get(0).getEmail(),"user1@gmail.com");

    }
}