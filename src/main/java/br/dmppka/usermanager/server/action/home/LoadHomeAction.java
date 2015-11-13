package br.dmppka.usermanager.server.action.home;

import br.dmppka.usermanager.server.model.HomeModel;
import org.springframework.stereotype.Component;

@Component
public class LoadHomeAction extends HomeAction {

    public static final String NAME = "LoadHomeAction";

    public HomeModel execute(HomeModel model) {
        return model;
    }

    public String getName() {
        return NAME;
    }
}
