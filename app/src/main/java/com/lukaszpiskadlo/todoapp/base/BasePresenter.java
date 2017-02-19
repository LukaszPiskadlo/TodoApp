package com.lukaszpiskadlo.todoapp.base;

import android.support.annotation.NonNull;

public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public void setView(@NonNull V view) {
        this.view = view;
    }

    protected V getView() {
        return view;
    }

    protected boolean isViewAttached() {
        return view != null;
    }
}
