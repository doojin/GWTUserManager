package br.dmppka.usermanager.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class GinClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(ActionExecutorAsync.class).in(Singleton.class);
    }
}
