package br.dmppka.usermanager.server.action;

import java.util.Map;

public interface Action {
    Map<String, String> execute(Map<String, String> model);
}
