package br.dmppka.usermanager.server;

import br.dmppka.usermanager.client.UserService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {

    public String getRandomName() {
        List<String> names = new ArrayList<String>();
        names.add("Dmitry");
        names.add("Elizabeth");
        names.add("Evgeny");
        names.add("Alexander");
        names.add("Anatoly");
        names.add("Evlampy");
        names.add("Anton");
        names.add("Maria");
        int randomIndex = (int) (Math.random() * names.size() - 1);
        return names.get(randomIndex);
    }
}
