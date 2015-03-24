package ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.daos.DaoFactory;
import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import ws.TemaUris;

@Path("/temas")
public class TemaSource {

    private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
    }

    public TemaSource() {

    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(@QueryParam("nombre") String nombre,
            @QueryParam("pregunta") String pregunta) {
        Response result;
        Tema tema = new Tema(nombre, pregunta);
        DaoFactory.getFactory().getTemaDao().create(tema);
        result = Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getNombre())).build();
        this.debug(" /POST: " + tema.getNombre());

        return result;
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Integer id) {

    }
}
