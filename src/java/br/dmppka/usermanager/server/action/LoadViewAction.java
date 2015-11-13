package br.dmppka.usermanager.server.action;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoadViewAction implements Action {

    public static final String NAME = "LoadViewAction";

    public Map<String, Object> execute(Map<String, Object> model) {
        return model;
    }

    public String getName() {
        return NAME;
    }
}
