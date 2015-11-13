package br.dmppka.usermanager.client.view;

public class ViewFactory {

    public View getView(String name) {
        if (HomeView.NAME.equals(name)) return new HomeView();
        return new HomeView();
    }
}
