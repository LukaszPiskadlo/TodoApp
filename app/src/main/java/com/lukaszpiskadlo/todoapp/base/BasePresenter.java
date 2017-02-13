package com.lukaszpiskadlo.todoapp.base;

public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public void setView(V view) {
        this.view = view;
    }

    protected V getView() {
        return view;
    }

    protected boolean isViewAttached() {
        return view != null;
    }
}
