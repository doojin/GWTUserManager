package br.dmppka.usermanager.client.service;

import br.dmppka.usermanager.client.view.HomeView;
import br.dmppka.usermanager.client.view.View;
import br.dmppka.usermanager.client.view.ViewFactory;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(GwtMockitoTestRunner.class)
public class NavigationServiceTest {

    private NavigationService service;
    private ViewFactory viewFactory;

    @Before
    public void setUp() {
        viewFactory = mock(ViewFactory.class);
        service = new NavigationService();
        service.setViewFactory(viewFactory);
    }

    @Test
    public void loadURI_shouldLoadCorrectView() {
        View view = spy(new HomeView());
        doReturn(view).when(viewFactory).getView(anyString());
        service.loadURI(NavigationService.URI_HOME);
        verify(view, times(1)).load();
    }
}