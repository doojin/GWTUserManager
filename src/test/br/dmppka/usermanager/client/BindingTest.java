package br.dmppka.usermanager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwtmockito.GwtMockitoTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(GwtMockitoTestRunner.class)
public class BindingTest {

    private class UnknownWidget extends Widget {
    }

    @Test
    public void getValue_shouldWorkCorrectlyForLabel() {
        Label label = GWT.create(Label.class);
        doReturn("Text value").when(label).getText();
        Binding binding = new Binding(label, null);
        String value = binding.getValue();
        assertThat(value, equalTo("Text value"));
    }

    @Test
    public void getValue_shouldReturnEmptyStringForUnknownWidget() {
        Widget widget = new UnknownWidget();
        Binding binding = new Binding(widget, null);
        String value = binding.getValue();
        assertThat(value, equalTo(""));
    }

    @Test
    public void setValue_shouldWorkCorrectlyForLabel() {
        Label label = GWT.create(Label.class);
        Binding binding = new Binding(label, null);
        binding.setValue("Some dummy value");
        verify(label, times(1)).setText("Some dummy value");
    }
}