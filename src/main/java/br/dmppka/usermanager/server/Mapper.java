package br.dmppka.usermanager.server;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class Mapper extends DozerBeanMapper {

    @PostConstruct
    public void init() {
        this.setMappingFiles(
                newArrayList(
                        "mapping/homeModel.xml",
                        "mapping/managerModel.xml"
                )
        );
    }
}
