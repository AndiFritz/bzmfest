package at.bischoffritz.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bischoffritz.tasks.dao.WorkerDAO;
import at.bischoffritz.tasks.vo.Worker;


@Path("workers")
public class WorkerService {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Worker> getAllWorkers() throws SQLException{
		WorkerDAO dao = new WorkerDAO();
		return dao.getAllWorkers();
		
		
	}
}
