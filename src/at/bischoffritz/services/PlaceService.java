package at.bischoffritz.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bischoffritz.tasks.dao.PlaceDAO;
import at.bischoffritz.tasks.vo.Place;


@Path("places")
public class PlaceService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Place> getAllPlaces() throws SQLException{
		PlaceDAO dao = new PlaceDAO();
		return dao.getAllPlaces();
		
		
	}
}
