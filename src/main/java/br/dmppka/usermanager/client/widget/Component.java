package br.dmppka.usermanager.client.widget;

import com.google.gwt.user.client.ui.Composite;

public abstract class Component extends Composite {
    public abstract Object getValue();
    public abstract void setValue(Object value);
}
