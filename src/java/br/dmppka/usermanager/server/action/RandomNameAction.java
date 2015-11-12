package br.dmppka.usermanager.server.action;

import br.dmppka.usermanager.client.view.HomeView;
import br.dmppka.usermanager.server.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Component
public class RandomNameAction implements Action {

    public static final String NAME = "RandomNameAction";

    @Autowired
    private NameService nameService;

    public Map<String, String> execute(Map<String, String> model) {
        Map<String, String> result = newHashMap();
        result.put(HomeView.MODEL_NAME, nameService.getRandomName());
        return result;
    }
}
