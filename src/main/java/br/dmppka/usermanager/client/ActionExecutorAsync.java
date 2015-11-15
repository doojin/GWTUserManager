package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.io.Serializable;
import java.util.Map;

public interface ActionExecutorAsync {
    void execute(String actionName, Map<String, Serializable> model, AsyncCallback<Map<String, Serializable>> async);
}
