package br.dmppka.usermanager.client.widget.simple;

import br.dmppka.usermanager.client.widget.Component;
import com.google.gwt.user.client.ui.Label;

import java.io.Serializable;

public class Text extends Component {

    private Label label = new Label();

    public Text() {
        initWidget(label);
    }

    public Serializable getValue() {
        return label.getText();
    }

    public void setValue(Serializable value) {
        String val = (String) value;
        label.setText(val);
    }
}
