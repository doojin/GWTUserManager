package br.dmppka.usermanager.client.service;

import br.dmppka.usermanager.client.view.HomeView;
import br.dmppka.usermanager.client.view.View;
import br.dmppka.usermanager.client.view.ViewFactory;
import com.google.inject.Inject;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;


public class NavigationService {
    public static final String URI_HOME = "";

    @Inject private ViewFactory viewFactory;
    private Map<String, String> pages;

    public NavigationService() {
        pages = newHashMap();
        pages.put(URI_HOME, HomeView.NAME);
    }

    public void loadURI(String uri) {
        String viewName = pages.get(uri);
        View view = viewFactory.getView(viewName);
        view.load();
    }

    public void setViewFactory(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }
}
