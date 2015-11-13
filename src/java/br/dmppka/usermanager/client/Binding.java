package br.dmppka.usermanager.client;

import br.dmppka.usermanager.client.widget.Component;

public class Binding {

    private Component widget;
    private String name;

    public Binding(Component widget, String name) {
        this.widget = widget;
        this.name = name;
    }

    public Object getValue() {
        return widget.getValue();
    }

    public void setValue(Object value) {
        widget.setValue(value);
    }

    public String getName() {
        return name;
    }

    public Component getWidget() {
        return widget;
    }

    public void setWidget(Component widget) {
        this.widget = widget;
    }
}
