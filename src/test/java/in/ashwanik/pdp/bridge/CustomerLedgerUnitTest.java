package in.ashwanik.pdp.bridge;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerLedgerUnitTest {

    @Test
    public void testBridge() {
        DataProvider<Customer> customerDataProvider = new RedisProvider<>();
        CustomerRepository customerRepository = new CustomerRepositoryImpl(customerDataProvider);

        Customer customer = customerRepository.create(Customer.builder().email("email.com").build());
        assertThat(customer.getCreatedTime()).isNotNull();
    }
}
