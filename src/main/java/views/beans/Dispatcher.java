package views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.entities.Tema;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/jsps/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view;
        switch (action) {
        case "newTema":
            NewTemaView temaView=new NewTemaView();
            request.setAttribute(action, temaView);
            view = action;
            break;
        case "removeTema":
            RemoveTemaView removeTemaView = new RemoveTemaView();
            request.setAttribute(action, removeTemaView);
            view = action;
            break;
        default:
            view = "home";
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        Tema tema = new Tema();
        switch (action) {
        case "newTema":
            tema.setNombre(request.getParameter("nombre"));
            tema.setPregunta(request.getParameter("pregunta"));
            NewTemaView temaView = new NewTemaView();
            temaView.setTema(tema);
            request.setAttribute(action, temaView);
            view = temaView.process();
            break;
        case "removeTema":
            tema.setId(Integer.parseInt(request.getParameter("tema")));
            tema.setClave(request.getParameter("clave"));
            RemoveTemaView removeTemaView = new RemoveTemaView();
            removeTemaView.setTema(tema);
            request.setAttribute(action, removeTemaView);
            view = removeTemaView.process();
            break;
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
