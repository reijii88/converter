package datasource;

import client.Client;
import client.ClientDataBuilder;
import client.DUL;
import converter.ConvertionData;
import enums.CURRENCY_ENUM;
import interfaces.IDataSources;
import services.DbService;

import java.io.*;

public class FileDataSource implements IDataSources {

    private FileInputStream fis;
    private BufferedInputStream bif;
    private DUL dul;
    private DbService dbService;

    @Override
    public ConvertionData getConvertionData(int id) throws IOException {

        try {
            StringBuilder sb = new StringBuilder();
            fis = new FileInputStream(new File("./resources/client.txt"));
            bif = new BufferedInputStream(fis);
            int count = -1;
            while ((count = bif.read()) != -1) {
                sb.append((char) count);
            }
            dbService = new DbService();
            if(id == 1) {
                String[] str = sb.toString().split("\n");
                String client = str[id];
                String[] split = client.split(",");
                dul = new DUL();
                dul.setFullname(split[1]);
                dul.setType(split[2]);
                dul.setNumber(Integer.parseInt(split[3]));
                dbService.createClient(Integer.parseInt(split[0]), new ClientDataBuilder(
                        new Client()).builData(dul));

            return new ConvertionData(dbService.getClientById(id),Double.valueOf(split[4]),
                    CURRENCY_ENUM.valueOf(split[5]),CURRENCY_ENUM.valueOf(split[6]));
            }else{
                String[] str = sb.toString().split("\n");
                String client = str[id];
                String[] split = client.split(",");
                dul = new DUL();
                dul.setFullname(split[1]);
                dul.setType(split[2]);
                dul.setNumber(Integer.parseInt(split[3]));
                dbService.createClient(Integer.parseInt(split[0]), new ClientDataBuilder(
                        new Client()).builData(dul));

                return new ConvertionData(dbService.getClientById(id),Double.valueOf(split[4]),
                        CURRENCY_ENUM.valueOf(split[5]),CURRENCY_ENUM.valueOf(split[6]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bif.close();
            fis.close();
        }
        return null;
    }
}
