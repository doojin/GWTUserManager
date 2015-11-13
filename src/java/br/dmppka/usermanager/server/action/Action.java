package br.dmppka.usermanager.server.action;

import java.util.Map;

public interface Action {
    Map<String, Object> execute(Map<String, Object> model);
    String getName();
}
