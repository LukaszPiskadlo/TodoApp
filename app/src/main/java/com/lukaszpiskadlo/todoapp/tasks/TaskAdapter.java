package com.lukaszpiskadlo.todoapp.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lukaszpiskadlo.todoapp.R;
import com.lukaszpiskadlo.todoapp.model.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private OnItemClickListener itemClickListener;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.name.setText(tasks.get(position).getName());
        holder.description.setText(tasks.get(position).getDescription());
        holder.itemView.setOnClickListener(view -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    interface OnItemClickListener {
        void onItemClick(int position);
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.task_name)
        TextView name;

        @BindView(R.id.task_description)
        TextView description;

        TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
