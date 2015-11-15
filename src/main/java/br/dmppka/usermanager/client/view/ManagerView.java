package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.client.widget.complex.UserTable;
import br.dmppka.usermanager.server.action.manager.LoadManagerAction;

public class ManagerView extends View {

    public static final String MODEL_USERS = "users";

    public ManagerView() {
        UserTable userTable = bind(new UserTable(), MODEL_USERS);

        root.add(userTable);
    }

    @Override
    protected String getLoadActionName() {
        return LoadManagerAction.NAME;
    }
}
