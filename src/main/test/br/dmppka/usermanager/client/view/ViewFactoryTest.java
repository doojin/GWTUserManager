package br.dmppka.usermanager.client.view;

import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(GwtMockitoTestRunner.class)
public class ViewFactoryTest {

    private ViewFactory viewFactory;

    @Before
    public void setUp() {
        viewFactory = new ViewFactory();
    }

    @Test
    public void getView_shouldReturnCorrectViewByName() {
        assertThat(viewFactory.getView(HomeView.NAME) instanceof HomeView, is(true));
        assertThat(viewFactory.getView("unknown name") instanceof HomeView, is(true));
    }
}