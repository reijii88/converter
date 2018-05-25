package main;

import converter.Converter;
import converter.ConvertionData;
import converter.ConvertionResult;
import datasource.FileDataSource;
import datasource.ProgrammDataSource;
import exception.ConvertionException;
import exception.PrintException;
import gui.GUI;
import server.JettyTest;
import util.Printer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ConvertionData data = new FileDataSource().getConvertionData(1); // доступны id 1(оператор) и 2(студент)
        try {
            if (data.getInputAmount() > 1000) {
                data.getOperator().createConvertationRequest(data);
            } else if (data.getInputAmount() <= 1000) {
                data.getStudent().createConvertationRequest(data);
            }
            ConvertionResult result = new Converter().convert(data);
            Printer.print(result);

        ConvertionData data1 = new ProgrammDataSource().getConvertionData(2); // доступны id 1(оператор) и 2(студент)
            if (data1.getInputAmount() > 1000) {
                data1.getOperator().createConvertationRequest(data1);
            } else if (data1.getInputAmount() <= 1000) {
                data1.getStudent().createConvertationRequest(data1);
            }
            ConvertionResult result1 = new Converter().convert(data1);
            Printer.print(result1);
        } catch (ConvertionException | PrintException e) {
            e.printStackTrace();
        }
///////////////////////////////////
        new GUI();
///////////////////////////////////

/////////////////////////////////
        //localhost:8080
/////////////////////////////////
        try {
           JettyTest.init();
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
}

