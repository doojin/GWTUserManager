package br.dmppka.usermanager.server.converter;

import br.dmppka.usermanager.client.view.ManagerView;
import br.dmppka.usermanager.server.model.ManagerModel;
import br.dmppka.usermanager.shared.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class ManagerModelConverter extends ModelConverter<ManagerModel> {

    @Override
    protected Map<String, Serializable> convertFrom(ManagerModel model) {
        Map<String, Serializable> map = newHashMap();
        map.put(ManagerView.MODEL_USERS, model.getUsers());
        return map;
    }

    @Override
    protected ManagerModel convertTo(Map<String, Serializable> map) {
        ManagerModel model = new ManagerModel();
        model.setUsers((ArrayList<User>) map.get(ManagerView.MODEL_USERS));
        return model;
    }
}
