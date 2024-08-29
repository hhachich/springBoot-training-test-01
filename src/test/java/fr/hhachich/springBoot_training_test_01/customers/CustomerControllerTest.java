package fr.hhachich.springBoot_training_test_01.customers;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CustomerService customerService;

    @DisplayName("[CustomerControllerTest] test list of customer")
    @Test
    void shouldReturnAllCustomers() throws Exception {
        CustomerDTO customerOne= new CustomerDTO(1,"user1@gmail.com");
        CustomerDTO customerTwo= new CustomerDTO(2,"user2@gmail.com");
        Mockito.when(this.customerService.search()).thenReturn(List.of(customerOne,customerTwo));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("user1")));

    }

    @Test
    void shouldReturnOneCustomer() throws Exception {
        CustomerDTO customerOne= new CustomerDTO(1,"user1@gmail.com");
        Mockito.when(this.customerService.read(Mockito.anyInt())).thenReturn(customerOne);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customerOne.getEmail()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
}