package at.bischoffritz.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.bischoffritz.tasks.vo.Person;
import at.bischoffritz.tasks.vo.Worker;

public class WorkerDAO {

	public List<Worker> getAllWorkers() {

		try {
			List<Worker> wList = new ArrayList<Worker>();

			String sql = "Select p.id, p.fname, p.lname, p.email, p.mobile, p.telephone, ts.name as tshirt, ti.date, ti.start, ti.end, pl.name as place, ta.name as task from tbl_person p inner join tbl_tshirt ts ON ts.id = p.tbl_tshirt_id inner join tbl_plan on tbl_plan.tbl_person_id = p.id inner join tbl_times ti on tbl_plan.tbl_times_id = ti.id inner join tbl_task ta on tbl_plan.tbl_task_id = ta.id inner join tbl_places pl on ta.tbl_places_id = pl.id;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return wList;
			}

			while (!rs.isAfterLast()) {
				Worker w = new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
				wList.add(w);
				rs.next();
			}

			return wList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	

	
	private Connection getConnection() {
		try {
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/personmanager?"
							+ "user=root&password=root123");
			return conn;
			// Do something with the Connection
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
