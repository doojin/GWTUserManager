package br.dmppka.usermanager.client.widget.complex;

import br.dmppka.usermanager.client.widget.Component;
import br.dmppka.usermanager.shared.User;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;

import java.io.Serializable;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public class UserTable extends Component {

    private static final String COLUMN_USER_NAME = "Name";
    private static final String COLUMN_USER_AGE = "Age";
    private static final String COLUMN_USER_ADDRESS = "Address";

    private CellTable<User> table;
    private ArrayList<User> values;

    public UserTable() {
        table = new CellTable<User>();
        TextColumn<User> nameColumn = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getName();
            }
        };
        table.addColumn(nameColumn, COLUMN_USER_NAME);
        TextColumn<User> ageColumn = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return Integer.toString(user.getAge());
            }
        };
        table.addColumn(ageColumn, COLUMN_USER_AGE);
        TextColumn<User> addressColumn = new TextColumn<User>() {
            @Override
            public String getValue(User user) {
                return user.getAddress();
            }
        };
        table.addColumn(addressColumn, COLUMN_USER_ADDRESS);
        setValue(newArrayList());
        initWidget(table);
    }

    @Override
    public Serializable getValue() {
        return values;
    }

    @Override
    public void setValue(Serializable value) {
        this.values = (ArrayList<User>) value;
        table.setRowCount(values.size());
        table.setRowData(0, values);
    }
}
