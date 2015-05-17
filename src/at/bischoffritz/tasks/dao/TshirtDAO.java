package at.bischoffritz.tasks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import at.bischoffritz.tasks.vo.Tshirt;

public class TshirtDAO {

	public List<Tshirt> getAllTshirts() {

		try {
			List<Tshirt> TsList = new ArrayList<Tshirt>();

			String sql = "SELECT * from tbl_tshirt";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (!rs.first()) {
				return TsList;
			}

			while (!rs.isAfterLast()) {
				Tshirt ts = new Tshirt(rs.getInt(1), rs.getString(2));
				TsList.add(ts);
				rs.next();
			}

			return TsList;
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
