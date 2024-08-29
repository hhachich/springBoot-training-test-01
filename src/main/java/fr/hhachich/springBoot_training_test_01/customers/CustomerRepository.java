package fr.hhachich.springBoot_training_test_01.customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
}
