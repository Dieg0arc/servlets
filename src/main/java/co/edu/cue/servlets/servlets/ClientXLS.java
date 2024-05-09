package co.edu.cue.servlets.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import co.edu.cue.servlets.mapping.dtos.ClientDTO;
import co.edu.cue.servlets.services.ClientService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/Client.xls", "/Client.html", "/Client"})
public class ClientXLS extends HttpServlet {
    public ClientService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        List<ClientDTO> client = service.list();

        resp.setContentType("text/html;charset=UTF-8");
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=students.xls");
        }
        try (PrintWriter out = resp.getWriter()) {
            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Listado de Estudiantes</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Listado de Estudiantes!</h1>");
                out.println("<p><a href=\"" + req.getContextPath() + "/students.xls" + "\">exportar a xls</a></p>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            out.println("<th>precio</th>");
            out.println("</tr>");
            client.forEach(p ->{
                out.println("<tr>");
                out.println("<td>" + p.name() + "</td>");
                out.println("<td>" + p.idnumber() + "</td>");
                out.println("<td>" + p.phone_number() + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            if(!esXls) {
                out.println(" </body>");
                out.println("</html>");


            }}}}
