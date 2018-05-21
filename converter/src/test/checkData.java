import client.Client;
import client.ClientDataBuilder;
import client.DUL;
import converter.ConvertionData;
import enums.CURRENCY_ENUM;
import org.junit.Assert;
import org.junit.Test;




public class checkData {
    @Test
    public void ammount(){
        Client client = new ClientDataBuilder()
                .builData(new DUL("passport", 9090231,"Иванов Иван Иванович"));
        ConvertionData data = new ConvertionData(client,1000, CURRENCY_ENUM.USD,CURRENCY_ENUM.RUB);
        data.getOperator().check(data);
        Assert.assertEquals(data.getClient().getDul().getFullname(),
                data.getClient().getFullName());
        Assert.assertEquals(1000.0,data.getInputAmount(),0.1);
        Assert.assertEquals("passport",data.getClient().getDul().getType());
        Assert.assertNotNull(data.getClient());
        Assert.assertNotNull(data.getClient().getDul());
    }

}
