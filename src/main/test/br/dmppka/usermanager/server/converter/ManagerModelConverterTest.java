package br.dmppka.usermanager.server.converter;

import br.dmppka.usermanager.server.model.ManagerModel;
import br.dmppka.usermanager.shared.User;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ManagerModelConverterTest {

    private ManagerModelConverter converter;

    @Before
    public void setUp() {
        converter = new ManagerModelConverter();
    }

    @Test
    public void map_shouldMapManagerModelToHashMap() {
        ManagerModel model = new ManagerModel();
        User u1 = new User();
        u1.setId(1);
        u1.setName("name1");
        u1.setAge(1);
        u1.setAddress("addr1");
        User u2 = new User();
        u2.setId(2);
        u2.setName("name2");
        u2.setAge(2);
        u2.setAddress("addr2");
        ArrayList<User> users = newArrayList(u1, u2);
        model.setUsers(users);
        model.setRedirectURI("dummy redirect uri");

        Map<String, Serializable> result =  converter.convertFrom(model);

        assertThat(result.get("users"), CoreMatchers.<Object>equalTo(users));
    }

    @Test
    public void map_shouldMapHashMapToManagerModel() {
        Map<String, Serializable> map = newHashMap();
        User u1 = new User();
        u1.setId(1);
        u1.setName("name1");
        u1.setAge(1);
        u1.setAddress("addr1");
        User u2 = new User();
        u2.setId(2);
        u2.setName("name2");
        u2.setAge(2);
        u2.setAddress("addr2");
        ArrayList<User> users = newArrayList(u1, u2);
        map.put("users", users);

        ManagerModel model = converter.convertTo(map);

        assertThat(model.getUsers(), equalTo(users));
    }
}