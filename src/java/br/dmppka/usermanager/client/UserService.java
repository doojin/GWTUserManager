package br.dmppka.usermanager.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userservice")
public interface UserService extends RemoteService {
    String getRandomName();
}
