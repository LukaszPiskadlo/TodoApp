package com.lukaszpiskadlo.todoapp.tasks;

import com.lukaszpiskadlo.todoapp.base.BaseView;
import com.lukaszpiskadlo.todoapp.model.Task;

import java.util.List;

interface TasksView extends BaseView{

    void showTasks(List<Task> tasks);
}
