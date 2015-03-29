package ws.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.daos.DaoFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudio;

import org.apache.logging.log4j.LogManager;

import ws.VotoUris;

@Path(VotoUris.PATH_VOTAR)
public class VotoSource {

    private void debug(String msg) {
        LogManager.getLogger(this.getClass()).debug(VotoUris.PATH_VOTAR + msg);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response votar(Tema tema,@QueryParam("nivelEstudio") NivelEstudio nivelEstudio,
            @QueryParam("valorVoto") int valor) {
        Response result;
        Voto voto=new Voto();
        voto.setTema(tema);
        voto.setNivelEstudio(nivelEstudio);
        voto.setValor(valor);
        DaoFactory.getFactory().getVotoDao().create(voto);
        result = Response.created(URI.create(VotoUris.PATH_VOTAR)).build();
        this.debug(" /POST: create Voto Id:" + voto.getId());
        return result;
    }
}
