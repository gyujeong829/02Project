package my.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import my.model.Buy;
import my.util.JdbcUtil;

public class BuyDao {
	
	public void insert(Connection conn, Buy buy) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		try {
			pstmt = conn.prepareStatement
			("insert into buy (userId,productId,amount,payment,buyDate,choice)"
					+ " values(?,?,?,?,?,?)");
			pstmt.setString(1, buy.getUserId());
			pstmt.setInt(2, buy.getProductId());
			pstmt.setInt(3, buy.getAmount());
			pstmt.setInt(4, buy.getPayment());
			pstmt.setTimestamp(5, 
					new Timestamp(buy.getBuyDate().getTime()));
			pstmt.setString(6, buy.getOption());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//sJdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	
	/*public Buy selectById(Connection conn, String cid) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		ResultSet rs = null;
		Buy buy = null; 
		try {
			pstmt = conn.prepareStatement
			("select * from buy where cid = ?");
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()){
				buy = new Buy(); 
				buy.setId(rs.getInt(1));		// 이곳은 디비 테이블에서 가져오는것이므로 아이디 필요
				buy.setCid(rs.getString(2));
				buy.setPassword(rs.getString(3));
				buy.setEmail(rs.getString(4));
				buy.setRegisterTime(rs.getTimestamp(5));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return buy;
	}
	
	public void update(Connection conn, Buy buy) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		try {
			pstmt = conn.prepareStatement
			("update buy set password=?,email=? where cid=?");
			
			pstmt.setString(1, buy.getPassword());
			pstmt.setString(2, buy.getEmail());
			pstmt.setString(3, buy.getCid());
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void deleteById(Connection conn, String cid) 
			throws SQLException {
		PreparedStatement pstmt=null; 		
		try {
			pstmt = conn.prepareStatement
			("delete from buy where cid = ?");
			pstmt.setString(1, cid);
			pstmt.executeUpdate();			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null; 
		ResultSet rs = null; 
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from buy");
			rs.next();
			return rs.getInt(1);
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
	}
	*/
	public List<Buy> selectList(Connection conn) 
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Buy> buyList = null;
		try {
			pstmt = conn.prepareStatement
					("select * from buy");
			
			rs  = pstmt.executeQuery(); 
			buyList = new ArrayList<Buy>();
			while (rs.next()){
				Buy buy = new Buy();
				buy.setBuyId(rs.getInt(1));
				buy.setUserId(rs.getString(2));
				buy.setProductId(rs.getInt(3));
				buy.setAmount(rs.getInt(4));
				buy.setPayment(rs.getInt(5));
				buy.setBuyDate(rs.getTimestamp(6));
				buy.setOption(rs.getString(7));
				buyList.add(buy);
			}
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return buyList;
	}
}




















