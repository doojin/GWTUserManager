package br.dmppka.usermanager.server;

import br.dmppka.usermanager.server.model.HomeModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MapperTest {

    private Mapper mapper;

    @Before
    public void setUp() {
        mapper = new Mapper();
        mapper.init();
    }

    @Test
    public void map_shouldMapPresentationHomeModelToApplicationHomeModel() {
        Map<String, Object> map = newHashMap();
        map.put("name", "Dummy Name");

        HomeModel model = mapper.map(map, HomeModel.class);

        assertThat(model.getName(), equalTo("Dummy Name"));
    }

    @Test
    public void map_shouldMapApplicationHomeModelToPresentationHomeModel() {
        HomeModel model = new HomeModel();
        model.setName("Dummy Name");

        Map<String, Object> map = mapper.map(model, Map.class);

        assertThat((String) map.get("name"), equalTo("Dummy Name"));
    }

}