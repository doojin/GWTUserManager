package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.client.ActionExecutorAsync;
import br.dmppka.usermanager.client.GWTGinjector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.Map;

public abstract class View {

    protected ActionExecutorAsync executor = GWTGinjector.INSTANCE.getActionExecutor();
    protected Panel root = new FlowPanel();

    public abstract Map<String, String> getModel();
    protected abstract void applyModel(Map<String, String> model);
    protected abstract String getLoadActionName();

    public void load() {
        execute(getLoadActionName());
    }

    protected void execute(String actionName) {
        executor.execute(actionName, getModel(), new RedrawCallback());
    }

    private void redraw(Map<String, String> model) {
        RootPanel.get().clear(true);
        root.clear();
        applyModel(model);
        RootPanel.get().add(root);
    }

    protected class RedrawCallback implements AsyncCallback<Map<String, String>> {

        public void onFailure(Throwable throwable) {
            throwable.printStackTrace();
        }

        public void onSuccess(Map<String, String> model) {
            redraw(model);
        }
    }
}
