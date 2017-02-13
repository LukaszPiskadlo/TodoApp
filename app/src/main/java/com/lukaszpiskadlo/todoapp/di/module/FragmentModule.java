package com.lukaszpiskadlo.todoapp.di.module;

import com.lukaszpiskadlo.todoapp.tasks.TaskAdapter;
import com.lukaszpiskadlo.todoapp.tasks.TasksPresenter;

import java.util.Collections;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @Provides
    TaskAdapter provideTaskAdapter() {
        return new TaskAdapter(Collections.emptyList());
    }

    @Provides
    TasksPresenter provideTasksPresenter() {
        return new TasksPresenter();
    }
}
