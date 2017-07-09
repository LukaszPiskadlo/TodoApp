package com.lukaszpiskadlo.todoapp.di.component;

import android.app.Application;
import android.content.Context;

import com.lukaszpiskadlo.todoapp.di.module.AppModule;
import com.lukaszpiskadlo.todoapp.di.module.DatabaseModule;
import com.lukaszpiskadlo.todoapp.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {

    @ApplicationContext
    Context getContext();

    Application getApplication();

    Realm getRealm();
}
