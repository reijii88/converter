package server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import server.servlets.ConvertionServlet;
import server.servlets.CreateUserServlet;

public class JettyTest extends Server {

    private static final int PORT = 8080;

    public static void init() throws Exception {
        CreateUserServlet cus = new CreateUserServlet();
        ConvertionServlet cs = new ConvertionServlet();

        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(cus), "/createUser");
        context.addServlet(new ServletHolder(cs), "/convertion");
        context.setWelcomeFiles(new String[]{"/index.html"});

        ResourceHandler rh = new ResourceHandler();
        rh.setResourceBase("WEB-INF");


        HandlerList list = new HandlerList();
        list.setHandlers(new Handler[]{rh, context});

        Server server = new Server(PORT);
        server.setHandler(list);


        server.start();
        System.out.println("LOG: serverStart");
        server.join();
    }


}
