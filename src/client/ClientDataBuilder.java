package client;

import java.util.UUID;

public class ClientDataBuilder {
    private Client client;

    public ClientDataBuilder(Client client) {
    this.client = client;
    }

    public ClientDataBuilder() {
        this.client = new Client();
    }

    public  Client builData(DUL dul) {
        UUID uuid = UUID.randomUUID();
        this.client.setId(uuid);
        this.client.setFullName(dul.getFullname());
        this.client.setDul(dul);
        return  client;
    }

}
