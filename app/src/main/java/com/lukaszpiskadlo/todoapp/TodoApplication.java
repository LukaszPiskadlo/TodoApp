package com.lukaszpiskadlo.todoapp;

import android.app.Application;

import com.lukaszpiskadlo.todoapp.di.component.AppComponent;
import com.lukaszpiskadlo.todoapp.di.component.DaggerAppComponent;
import com.lukaszpiskadlo.todoapp.di.module.AppModule;
import com.lukaszpiskadlo.todoapp.di.module.DatabaseModule;


public class TodoApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
