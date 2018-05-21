package services;

import client.Client;

import java.util.HashMap;
import java.util.Map;

public class DbService {

    private Map<Integer, Client> clientData = new HashMap<>();

    public void createClient(int id, Client client) {
        if (!clientData.containsValue(client.getFullName())) {
            clientData.put(id, client);
        }

    }


    public Client getClientById(int id) {


        if (clientData.containsKey(id)) {
            return clientData.get(id);
        }

        return null;

    }


}
