package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
    void getRandomName(AsyncCallback<String> async);
}
