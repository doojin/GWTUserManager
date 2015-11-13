package br.dmppka.usermanager.server.action.home;

import br.dmppka.usermanager.server.action.Action;
import br.dmppka.usermanager.server.model.HomeModel;
import br.dmppka.usermanager.server.model.Model;

public abstract class HomeAction implements Action<HomeModel> {

    public Class<? extends Model> getModelClass() {
        return HomeModel.class;
    }
}
