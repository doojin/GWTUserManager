package br.dmppka.usermanager.server;

import br.dmppka.usermanager.AppConfig;
import br.dmppka.usermanager.client.ActionExecutor;
import br.dmppka.usermanager.server.action.Action;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.reflections.Reflections;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;

@Component
public class ActionExecutorImpl extends RemoteServiceServlet implements ActionExecutor {

    private Map<String, Action> actions = newHashMap();

    @Override
    public void init() throws ServletException {
        super.init();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Reflections reflections = new Reflections("br.dmppka.usermanager.server.action");
        Set<Class<? extends Action>> actionClasses = reflections.getSubTypesOf(Action.class);
        for (Class<? extends Action> actionClass : actionClasses) {
            Action actionInstance = ctx.getBean(actionClass);
            actions.put(actionInstance.getName(), actionInstance);
        }
    }

    public Map<String, Object> execute(String actionName, Map<String, Object> model) {
        Action action = actions.get(actionName);
        return action == null ? new HashMap<String, Object>() : action.execute(model);
    }
}
