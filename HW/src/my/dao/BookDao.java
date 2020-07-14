package my.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import my.model.Book;
import my.util.JdbcUtil;

public class BookDao {
	
	public void insert(Connection conn, Book book) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		try {
			pstmt = conn.prepareStatement
			("insert into book (name,price,registerDate)"
					+ " values(?,?,?)");
			pstmt.setString(1, book.getName());
			pstmt.setInt(2, book.getPrice());
			
			pstmt.setTimestamp(3, 
					new Timestamp(book.getRegisterDate().getTime()));
			pstmt.executeUpdate(); 
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
	}
	
	/*public Book selectById(Connection conn, String cid) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		ResultSet rs = null;
		Book book = null; 
		try {
			pstmt = conn.prepareStatement
			("select * from book where cid = ?");
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()){
				book = new Book(); 
				book.setId(rs.getInt(1));		// 이곳은 디비 테이블에서 가져오는것이므로 아이디 필요
				book.setCid(rs.getString(2));
				book.setPassword(rs.getString(3));
				book.setEmail(rs.getString(4));
				book.setRegisterTime(rs.getTimestamp(5));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return book;
	}
	
	public void update(Connection conn, Book book) 
			throws SQLException {
		PreparedStatement pstmt=null; 
		try {
			pstmt = conn.prepareStatement
			("update book set password=?,email=? where cid=?");
			
			pstmt.setString(1, book.getPassword());
			pstmt.setString(2, book.getEmail());
			pstmt.setString(3, book.getCid());
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
			("delete from book where cid = ?");
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
			rs = stmt.executeQuery("select count(*) from book");
			rs.next();
			return rs.getInt(1);
		} finally {
			//JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
	}
	*/
	public List<Book> selectList(Connection conn) 
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> bookList = null;
		try {
			pstmt = conn.prepareStatement
					("select * from book");
			
			rs  = pstmt.executeQuery(); 
			bookList = new ArrayList<Book>();
			while (rs.next()){
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setRegisterDate(rs.getTimestamp(4));
				bookList.add(book);
			}
		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return bookList;
	}
}




















