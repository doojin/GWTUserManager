package br.dmppka.usermanager.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Application implements EntryPoint {

    public void onModuleLoad() {
        Button button = new Button("Get my random name");
        final Label label = new Label();
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                UserServiceAsync service = GWT.create(UserService.class);
                service.getRandomName(new AsyncCallback<String>() {
                    public void onFailure(Throwable throwable) {}

                    public void onSuccess(String s) {
                        label.setText(s);
                    }
                });
            }
        });
        RootPanel.get().add(button);
        RootPanel.get().add(label);
    }
}
