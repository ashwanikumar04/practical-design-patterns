package in.ashwanik.pdp.proxy;

public class DbConnectionPool {

    public static DatabaseConnection newConnection() {
        return new DatabaseConnection();
    }
}
