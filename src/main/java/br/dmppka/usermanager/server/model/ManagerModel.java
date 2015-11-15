package br.dmppka.usermanager.server.model;

import br.dmppka.usermanager.shared.User;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public class ManagerModel extends Model {

    private ArrayList<User> users = newArrayList();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
