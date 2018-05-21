package server.servlets;

import client.Client;
import client.ClientDataBuilder;
import client.DUL;
import services.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {

    public void init(){

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(
                "<!DOCTYPE html>" +
                        "<html lang=ru-RU>" +
                        "<head>" +
                        "    <meta charset=UTF-8>" +
                        "    <title>Title</title>" +
                        "</head>" +
                        "<body>" +

                        "<form method=post action=/createUser>" +
                        "    <input type=text name=sName value=Ivanov>" +
                        "    <input type=text name=fName value=Ivan>" +
                        "    <input type=text name=lName value=Ivanovich>" +
                        "    <input type=text name=docType value=PASSPORT>" +
                        "    <input type=text name=docNumber value=90909099>" +
                        "    <input type=submit value=Press>" +
                        "</form>" +
                        "</body>" +
                        "</html>");


    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        request.setCharacterEncoding("UTF-8");

        String fName = request.getParameter("fName") ;
        String lName = request.getParameter("lName");
        String sName = request.getParameter("sName") ;
        String docType = request.getParameter("docType");
        String docNumber = request.getParameter("docNumber");
        String fullName = sName + " " + fName + " " + lName;

        Client client = new ClientDataBuilder().builData(new DUL(
                docType,Integer.parseInt(docNumber),fullName));

        new DbService().createClient(1,client);
        HttpSession session = request.getSession();
        session.setAttribute("client",client);


        response.sendRedirect("/convertion");
    }

}
