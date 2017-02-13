package com.lukaszpiskadlo.todoapp.di.component;

import com.lukaszpiskadlo.todoapp.di.module.FragmentModule;
import com.lukaszpiskadlo.todoapp.tasks.TasksFragment;

import dagger.Component;

@Component(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(TasksFragment fragment);
}
