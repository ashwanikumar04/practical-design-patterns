package in.ashwanik.pdp.structural.bridge;

public interface CustomerRepository {
    Customer create(Customer customer);

    Customer update(Customer customer);

    Customer get(long id);
}
