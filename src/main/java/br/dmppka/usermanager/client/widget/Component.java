package br.dmppka.usermanager.client.widget;

import com.google.gwt.user.client.ui.Composite;

import java.io.Serializable;

public abstract class Component extends Composite {
    public abstract Serializable getValue();
    public abstract void setValue(Serializable value);
}
