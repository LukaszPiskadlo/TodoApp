package com.lukaszpiskadlo.todoapp.di.module;

import android.app.Application;
import android.content.Context;

import com.lukaszpiskadlo.todoapp.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }
}
