package interfaces;

import converter.ConvertionData;

import java.io.IOException;

public interface IDataSources {

    ConvertionData getConvertionData(int id) throws IOException;

}
