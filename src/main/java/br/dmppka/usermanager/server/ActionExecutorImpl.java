package br.dmppka.usermanager.server;

import br.dmppka.usermanager.AppConfig;
import br.dmppka.usermanager.client.ActionExecutor;
import br.dmppka.usermanager.server.action.Action;
import br.dmppka.usermanager.server.model.Model;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.reflections.Reflections;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;

@Component
public class ActionExecutorImpl extends RemoteServiceServlet implements ActionExecutor {

    private Map<String, Action> actions = newHashMap();
    private Mapper mapper;

    @Override
    public void init() throws ServletException {
        super.init();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        mapper = ctx.getBean(Mapper.class);

        Reflections reflections = new Reflections("br.dmppka.usermanager.server.action");
        Set<Class<? extends Action>> actionClasses = reflections.getSubTypesOf(Action.class);
        for (Class<? extends Action> actionClass : actionClasses) {
            if (Modifier.isAbstract(actionClass.getModifiers())) continue;
            Action actionInstance = ctx.getBean(actionClass);
            actions.put(actionInstance.getName(), actionInstance);
        }
    }

    public Map<String, Serializable> execute(String actionName, Map<String, Serializable> presentationModel) {
        Action action = actions.get(actionName);
        Model model = (Model) mapper.map(presentationModel, action.getModelClass());
        action.execute(model);
        return mapper.map(model, HashMap.class);
    }
}
