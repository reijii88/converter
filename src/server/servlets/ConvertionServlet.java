package server.servlets;

import client.Client;
import converter.Converter;
import converter.ConvertionData;
import converter.ConvertionResult;
import enums.CURRENCY_ENUM;
import services.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/convertion")
public class ConvertionServlet extends HttpServlet {
private DbService dbService;
    public void init() {
        System.out.println("ServletInitalization");
        dbService = new DbService();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html, charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("\n" +
                "<html>" +
                "  <header>" +
                "<meta charset=UTF-8>" +
                "  </header>" +
                "    <body>" +
                "        <form name=\"converter\" method=\"post\" action=\"/convertion\">\n" +
                "        <label> Введите сумму</label><input type=number name=inputAmm value=0 />\n" +
                "        <label> Выберите исходную валюту</label>\n" +
                "            <select name=currencyIn>\n" +
                "                <option> USD </option>\n" +
                "                <option> RUB </option>\n" +
                "                <option> EUR </option>\n" +
                "                </select >\n" +
                "\n" +
                "        <label> Выберите целевую валюту</label>\n" +
                "            <select name= currencyOut>\n" +
                "                <option> USD </option>\n" +
                "                <option> RUB </option>\n" +
                "                <option> EUR </option>\n" +
                "                </select>\n" +
                "                <br>\n" +
                "\n" +
                "                <input type=\"submit\" value=\"PUSH ME\" />\n" +
                "                </form>\n" +
                "\n" +
                "                </body>\n" +
                "                </html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("UTF-8");
        Double input = Double.parseDouble(req.getParameter("inputAmm"));
        String inputCurrency = req.getParameter("currencyIn");
        String outputCurrency = req.getParameter("currencyOut");
        System.out.println("LOG: " + input + " " + inputCurrency + " " + outputCurrency);

        Client client = (Client) req.getSession().getAttribute("client");
        System.out.println(client.getDul() + " " + client.getFullName());

        ConvertionData data = new ConvertionData(client, input
                , CURRENCY_ENUM.valueOf(inputCurrency), CURRENCY_ENUM.valueOf(outputCurrency));

        ConvertionResult result = new Converter().convert(data);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<html>" +
                "<header>" +
                "<meta charset=UTF-8>" +
                "</header>" +
                "<body>" +
                "======================================= <br>" +
                "Клиент: " + result.getClient().getFullName() + "<br>" +
                "Оператор: " + result.getStatus() + "<br>" +
                "Денег получено: " + String.format("%.2f", result.getInputAmount())  +
                " " + result.getInputCurrency() + "<br>" +
                "Денег выдано: " + String.format("%.2f", result.getResultAmount())  +
                " " + result.getResultCurrency() + "<br>" +
                "Курс: " + String.format("%.2f%n", result.getRate()) + "<br>" +
                "======================================= <br>" +

                "</body></html>");
    }
}
