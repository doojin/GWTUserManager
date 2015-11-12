package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.Map;

@RemoteServiceRelativePath("actionexecuter")
public interface ActionExecuter extends RemoteService {
    public Map<String, String> execute(String actionName, Map<String, String> model);
}
