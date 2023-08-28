package rsConto;


import Conto.Dao.DaoConti;
import Conto.Dao.DaoException;
import Conto.Dto.Conti;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/conto")
public class ContoResource {
    static DaoConti daoConti = new DaoConti();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conti> getAllConti() throws DaoException {
        return daoConti.getAll();
    }

    @GET
    @Path("/{testo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Conti> getCommentoById(@PathParam("testo") String testo) throws DaoException {
        List<Conti> c = daoConti.findByText(testo);
        if(c == null){
            throw new NotFoundException("conto non esiste");
        }
        return c;
    }

}
