package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.io.Serializable;
import java.util.Map;

@RemoteServiceRelativePath("actionexecuter")
@SuppressWarnings("NonSerializableServiceParameters")
public interface ActionExecutor extends RemoteService {
    Map<String, Serializable> execute(String actionName, Map<String, Serializable> model);
}
