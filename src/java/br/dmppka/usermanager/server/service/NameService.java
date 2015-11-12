package br.dmppka.usermanager.server.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class NameService {

    private List<String> names;

    @PostConstruct
    public void init() {
        names = newArrayList();
        names.add("Alexander");
        names.add("Boris");
        names.add("Valentin");
        names.add("Vlad");
        names.add("Gennady");
        names.add("David");
        names.add("Ivan");
        names.add("Konstantin");
        names.add("Nikita");
        names.add("Igor");
    }

    public String getRandomName() {
        int index = ThreadLocalRandom.current().nextInt(names.size());
        return names.get(index);
    }
}
