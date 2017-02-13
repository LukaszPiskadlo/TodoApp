package com.lukaszpiskadlo.todoapp.tasks;

import com.lukaszpiskadlo.todoapp.base.BasePresenter;
import com.lukaszpiskadlo.todoapp.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TasksPresenter extends BasePresenter<TasksView> {

    void loadTasks() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tasks.add(new Task.Builder().name("Task " + i).description("Desc").build());
        }
        if (isViewAttached()) {
            getView().showTasks(tasks);
        }
    }
}
