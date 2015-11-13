package br.dmppka.usermanager.server.action;

import br.dmppka.usermanager.server.model.Model;

public interface Action <T extends Model> {
    T execute(T model);
    String getName();
    Class<? extends Model> getModelClass();
}
