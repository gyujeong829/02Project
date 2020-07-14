package my.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import my.model.Tmember;
import my.util.JdbcUtil;

public class TmemberDao {
	
	public void insert(Connection conn, Tmember tmember) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		try {
			pstmt = conn.prepareStatement
			("insert into tmember (userId, password, name, birthDate)"
					+ " values(?,?,?,?)");
			pstmt.setString(1, tmember.getUserId());
			pstmt.setString(2, tmember.getPassword());
			pstmt.setString(3, tmember.getName());
			pstmt.setTimestamp(4, new Timestamp(tmember.getBirthDate().getTime()));
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}

	public String selectPasswordById(Connection conn, String userId) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		ResultSet rs = null;
		String password = null;
		try {
			pstmt = conn.prepareStatement
			("select password from tmember where userId = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()){
				password = rs.getString(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return password;
	}
	
	public Tmember selectById(Connection conn, String userId) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		ResultSet rs = null;
		Tmember tmember = null;
		try {
			pstmt = conn.prepareStatement
			("select * from tmember where userId = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()){
				tmember = new Tmember();
				tmember.setMemberId(rs.getInt(1)); 
				tmember.setUserId(rs.getString(2));
				tmember.setPassword(rs.getString(3));
				tmember.setName(rs.getString(4)); 
				tmember.setBirthDate(rs.getTimestamp(5));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return tmember;
	}
	
	public List<Tmember> selectList(Connection conn) 
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Tmember> tmemberList = null;
		try {
			pstmt = conn.prepareStatement
					("select * from tmember");
			rs  = pstmt.executeQuery(); 
			tmemberList = new ArrayList<Tmember>();
			while (rs.next()){
				Tmember tmember = new Tmember();
				tmember.setMemberId(rs.getInt(1));
				tmember.setUserId(rs.getString(2));
				tmember.setPassword(rs.getString(3));
				tmember.setName(rs.getString(4));
				tmember.setBirthDate(rs.getTimestamp(5));
				tmemberList.add(tmember);
			}
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return tmemberList;
	}	
	
	public void update(Connection conn, Tmember tmember) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		try {
			pstmt = conn.prepareStatement
			("update tmember set password=?,name=?, "
					+ "   birthDate=? where userId=?");
			pstmt.setString(1, tmember.getPassword());
			pstmt.setString(2, tmember.getName());
			pstmt.setTimestamp(3, new Timestamp(tmember.getBirthDate().getTime()));
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	public void deleteById(Connection conn, String userId) 
			throws SQLException {
		PreparedStatement pstmt=null; 		
		try {
			pstmt = conn.prepareStatement
			("delete from tmember where userId = ?");
			pstmt.setString(1, userId);
			pstmt.executeUpdate();			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}	
	}
}