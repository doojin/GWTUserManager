package br.dmppka.usermanager.server.action.manager;

import br.dmppka.usermanager.server.action.Action;
import br.dmppka.usermanager.server.model.ManagerModel;
import br.dmppka.usermanager.server.model.Model;
import br.dmppka.usermanager.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadManagerAction implements Action<ManagerModel>{

    public static final String NAME = "LoadManagerAction";

    @Autowired private UserRepository userRepository;

    public ManagerModel execute(ManagerModel model) {
        model.setRedirectURI("manager");
        model.setUsers(userRepository.getAll());
        return model;
    }

    public String getName() {
        return NAME;
    }

    public Class<? extends Model> getModelClass() {
        return ManagerModel.class;
    }
}
