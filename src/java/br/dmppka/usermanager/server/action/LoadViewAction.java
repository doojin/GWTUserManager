package br.dmppka.usermanager.server.action;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoadViewAction implements Action {
    public static final String NAME = "LoadViewAction";

    public Map<String, String> execute(Map<String, String> model) {
        return model;
    }
}
