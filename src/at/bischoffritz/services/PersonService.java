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

import at.bischoffritz.tasks.dao.PersonDAO;
import at.bischoffritz.tasks.vo.Person;


@Path("person")
public class PersonService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Person> getAllPersons() throws SQLException{
		PersonDAO dao = new PersonDAO();
		return dao.getAllPersons();
		
		
	}
	
	@POST
	public Response insertPerson(Person p){
		PersonDAO dao = new PersonDAO();
		try {
			dao.insertPerson(p);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
		
	}
	
	@PUT
	@Path("{id}")
	public Response updatePerson(Person p, @PathParam("id") int mid){
		PersonDAO dao = new PersonDAO();
		try {
			dao.updatePerson(p, mid);
			return Response.ok().build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} 
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") int mid){
		
		try {
			PersonDAO dao = new PersonDAO();
			dao.deletePerson(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
		
		
	}
}
