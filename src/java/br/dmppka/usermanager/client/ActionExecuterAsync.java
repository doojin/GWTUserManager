package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.Map;

public interface ActionExecuterAsync {
    void execute(String actionName, Map<String, String> model, AsyncCallback<Map<String, String>> async);
}
