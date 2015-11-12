package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.server.action.LoadViewAction;
import br.dmppka.usermanager.server.action.RandomNameAction;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

import java.util.HashMap;
import java.util.Map;

public class HomeView extends View {

    public static final String NAME = "HomeView";

    public static final String MODEL_NAME = "name";

    private final Label name = new Label();

    @Override
    public Map<String, String> getModel() {
        Map<String, String> model = new HashMap<String, String>();
        model.put(MODEL_NAME, name.getText());
        return model;
    }

    @Override
    public void applyModel(Map<String, String> model) {
        Button button = new Button("Get my random name");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                execute(RandomNameAction.NAME);
            }
        });
        name.setText(model.get(MODEL_NAME));
        root.add(button);
        root.add(name);
    }

    @Override
    protected String getLoadActionName() {
        return LoadViewAction.NAME;
    }
}
