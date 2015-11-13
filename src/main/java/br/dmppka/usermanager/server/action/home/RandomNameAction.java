package br.dmppka.usermanager.server.action.home;

import br.dmppka.usermanager.server.model.HomeModel;
import br.dmppka.usermanager.server.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomNameAction extends HomeAction {

    public static final String NAME = "RandomNameAction";

    @Autowired
    private NameService nameService;

    public HomeModel execute(HomeModel model) {
        model.setName(nameService.getRandomName());
        return model;
    }

    public String getName() {
        return NAME;
    }
}
