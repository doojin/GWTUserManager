package br.dmppka.usermanager.client;

import br.dmppka.usermanager.client.service.NavigationService;
import br.dmppka.usermanager.client.view.ViewFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(GinClientModule.class)
public interface GWTGinjector extends Ginjector {
    GWTGinjector INSTANCE = GWT.create(GWTGinjector.class);

    ActionExecutorAsync getActionExecutor();
    ViewFactory getViewFactory();
    NavigationService getNavigationService();
}
