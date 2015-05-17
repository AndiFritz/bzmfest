package at.bischoffritz.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import at.bischoffritz.tasks.vo.Termin;

public class TerminDAO {

	public List<Termin> getAllTermins() {

		try {
			List<Termin> TeList = new ArrayList<Termin>();

			String sql = "SELECT * from tbl_times";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return TeList;
			}

			while (!rs.isAfterLast()) {
				Termin te = new Termin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				TeList.add(te);
				rs.next();
			}

			return TeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public void insertTermin(Termin te){
		
		String insertStatement = "Insert INTO tbl_times (name, date, start, end)VALUES(?,?,?,?)";

		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(insertStatement);
			ps.setString(1, te.getName());
			ps.setString(2, te.getDate());
			ps.setString(3, te.getStart());
			ps.setString(4, te.getEnd());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
	
	public void updateTermin(Termin te, int mid){
		
		String updateStatement = "UPDATE tbl_times SET name = ? date = ? start = ? end = ? WHERE id = ?";
		PreparedStatement ps;

		try {
			ps = getConnection().prepareStatement(updateStatement);
			ps.setString(1, te.getName());
			ps.setString(2, te.getDate());
			ps.setString(3, te.getStart());
			ps.setString(4, te.getEnd());
			ps.setInt(5, mid);

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void deleteTermin(int mid){
		String deleteStatement = "DELETE FROM tbl_times WHERE id = ?";
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
