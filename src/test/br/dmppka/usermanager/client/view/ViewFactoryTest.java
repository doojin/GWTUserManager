package br.dmppka.usermanager.client.view;

import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

@RunWith(GwtMockitoTestRunner.class)
public class ViewFactoryTest {

    private ViewFactory viewFactory;

    @Before
    public void setUp() {
        viewFactory = new ViewFactory();
    }

    @Test
    public void getView_shouldReturnCorrectViewByName() {
        assertTrue(viewFactory.getView(HomeView.NAME) instanceof HomeView);
        assertTrue(viewFactory.getView("unknown name") instanceof HomeView);
    }
}