package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.Map;

public interface ActionExecutorAsync {
    void execute(String actionName, Map<String, Object> model, AsyncCallback<Map<String, Object>> async);
}
