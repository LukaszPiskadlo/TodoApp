package com.lukaszpiskadlo.todoapp.di.module;

import android.content.Context;

import com.lukaszpiskadlo.todoapp.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    Realm provideRealm(@ApplicationContext Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        return Realm.getDefaultInstance();
    }
}
