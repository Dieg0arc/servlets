package co.edu.cue.servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// Esta anotación mapea la URL "/test" a este servlet
@WebServlet(value = "/test")
public class ServletTest extends HttpServlet {

    // Este método maneja las solicitudes GET al servlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        // Establece el tipo de contenido de la respuesta como HTML
        resp.setContentType("text/html");

        // Obtiene el método HTTP de la solicitud (GET, POST, etc.)
        String metodoHttp = req.getMethod();

        // Obtiene la URI de la solicitud
        String requestUri = req.getRequestURI();

        // Obtiene la URL de la solicitud
        String requestUrl = req.getRequestURL().toString();

        // Obtiene el contexto de la aplicación web
        String contexPath = req.getContextPath();

        // Obtiene el camino del servlet
        String servletPath = req.getServletPath();

        // Obtiene la dirección IP del cliente
        String ipCliente = req.getRemoteAddr();

        // Obtiene la dirección IP local del servidor
        String ip = req.getLocalAddr();

        // Obtiene el puerto local del servidor
        int port = req.getLocalPort();

        // Obtiene el esquema de la solicitud (http o https)
        String scheme = req.getScheme();

        // Obtiene el host de la solicitud
        String host = req.getHeader("host");

        // Construye la URL completa utilizando el esquema, el host, el contexto y el camino del servlet
        String url = scheme + "://" + host + contexPath + servletPath;

        // Construye otra URL completa que incluye la dirección IP y el puerto local
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;

        // Obtiene un objeto PrintWriter para escribir la respuesta
        try (PrintWriter out = resp.getWriter()) {
            // Escribir el inicio del documento HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Cabeceras HTTP Request</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Cabeceras HTTP Request!</h1>");
            out.println("<ul>");

            // Escribir información sobre la solicitud en la lista
            out.println("<li>metodo http: " + metodoHttp + "</li>");
            out.println("<li>request uri: " + requestUri + "</li>");
            out.println("<li>request url: " + requestUrl + "</li>");
            out.println("<li>context path: " + contexPath + "</li>");
            out.println("<li>servlet path: " + servletPath + "</li>");
            out.println("<li>ip local: " + ip + "</li>");
            out.println("<li>ip cliente: " + ipCliente + "</li>");
            out.println("<li>puerto local: " + port + "</li>");
            out.println("<li>scheme: " + scheme + "</li>");
            out.println("<li>host: " + host + "</li>");
            out.println("<li>url: " + url + "</li>");
            out.println("<li>url2: " + url2 + "</li>");

            // Obtiene todas las cabeceras HTTP de la solicitud y las escribe en la lista
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String cabecera = headerNames.nextElement();
                out.println("<li>" + cabecera + ": " + req.getHeader(cabecera) + "</li>");
            }
            // Escribir el final del documento HTML
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}


