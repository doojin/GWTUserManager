package br.dmppka.usermanager.server;

import br.dmppka.usermanager.AppConfig;
import br.dmppka.usermanager.client.ActionExecutor;
import br.dmppka.usermanager.server.action.Action;
import br.dmppka.usermanager.server.action.RandomNameAction;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Component
public class ActionExecutorImpl extends RemoteServiceServlet implements ActionExecutor {

    private Map<String, Action> actions = newHashMap();

    @Override
    public void init() throws ServletException {
        super.init();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        actions.put(RandomNameAction.NAME, ctx.getBean(RandomNameAction.class));
    }

    public Map<String, String> execute(String actionName, Map<String, String> model) {
        Action action = actions.get(actionName);
        return action == null ? new HashMap<String, String>() : action.execute(model);
    }
}
