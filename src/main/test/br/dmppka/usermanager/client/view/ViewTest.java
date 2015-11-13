package br.dmppka.usermanager.client.view;

import br.dmppka.usermanager.client.Binding;
import br.dmppka.usermanager.client.widget.Component;
import br.dmppka.usermanager.client.widget.simple.Text;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(GwtMockitoTestRunner.class)
public class ViewTest {

    private View view;

    @Before
    public void setUp() {
        view = new CustomView();
    }

    @Test
    public void bind_shouldUpdateBindingIfBindingWithTheSameNameExists() {
        List<Binding> bindings = view.getBindings();
        assertThat(bindings.size(), equalTo(0));

        Component widget1 = new Text();
        view.bind(widget1, "dummy name");
        assertThat(bindings.size(), equalTo(1));
        assertThat(bindings.get(0).getWidget(), equalTo(widget1));
        assertThat(bindings.get(0).getName(), equalTo("dummy name"));

        Component widget2 = new Text();
        view.bind(widget2, "dummy name");
        assertThat(bindings.size(), equalTo(1));
        assertThat(bindings.get(0).getWidget(), equalTo(widget2));
        assertThat(bindings.get(0).getName(), equalTo("dummy name"));
    }

    @Test
    public void getModel_shouldReturnCorrectModel() {
        Binding binding1 = mock(Binding.class);
        doReturn("field1").when(binding1).getName();
        doReturn("binding 1 value").when(binding1).getValue();

        Binding binding2 = mock(Binding.class);
        doReturn("field2").when(binding2).getName();
        doReturn("binding 2 value").when(binding2).getValue();

        Binding binding3 = mock(Binding.class);
        doReturn("field3").when(binding3).getName();
        doReturn("binding 3 value").when(binding3).getValue();

        view.getBindings().addAll(newArrayList(binding1, binding2, binding3));

        Map<String, Object> expectedModel = newHashMap();
        expectedModel.put("field1", "binding 1 value");
        expectedModel.put("field2", "binding 2 value");
        expectedModel.put("field3", "binding 3 value");
        Map<String, Object> actualModel = view.getModel();

        assertThat(actualModel, equalTo(expectedModel));
    }

    @Test
    public void applyModel_shouldUpdateBindings() {
        Map<String, Object> model = newHashMap();
        model.put("field1", "value1");
        model.put("field2", "value2");
        model.put("field3", "value3");

        Binding binding1 = spy(new Binding(mock(Component.class), "field1"));
        Binding binding2 = spy(new Binding(mock(Component.class), "field2"));
        Binding binding3 = spy(new Binding(mock(Component.class), "field3"));
        view.getBindings().addAll(newArrayList(binding1, binding2, binding3));

        view.applyModel(model);

        verify(binding1, times(1)).setValue("value1");
        verify(binding2, times(1)).setValue("value2");
        verify(binding3, times(1)).setValue("value3");
    }

    @Test
    public void getBinding_shouldReturnBindingByName() {
        Binding binding1 = new Binding(null, "binding1");
        Binding binding2 = new Binding(null, "binding2");
        view.getBindings().addAll(newArrayList(binding1, binding2));

        assertThat(view.getBinding("binding1"), equalTo(binding1));
        assertThat(view.getBinding("binding2"), equalTo(binding2));
        assertThat(view.getBinding("binding3"), equalTo(null));
    }

    private class CustomView extends View {
        @Override
        protected String getLoadActionName() {
            return null;
        }
    }
}