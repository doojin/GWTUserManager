package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.server.action.LoadViewAction;
import br.dmppka.usermanager.server.action.RandomNameAction;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class HomeView extends View {

    public static final String NAME = "HomeView";

    public static final String MODEL_NAME = "name";

    public HomeView() {
        Label name = new Label();
        bind(name, MODEL_NAME);

        Button button = new Button("Get my random name");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                execute(RandomNameAction.NAME);
            }
        });
        root.add(button);
        root.add(name);
    }

    @Override
    protected String getLoadActionName() {
        return LoadViewAction.NAME;
    }
}
