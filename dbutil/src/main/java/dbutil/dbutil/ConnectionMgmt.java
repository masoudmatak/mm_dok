/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/
package dbutil.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionMgmt {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) {
			return conn;
		} else {

			try {
				InitialContext cxt = new InitialContext();

				DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/MasDok");

				conn = ds.getConnection();
			} catch (SQLException e) {

			} catch (Exception e) {
				return null;
			}
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {

			conn.close(); // Return to connection pool
			conn = null; // Make sure we don't close it twice
		} catch (SQLException e) {

		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					;
				}
				conn = null;
			}
		}
	}

}