package fr.hhachich.springBoot_training_test_01.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;
    @Test
    void shouldReturnAllCustomers(){
        // Arrange / Given
        Customer customerOne= Customer.builder().id(1).email("user1@gmail.com").build();
        Customer customerTwo= Customer.builder().id(2).email("user2@gmail.com").build();
        Mockito.when(this.customerRepository.findAll()).thenReturn(List.of(customerOne,customerTwo));

        // Act / When
        final List<CustomerDTO> customerList=this.customerService.search();

        // ASSERT / ThencustomerList
        Assertions.assertEquals(2,customerList.size());
    }

    @Test
    void shouldReturnCustomerById(){
        // Arrange / Given
        Customer customerOne= Customer.builder().id(1).email("user1@gmail.com").build();
        Mockito.when(this.customerRepository.findById(1)).thenReturn(Optional.of(customerOne));

        // Act / When
        final CustomerDTO customerDTO=this.customerService.read(1);

        // ASSERT / ThencustomerList
        Assertions.assertEquals(customerOne.getId(),customerDTO.getId());
    }

    @Test
    void shouldThrowExceptionCustomerById(){
        // Arrange / Given
        Mockito.when(this.customerRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        // Act / When
        // ASSERT / ThencustomerList
        final IllegalArgumentException exception = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        ()->this.customerService.read(1)
                );
        assertEquals("No customer for id: 1",exception.getMessage());
    }
}