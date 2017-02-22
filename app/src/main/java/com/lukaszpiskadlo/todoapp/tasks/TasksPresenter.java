package com.lukaszpiskadlo.todoapp.tasks;

import com.lukaszpiskadlo.todoapp.base.BasePresenter;
import com.lukaszpiskadlo.todoapp.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TasksPresenter extends BasePresenter<TasksView> {

    private List<Task> tasks;

    public TasksPresenter() {
        tasks = new ArrayList<>();
    }

    void loadTasks() {
        for (int i = 0; i < 30; i++) {
            tasks.add(new Task.Builder().name("Task " + i).description("Desc").build());
        }
        if (isViewAttached()) {
            getView().showTasks(tasks);
        }
    }

    void searchTasks() {
    }

    void filterTasks() {
    }

    void showTaskDetails(int position) {
    }

    void showAddNewTask() {
    }
}
