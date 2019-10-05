package in.ashwanik.pdp.others.dependency_injection;

import okhttp3.OkHttpClient;

public class App {
    public void initialize() {
        Injector.register(DbConnection.class, new DbConnection());
        Injector.register(OkHttpClient.class, new OkHttpClient.Builder().build());
    }
}
