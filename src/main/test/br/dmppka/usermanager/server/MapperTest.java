package br.dmppka.usermanager.server;

import org.junit.Before;

public class MapperTest {

    private Mapper mapper;

    @Before
    public void setUp() {
        mapper = new Mapper();
        mapper.init();
    }
}