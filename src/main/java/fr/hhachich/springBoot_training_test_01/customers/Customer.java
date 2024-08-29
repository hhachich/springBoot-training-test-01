package fr.hhachich.springBoot_training_test_01.customers;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
}
