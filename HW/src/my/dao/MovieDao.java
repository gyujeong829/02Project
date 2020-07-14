package my.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import my.model.Movie;
import my.util.JdbcUtil;

public class MovieDao {
 
 public void insert(Connection conn, Movie movie) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  try {
   pstmt = conn.prepareStatement
   ("insert into movie (title, maker, price, movieImage, movieType)"
     + " values(?,?,?,?,?)");
   pstmt.setString(1, movie.getTitle());
   pstmt.setString(2, movie.getMaker());
   pstmt.setInt(3, movie.getPrice());
   pstmt.setString(4, movie.getMovieImage());
   pstmt.setString(5, movie.getMovieType());
   pstmt.executeUpdate(); 
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
  }
 }

 public Movie selectById(Connection conn, int movieId) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  ResultSet rs = null;
  Movie movie = null; 
  try {
   pstmt = conn.prepareStatement
   ("select * from movie where movieId = ?");
   pstmt.setInt(1, movieId);
   rs = pstmt.executeQuery();
   if (rs.next()){
    movie = new Movie(); 
    movie.setMovieId(rs.getInt(1));
    movie.setTitle(rs.getString(2));
    movie.setMaker(rs.getString(3));
    movie.setPrice(rs.getInt(4));
    movie.setMovieImage(rs.getString(5));
    movie.setAccessCount(rs.getInt(6));
    movie.setMovieType(rs.getString(7));
   }
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
   JdbcUtil.close(rs);
  }
  return movie;
 }
 
 public void update(Connection conn, Movie movie) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  try {
   pstmt = conn.prepareStatement
   ("update movie set title=?,maker=?,price=?, "
     + "   movieImage=?, movieType=? where movieId=?");
   pstmt.setString(1, movie.getTitle());
   pstmt.setString(2, movie.getMaker());
   pstmt.setInt(3, movie.getPrice());
   pstmt.setString(4, movie.getMovieImage());
   pstmt.setString(5, movie.getMovieType());
   pstmt.setInt(6, movie.getMovieId());
   pstmt.executeUpdate(); 
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
  }
 }
 
 
 public void updateAccessCount(Connection conn, int movieId) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  try {
   pstmt = conn.prepareStatement
   ("update movie set accesscount=accesscount+1 where movieId=?");
   pstmt.setInt(1, movieId);
   pstmt.executeUpdate(); 
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
  }
 }
 
 public void deleteById(Connection conn, int movieId) 
   throws SQLException {
  PreparedStatement pstmt=null;   
  try {
   pstmt = conn.prepareStatement
   ("delete from movie where movieId = ?");
   pstmt.setInt(1, movieId);
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
   rs = stmt.executeQuery("select count(*) from movie");
   rs.next();
   return rs.getInt(1);
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(rs);
  }
 }

 public List<Movie> selectList(Connection conn, String keyField, String keyword) 
   throws SQLException {
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  List<Movie> movieList = null;
  String sql = "select * from movie";
  if(keyword !=null && !keyword.equals("")){
   sql += " where "+keyField.trim()+" like '%"+keyword.trim()+"%'";
  }
  try {
   pstmt = conn.prepareStatement(sql);
   rs  = pstmt.executeQuery(); 
   movieList = new ArrayList<Movie>();
   while (rs.next()){
    Movie movie = new Movie();
    movie.setMovieId(rs.getInt(1));
    movie.setTitle(rs.getString(2));
    movie.setMaker(rs.getString(3));
    movie.setPrice(rs.getInt(4));
    movie.setMovieImage(rs.getString(5));
    movie.setAccessCount(rs.getInt(6));
    movie.setMovieType(rs.getString(7));
    movieList.add(movie);
   }
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(rs);
   JdbcUtil.close(pstmt);
  }
  return movieList;
 } 
 public List<Movie> selectListCondition(Connection conn, String cond, String direct) 
   throws SQLException {
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  List<Movie> movieList = null;
  String sql = "select * from movie ";
  if(cond !=null && !cond.equals("")){
   sql += "order by "+cond.trim()+" "+direct.trim();
  }
  try {
   pstmt = conn.prepareStatement(sql);
   rs  = pstmt.executeQuery(); 
   movieList = new ArrayList<Movie>();
   while (rs.next()){
    Movie movie = new Movie();
    movie.setMovieId(rs.getInt(1));
    movie.setTitle(rs.getString(2));
    movie.setMaker(rs.getString(3));
    movie.setPrice(rs.getInt(4));
    movie.setMovieImage(rs.getString(5));
    movie.setAccessCount(rs.getInt(6));
    movie.setMovieType(rs.getString(7));
    movieList.add(movie);
   }
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(rs);
   JdbcUtil.close(pstmt);
  }
  return movieList;
 } 
 
 public List<Movie> selectListType(Connection conn,  String type) 
		   throws SQLException {
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  List<Movie> movieList = null;
		  String sql = "select * from movie ";
		  if(type !=null && !type.equals("")){
		   sql += "where movietype= '"+type.trim()+"'";
		  }
		  try {
		   pstmt = conn.prepareStatement(sql);
		   rs  = pstmt.executeQuery(); 
		   movieList = new ArrayList<Movie>();
		   while (rs.next()){
		    Movie movie = new Movie();
		    movie.setMovieId(rs.getInt(1));
		    movie.setTitle(rs.getString(2));
		    movie.setMaker(rs.getString(3));
		    movie.setPrice(rs.getInt(4));
		    movie.setMovieImage(rs.getString(5));
		    movie.setAccessCount(rs.getInt(6));
		    movie.setMovieType(rs.getString(7));
		    movieList.add(movie);
		   }
		  } finally {
		   //JdbcUtil.close(conn);
		   JdbcUtil.close(rs);
		   JdbcUtil.close(pstmt);
		  }
		  return movieList;
		 } 
}