package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.client.service.NavigationService;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class ViewFactory {

    private Map<String, ViewCreator> viewCreators = newHashMap();

    public ViewFactory() {
        viewCreators.put(NavigationService.URI_HOME, new HomeViewCreator());
        viewCreators.put(NavigationService.URI_MANAGER, new ManagerViewCreator());
    }

    public View getView(String uri) {
        ViewCreator creator = viewCreators.get(uri);
        creator = (creator == null) ? new HomeViewCreator() : creator;
        return creator.create();
    }

    private interface ViewCreator {
        View create();
    }

    private class HomeViewCreator implements ViewCreator {
        public View create() {
            return new HomeView();
        }
    }

    private class ManagerViewCreator implements ViewCreator {
        public View create() {
            return new ManagerView();
        }
    }
}
