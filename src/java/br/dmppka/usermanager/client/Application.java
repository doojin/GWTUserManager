package br.dmppka.usermanager.client;

import br.dmppka.usermanager.server.action.RandomNameAction;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.Map;

public class Application implements EntryPoint {

    private ActionExecuterAsync executer = GWT.create(ActionExecuter.class);

    public void onModuleLoad() {
        Button button = new Button("Get my random name");
        final Label label = new Label();
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                executer.execute(RandomNameAction.NAME, null, new AsyncCallback<Map<String, String>>() {
                    public void onFailure(Throwable throwable) {

                    }

                    public void onSuccess(Map<String, String> result) {
                        String name = result.get("randomName");
                        label.setText(name);
                    }
                });
            }
        });
        RootPanel.get().add(button);
        RootPanel.get().add(label);
    }
}
