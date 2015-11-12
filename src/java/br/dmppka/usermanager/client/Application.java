package br.dmppka.usermanager.client;

import br.dmppka.usermanager.client.service.NavigationService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class Application implements EntryPoint {

    private NavigationService navigationService =
            GWTGinjector.INSTANCE.getNavigationService();

    public void onModuleLoad() {
        navigationService.loadURI(NavigationService.URI_HOME);
        addURIChangeHandler();
    }

    private void addURIChangeHandler() {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            public void onValueChange(ValueChangeEvent<String> event) {
                String uri = event.getValue();
                navigationService.loadURI(uri);
            }
        });
    }
}
