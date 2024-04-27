package co.edu.cue.servlets.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.model.Client;
import co.edu.cue.servlets.services.ClientService;
import co.edu.cue.servlets.services.impl.ClientServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value="/client.json")
public class StudentJson extends HttpServlet {

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
        ServletException, IOException {
    ServletInputStream jsonStream = req.getInputStream();
    ObjectMapper mapper = new ObjectMapper();
    ClientDTO client = mapper.readValue(jsonStream, ClientDTO.class);
    resp.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println(" <head>");
        out.println(" <meta charset=\"UTF-8\">");
        out.println(" <title>Detalle del cliente desde json</title>");
        out.println(" </head>");
        out.println(" <body>");
        out.println(" <h1>Detalle del cliente desde json!</h1>");
        out.println("<ul>");
        out.println("<li>Numero de identificacion: "+ client.idnumber() + "</li>");
        out.println("<li>Nombre: " + client.name() + "</li>");
        out.println("<li>Numero telefonico: " + client.phone_number() + "</li>");
        out.println("</ul>");
        out.println(" </body>");
        out.println("</html>");
    }
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        ClientService service = new ClientServiceImpl();
        List<ClientDTO> client = null;
        try {
            client = service.listar();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(client);
            resp.setContentType("application/json");
            resp.getWriter().write(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
}
}


}
