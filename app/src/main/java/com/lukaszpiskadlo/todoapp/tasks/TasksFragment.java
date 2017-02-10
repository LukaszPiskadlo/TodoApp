package com.lukaszpiskadlo.todoapp.tasks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lukaszpiskadlo.todoapp.R;
import com.lukaszpiskadlo.todoapp.model.Task;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TasksFragment extends Fragment {

    @BindView(R.id.tasks_view)
    RecyclerView tasksView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        ButterKnife.bind(this, view);

        setRecyclerView();
        return view;
    }

    private void setRecyclerView() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tasks.add(new Task("Item " + i));
        }

        tasksView.setAdapter(new TaskAdapter(tasks));
        tasksView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
