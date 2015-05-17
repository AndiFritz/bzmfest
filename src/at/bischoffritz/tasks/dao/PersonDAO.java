package at.bischoffritz.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.bischoffritz.tasks.vo.Person;

public class PersonDAO {

	public List<Person> getAllPersons() {

		try {
			List<Person> pList = new ArrayList<Person>();

			String sql = "Select p.id, p.fname, p.lname, p.email, p.mobile, p.telephone, p.city , p.address, p.gebyear, ts.name as tshirt, ti.name as time, pl.name as place, ta.name as task from tbl_person p inner join tbl_tshirt ts ON ts.id = p.tbl_tshirt_id inner join tbl_plan on tbl_plan.tbl_person_id = p.id inner join tbl_times ti on tbl_plan.tbl_times_id = ti.id inner join tbl_task ta on tbl_plan.tbl_task_id = ta.id inner join tbl_places pl on ta.tbl_places_id = pl.id;";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return pList;
			}

			while (!rs.isAfterLast()) {
				Person p = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
				pList.add(p);
				rs.next();
			}

			return pList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public void insertPerson(Person p){
		String insertStatement = "Iinsert into tbl_person (fname, lname, email, mobile, telephone, tbl_tshirt_id) values VALUES(?,?,?,?)";

		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, p.getFname());
			ps.setString(2, p.getLname());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getMobie());
			ps.setString(5, p.getTelephone());
			ps.setString(6, p.getTshirt());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void updatePerson(Person p, int mid){
		
		String updateStatement = "UPDATE tbl_person SET fname = ? lname = ? email = ? mobile = ? telephon = ? tbl_tshirt_id = ? WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, p.getFname());
			ps.setString(2, p.getLname());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getMobie());
			ps.setString(5, p.getTelephone());
			ps.setString(6,p.getTshirt());
			ps.setInt(7, mid);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void deletePerson(int mid){
		String deleteStatement = "DELETE FROM tbl_person WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(deleteStatement);
			ps.setInt(1, mid);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

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
