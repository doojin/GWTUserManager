package br.dmppka.usermanager.client.service;

import br.dmppka.usermanager.client.view.View;
import br.dmppka.usermanager.client.view.ViewFactory;
import com.google.inject.Inject;

public class NavigationService {
    public static final String URI_HOME = "";
    public static final String URI_MANAGER = "manager";

    @Inject private ViewFactory viewFactory;

    public void loadURI(String uri) {
        View view = viewFactory.getView(uri);
        view.load();
    }

    public void setViewFactory(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }
}
