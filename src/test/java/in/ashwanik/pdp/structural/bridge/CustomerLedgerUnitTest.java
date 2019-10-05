package in.ashwanik.pdp.structural.bridge;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerLedgerUnitTest {

    @Test
    public void testBridge() {
        DataProvider<Customer> customerDataProvider = new RedisProvider<>();
        CustomerRepository customerRepository = new CustomerRepositoryImpl(customerDataProvider);
        Customer customer = new Customer();
        customer.setEmail("test@temail.com");
        customer = customerRepository.create(customer);
        assertThat(customer.getCreatedTime()).isNotNull();
    }
}
