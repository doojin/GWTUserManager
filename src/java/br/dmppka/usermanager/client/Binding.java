package br.dmppka.usermanager.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Binding {

    private Widget widget;
    private String name;

    public Binding(Widget widget, String name) {
        this.widget = widget;
        this.name = name;
    }

    public String getValue() {
        String value = "";
        if (widget instanceof Label) value = ((Label) widget).getText();
        return value;
    }

    public void setValue(String value) {
        if (widget instanceof Label) ((Label) widget).setText(value);
    }

    public String getName() {
        return name;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }
}
