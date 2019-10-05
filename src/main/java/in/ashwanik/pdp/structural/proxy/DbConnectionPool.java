package in.ashwanik.pdp.structural.proxy;

public class DbConnectionPool {

    public static DatabaseConnection newConnection() {
        return new DatabaseConnection();
    }
}
