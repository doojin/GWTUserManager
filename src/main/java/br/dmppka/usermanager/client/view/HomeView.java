package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.server.action.home.LoadHomeAction;
import br.dmppka.usermanager.server.action.manager.LoadManagerAction;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class HomeView extends View {

    public HomeView() {
        Button button = new Button();
        button.setText("Redirect to user manager");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                execute(LoadManagerAction.NAME);
            }
        });
        root.add(button);
    }

    @Override
    protected String getLoadActionName() {
        return LoadHomeAction.NAME;
    }
}
