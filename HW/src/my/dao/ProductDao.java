package my.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import my.model.Product;
import my.util.JdbcUtil;

public class ProductDao {
 
 public void insert(Connection conn, Product product) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  try {
   pstmt = conn.prepareStatement
   ("insert into product (title, maker, price, productImage, productType, detail)"
     + " values(?,?,?,?,?,?)");
   pstmt.setString(1, product.getTitle());
   pstmt.setString(2, product.getMaker());
   pstmt.setInt(3, product.getPrice());
   pstmt.setString(4, product.getProductImage());
   pstmt.setString(5, product.getProductType());
   pstmt.setString(6, product.getDetail());
   pstmt.executeUpdate(); 
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
  }
 }

 public Product selectById(Connection conn, int productId) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  ResultSet rs = null;
  Product product = null; 
  try {
   pstmt = conn.prepareStatement
   ("select * from product where productId = ?");
   pstmt.setInt(1, productId);
   rs = pstmt.executeQuery();
   if (rs.next()){
    product = new Product(); 
    product.setProductId(rs.getInt(1));
    product.setTitle(rs.getString(2));
    product.setMaker(rs.getString(3));
    product.setPrice(rs.getInt(4));
    product.setProductImage(rs.getString(5));
    product.setAccessCount(rs.getInt(6));
    product.setProductType(rs.getString(7));
    product.setDetail(rs.getString(8));
   }
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
   JdbcUtil.close(rs);
  }
  return product;
 }
 
 public void update(Connection conn, Product product) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  try {
   pstmt = conn.prepareStatement
   ("update product set title=?,maker=?,price=?, "
     + "   productImage=?, productType=? , detail=?  where productId=?");
   pstmt.setString(1, product.getTitle());
   pstmt.setString(2, product.getMaker());
   pstmt.setInt(3, product.getPrice());
   pstmt.setString(4, product.getProductImage());
   pstmt.setString(5, product.getProductType());
   pstmt.setString(6, product.getDetail());
   pstmt.setInt(7, product.getProductId());
   pstmt.executeUpdate(); 
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
  }
 }
 
 
 public void updateAccessCount(Connection conn, int productId) 
   throws SQLException {
  PreparedStatement pstmt=null; 
  try {
   pstmt = conn.prepareStatement
   ("update product set accesscount=accesscount+1 where productId=?");
   pstmt.setInt(1, productId);
   pstmt.executeUpdate(); 
  } catch (SQLException e){
   e.printStackTrace();
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(pstmt);
  }
 }
 
 public void deleteById(Connection conn, int productId) 
   throws SQLException {
  PreparedStatement pstmt=null;   
  try {
   pstmt = conn.prepareStatement
   ("delete from product where productId = ?");
   pstmt.setInt(1, productId);
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
   rs = stmt.executeQuery("select count(*) from product");
   rs.next();
   return rs.getInt(1);
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(rs);
  }
 }

 public List<Product> selectList(Connection conn, String keyField, String keyword) 
   throws SQLException {
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  List<Product> productList = null;
  String sql = "select * from product";
  if(keyword !=null && !keyword.equals("")){
   sql += " where "+keyField.trim()+" like '%"+keyword.trim()+"%'";
  }
  try {
   pstmt = conn.prepareStatement(sql);
   rs  = pstmt.executeQuery(); 
   productList = new ArrayList<Product>();
   while (rs.next()){
    Product product = new Product();
    product.setProductId(rs.getInt(1));
    product.setTitle(rs.getString(2));
    product.setMaker(rs.getString(3));
    product.setPrice(rs.getInt(4));
    product.setProductImage(rs.getString(5));
    product.setAccessCount(rs.getInt(6));
    product.setProductType(rs.getString(7));
    product.setDetail(rs.getString(8));
    productList.add(product);
   }
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(rs);
   JdbcUtil.close(pstmt);
  }
  return productList;
 } 
 public List<Product> selectListCondition(Connection conn, String cond, String direct) 
   throws SQLException {
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  List<Product> productList = null;
  String sql = "select * from product ";
  if(cond !=null && !cond.equals("")){
   sql += "order by "+cond.trim()+" "+direct.trim();
  }
  try {
   pstmt = conn.prepareStatement(sql);
   rs  = pstmt.executeQuery(); 
   productList = new ArrayList<Product>();
   while (rs.next()){
    Product product = new Product();
    product.setProductId(rs.getInt(1));
    product.setTitle(rs.getString(2));
    product.setMaker(rs.getString(3));
    product.setPrice(rs.getInt(4));
    product.setProductImage(rs.getString(5));
    product.setAccessCount(rs.getInt(6));
    product.setProductType(rs.getString(7));
    product.setDetail(rs.getString(8));
    productList.add(product);
   }
  } finally {
   //JdbcUtil.close(conn);
   JdbcUtil.close(rs);
   JdbcUtil.close(pstmt);
  }
  return productList;
 } 
 
 public List<Product> selectListType(Connection conn,  String type) 
		   throws SQLException {
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  List<Product> productList = null;
		  String sql = "select * from product ";
		  if(type !=null && !type.equals("")){
		   sql += "where producttype= '"+type.trim()+"'";
		  
		  }
		  try {
		   pstmt = conn.prepareStatement(sql);
		   rs  = pstmt.executeQuery(); 
		   productList = new ArrayList<Product>();
		   while (rs.next()){
		    Product product = new Product();
		    product.setProductId(rs.getInt(1));
		    product.setTitle(rs.getString(2));
		    product.setMaker(rs.getString(3));
		    product.setPrice(rs.getInt(4));
		    product.setProductImage(rs.getString(5));
		    product.setAccessCount(rs.getInt(6));
		    product.setProductType(rs.getString(7));
		    product.setDetail(rs.getString(8));
		    productList.add(product);
		   }
		  } finally {
		   //JdbcUtil.close(conn);
		   JdbcUtil.close(rs);
		   JdbcUtil.close(pstmt);
		  }
		  return productList;
		 } 
}