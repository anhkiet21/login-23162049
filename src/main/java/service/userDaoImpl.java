package service;

import model.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBconfig.DBconfig;

public class userDaoImpl implements userDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public user get(String username) {
		String sql = "SELECT * FROM `users` WHERE username = ?"; // dùng backtick hoặc đổi tên bảng
		try {
			conn = DBconfig.getConnection(); // static method rồi, không cần new
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			if (rs.next()) { // chỉ cần if thay vì while vì username duy nhất
				user u = new user();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignored) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignored) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception ignored) {
			}
		}
		return null;
	}

	@Override
	public void insert(user u) {
		String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
		try {
			conn = new DBconfig().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
	    boolean duplicate = false;
	    String query = "SELECT * FROM users WHERE email = ?";
	    try {
	        conn = new DBconfig().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, email);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            duplicate = true;
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); } catch (Exception ignored) {}
	        try { if (ps != null) ps.close(); } catch (Exception ignored) {}
	        try { if (conn != null) conn.close(); } catch (Exception ignored) {}
	    }
	    return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
	    boolean duplicate = false;
	    String query = "SELECT * FROM users WHERE username = ?";
	    try {
	        conn = new DBconfig().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, username);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            duplicate = true;
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        try { if (rs != null) rs.close(); } catch (Exception ignored) {}
	        try { if (ps != null) ps.close(); } catch (Exception ignored) {}
	        try { if (conn != null) conn.close(); } catch (Exception ignored) {}
	    }
	    return duplicate;
	}

	

}
