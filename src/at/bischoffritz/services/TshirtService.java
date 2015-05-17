package at.bischoffritz.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bischoffritz.tasks.dao.TshirtDAO;
import at.bischoffritz.tasks.vo.Tshirt;


@Path("tshirts")
public class TshirtService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Tshirt> getAllTshirts() throws SQLException{
		TshirtDAO dao = new TshirtDAO();
		return dao.getAllTshirts();
		
		
	}
}
