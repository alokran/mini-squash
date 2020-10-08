package com.project.game.controller;

import com.project.game.view.AbstractView;

import java.util.List;

public class ViewController implements Controller {

    private List<AbstractView> view;

    public ViewController(List<AbstractView> view) {
        this.view = view;
    }

    @Override
    public void handleEvent() {
        view.forEach(AbstractView::update);
    }
}
