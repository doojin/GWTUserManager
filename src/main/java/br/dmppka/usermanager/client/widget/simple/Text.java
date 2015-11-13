package br.dmppka.usermanager.client.widget.simple;

import br.dmppka.usermanager.client.widget.Component;
import com.google.gwt.user.client.ui.Label;

public class Text extends Component {

    private Label label = new Label();

    public Text() {
        initWidget(label);
    }

    public Object getValue() {
        return label.getText();
    }

    public void setValue(Object value) {
        String val = (String) value;
        label.setText(val);
    }
}
