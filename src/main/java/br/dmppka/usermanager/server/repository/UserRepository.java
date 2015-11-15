package br.dmppka.usermanager.server.repository;

import br.dmppka.usermanager.shared.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserRepository {

    private ArrayList<User> values = newArrayList();
    private int id = 0;

    @PostConstruct
    public void init() {
        User u1 = new User();
        u1.setId(++id);
        u1.setName("Alexander Bull");
        u1.setAge(15);
        u1.setAddress("Avoru street 64, Jelgava, Latvia");

        User u2 = new User();
        u2.setId(++id);
        u2.setName("Evgenia Katisheva");
        u2.setAge(47);
        u2.setAddress("Tukuma street 129, Daugavpils, Latvia");

        User u3 = new User();
        u3.setId(++id);
        u3.setName("Anatoly Pyatkin");
        u3.setAge(27);
        u3.setAddress("Lenin street 845, Moscow, Russia");

        values.addAll(newArrayList(u1, u2, u3));
    }

    public ArrayList<User> getAll() {
        return values;
    }
}
