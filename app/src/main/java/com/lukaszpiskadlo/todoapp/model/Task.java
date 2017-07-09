package com.lukaszpiskadlo.todoapp.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Task extends RealmObject {

    @PrimaryKey
    private Long id;
    private String name;
    private String description;
    private Date dueDate;
    private boolean isDone;

    public Task() {
    }

    private Task(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.isDone = builder.isDone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private Date dueDate;
        private boolean isDone;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder isDone(boolean isDone) {
            this.isDone = isDone;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
