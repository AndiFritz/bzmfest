package at.bischoffritz.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.bischoffritz.tasks.dao.TerminDAO;
import at.bischoffritz.tasks.vo.Termin;


@Path("termin")
public class TerminService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Termin> getAllTermins() throws SQLException{
		TerminDAO dao = new TerminDAO();
		return dao.getAllTermins();
		
		
	}
	
	@POST
	public Response insertTermin(Termin te){
		TerminDAO dao = new TerminDAO();
		try {
			dao.insertTermin(te);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	@PUT
	@Path("{id}")
	public Response updateTermin(Termin te, @PathParam("id") int mid){
		TerminDAO dao = new TerminDAO();
		try {
			dao.updateTermin(te, mid);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deleteTermin(@PathParam("id") int mid){
		
		try {
			TerminDAO dao = new TerminDAO();
			dao.deleteTermin(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
		
		
	}
}
