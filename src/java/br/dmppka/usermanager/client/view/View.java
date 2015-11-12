package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.client.ActionExecutorAsync;
import br.dmppka.usermanager.client.Binding;
import br.dmppka.usermanager.client.GWTGinjector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public abstract class View {

    protected ActionExecutorAsync executor = GWTGinjector.INSTANCE.getActionExecutor();
    protected Panel root = new FlowPanel();
    private List<Binding> bindings = newArrayList();

    protected abstract String getLoadActionName();

    public void load() {
        execute(getLoadActionName());
    }

    <T extends Widget> T bind(T widget, String name) {
        Binding binding = getBinding(name);
        if (binding != null) {
            binding.setWidget(widget);
            return widget;
        }
        bindings.add(new Binding(widget, name));
        return widget;
    }

    Map<String, String> getModel() {
        Map<String, String> model = newHashMap();
        for (Binding binding : bindings) {
            model.put(binding.getName(), binding.getValue());
        }
        return model;
    }

    void applyModel(Map<String, String> model) {
        for (Map.Entry entry : model.entrySet()) {
            String name = (String) entry.getKey();
            Binding binding = getBinding(name);
            if (binding != null) {
                String value = (String) entry.getValue();
                binding.setValue(value);
            }
        }
    }

    @Nullable
    Binding getBinding(String name) {
        for (Binding binding : bindings) {
            if (name.equals(binding.getName())) {
                return binding;
            }
        }
        return null;
    }

    protected void execute(String actionName) {
        executor.execute(actionName, getModel(), new RedrawCallback());
    }

    private void redraw(Map<String, String> model) {
        RootPanel.get().clear(true);
        applyModel(model);
        RootPanel.get().add(root);
    }

    public List<Binding> getBindings() {
        return bindings;
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
