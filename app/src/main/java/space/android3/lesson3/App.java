package space.android3.lesson3;

import android.app.Application;

import space.android3.lesson3.data.network.MockerService;

public class App extends Application {

public static MockerService service;

    @Override
    public void onCreate() {
        super.onCreate();
        service = new MockerService();
    }
}
