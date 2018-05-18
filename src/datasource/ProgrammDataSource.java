package datasource;

import client.Client;
import client.ClientDataBuilder;
import client.DUL;
import converter.ConvertionData;
import enums.CURRENCY_ENUM;
import interfaces.IDataSources;
import services.DbService;

public class ProgrammDataSource implements IDataSources {

    @Override
    public ConvertionData getConvertionData(int id) {

        DbService dbService = new DbService();
        dbService.createClient(1, new ClientDataBuilder(
                new Client()).builData(new DUL("passport", 4672092, "Петров И.А.")));
        dbService.createClient(2, new ClientDataBuilder(
                new Client()).builData(new DUL("passport", 467213212, "Сидоров И.А.")));

        if (id == 1) {
            return new ConvertionData(dbService.getClientById(id), 1000, CURRENCY_ENUM.USD, CURRENCY_ENUM.RUB);
        }
        return new ConvertionData(dbService.getClientById(id), 100, CURRENCY_ENUM.USD, CURRENCY_ENUM.RUB);

    }
}
