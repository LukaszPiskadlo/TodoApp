package com.lukaszpiskadlo.todoapp.tasks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.lukaszpiskadlo.todoapp.R;
import com.lukaszpiskadlo.todoapp.di.component.DaggerFragmentComponent;
import com.lukaszpiskadlo.todoapp.model.Task;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TasksFragment extends Fragment implements TasksView {

    @BindView(R.id.tasks_view)
    RecyclerView tasksView;

    @Inject
    TasksPresenter presenter;

    @Inject
    TaskAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        ButterKnife.bind(this, view);

        DaggerFragmentComponent.create()
                .inject(this);

        presenter.setView(this);
        setHasOptionsMenu(true);
        setRecyclerView();
        presenter.loadTasks();
        return view;
    }

    private void setRecyclerView() {
        adapter.setOnItemClickListener(position -> presenter.showTaskDetails(position));

        tasksView.setAdapter(adapter);
        tasksView.setLayoutManager(new LinearLayoutManager(getContext()));
        tasksView.setHasFixedSize(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_tasks_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                presenter.searchTasks();
                return true;
            case R.id.filter:
                presenter.filterTasks();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.add_fab)
    public void addTask() {
        presenter.showAddNewTask();
    }

    @Override
    public void showTasks(List<Task> tasks) {
        adapter.setTasks(tasks);
    }
}
