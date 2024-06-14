package webserver;

import database.PolyNamesDatabase;
import backend.dao.MotDAO;
import backend.controllers.MotController;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;

public class WebServer {
    public static void main(String[] args) throws IOException, SQLException {
        PolyNamesDatabase database = new PolyNamesDatabase("localhost", 3306, "poly_names", "root", "");
        MotDAO motDAO = new MotDAO(database);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/getMots", new CorsHandler(new MotController(motDAO)));
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }
    
}


class UserRequest {
    String username;
}

class Response {
    boolean success;

    Response(boolean success) {
        this.success = success;
    }
}
