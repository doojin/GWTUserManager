package br.dmppka.usermanager.client;

import br.dmppka.usermanager.client.service.NavigationService;
import br.dmppka.usermanager.client.view.ViewFactory;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class GinClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(ActionExecutorAsync.class).in(Singleton.class);
        bind(ViewFactory.class).in(Singleton.class);
        bind(NavigationService.class).in(Singleton.class);
    }
}
