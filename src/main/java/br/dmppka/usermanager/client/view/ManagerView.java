package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.client.widget.simple.Text;
import br.dmppka.usermanager.server.action.manager.LoadManagerAction;

public class ManagerView extends View {

    public ManagerView() {
        Text text = new Text();
        text.setValue("Hello, Manager!");
        root.add(text);
    }

    @Override
    protected String getLoadActionName() {
        return LoadManagerAction.NAME;
    }
}
