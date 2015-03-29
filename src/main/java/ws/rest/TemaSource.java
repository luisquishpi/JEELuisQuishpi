package ws.rest;

import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.daos.DaoFactory;
import models.entities.Tema;
import org.apache.logging.log4j.LogManager;
import ws.TemaUris;

@Path(TemaUris.PATH_TEMAS)
public class TemaSource {

    private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Tema tema) {
        Response result;
        DaoFactory.getFactory().getTemaDao().create(tema);
        result = Response.created(URI.create(TemaUris.PATH_TEMAS)).build();
        this.debug(" /POST: create Tema Id:" + tema.getId());
        return result;
    }

    @Path(TemaUris.PATH_ID_PARAM)
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        DaoFactory.getFactory().getTemaDao().deleteById(id);
        this.debug("/" + id + " /DELETE");
    }

}
