package fr.hhachich.springBoot_training_test_01.customers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static  String FIND_ALL="select * from customers";

    private RowMapper<CustomerDTO> customerRowMapper=(rs, name)-> new CustomerDTO(rs.getInt("id"),rs.getString("email"));
    public List<CustomerDTO> search(){
        return this.jdbcTemplate.query(FIND_ALL,customerRowMapper);
    }
}
