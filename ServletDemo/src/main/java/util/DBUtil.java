package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class DBUtil {
	
	public static List<Todo> getTodos() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Todo> lists = new ArrayList<>();
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Lists";
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();		
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String done = rs.getString("done");
				//System.out.println(title + " : " + done);
				lists.add(new Todo(id, title, done));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return lists;
	}
	
	public static Todo getTodo(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String title = null, done = null;
		
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Lists where id = ?";
			// or String insertSQL = "insert into Lists value(?, ?) ";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			System.out.println(selectSQL);
			// preparedStatement.setString(2, title);
			ResultSet rs = preparedStatement.executeQuery();	
			while(rs.next()) {
				title = rs.getString("title");
				done = rs.getString("done");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return new Todo(id, title, done);
	}

	public static void insertTodo(String title, String done) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String insertSQL = "insert into Lists (title, done) values (\"" + title + "\",\"" + done + "\")";
			System.out.println(insertSQL);
			// or String insertSQL = "insert into Lists value(?, ?) ";
			preparedStatement = connection.prepareStatement(insertSQL);
			// preparedStatement.setString(1, title);
			// preparedStatement.setString(2, title);
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void deleteTodo(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String deleteSQL = "delete from Lists where id = ?";
			System.out.println(deleteSQL);
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, Integer.parseInt(id));
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void updateTodo(String id, String title) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String updateSQL = "update Lists set title = ? where id = ? ";
//			System.out.println(deleteSQL);
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, Integer.parseInt(id));
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
