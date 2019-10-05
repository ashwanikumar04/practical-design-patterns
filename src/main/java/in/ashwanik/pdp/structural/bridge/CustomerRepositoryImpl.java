package in.ashwanik.pdp.structural.bridge;

public class CustomerRepositoryImpl implements CustomerRepository {

    private DataProvider<Customer> customerDataProvider;

    CustomerRepositoryImpl(DataProvider<Customer> dataProvider) {
        this.customerDataProvider = dataProvider;
    }

    @Override
    public Customer create(Customer customer) {
        return customerDataProvider.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerDataProvider.update(customer);
    }

    @Override
    public Customer get(long id) {
        return customerDataProvider.get(id);
    }
}
