package com.pennat.prod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pennat.prod.dao.utils.DBUtils;
import com.pennat.prod.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	public JdbcTemplate jdbc;
	private RowMapper<Product> rm = new RowMapper<Product>() {

		public Product mapRow(ResultSet rs, int val) throws SQLException {
			Product prod = new Product();
			prod.setProdId(rs.getInt(1));
			prod.setProdName(rs.getString(2));
			prod.setPrice(rs.getInt(3));
			
			return prod;
		}
	};
	//private static Connection con = DBUtils.getConection();

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void addProduct(Product prod) {
		/*
		 * try { PreparedStatement prepareStatement =
		 * con.prepareStatement(INSERT_PRODUCT); prepareStatement.setInt(1,
		 * prod.getProdId()); prepareStatement.setString(2, prod.getProdName());
		 * prepareStatement.setInt(3, (int) prod.getPrice()); int res =
		 * prepareStatement.executeUpdate(); if (res == 0) {
		 * System.out.println("Record not inserted"); } else {
		 * System.out.println("Record saved with prodid " + prod.getProdId()); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		int res = jdbc.update(INSERT_PRODUCT, prod.getProdId(), prod.getProdName(), prod.getPrice());

		Product.display(listProducts());

	}

	public List<Product> listProducts() {
		/*
		 * Statement prepareStatement; List<Product> list = new ArrayList(); try
		 * { prepareStatement = con.createStatement(); ResultSet res =
		 * prepareStatement.executeQuery(SELECT_ALL_PRODUCT); while (res.next())
		 * { Product pro = new Product(); pro.setProdId(res.getInt(1));
		 * pro.setProdName(res.getString(2)); pro.setPrice(res.getInt(3));
		 * list.add(pro); } } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		return jdbc.query(SELECT_ALL_PRODUCT, rm);
	}

	public Product findProduct(int prodId) {
		/*
		 * Product pro = new Product(); PreparedStatement prepareStatement; try
		 * { prepareStatement = con.prepareStatement(SELECT_PRODUCT);
		 * prepareStatement.setInt(1, prodId); ResultSet res =
		 * prepareStatement.executeQuery(); while (res.next()) {
		 * pro.setProdId(res.getInt(1)); pro.setProdName(res.getString(2));
		 * pro.setPrice(res.getInt(3)); } } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */

		return jdbc.queryForObject(SELECT_PRODUCT, new Object[] { prodId }, rm);
	}

	public void deleteProduct(int prodId) {
		/*
		 * PreparedStatement prepareStatement = null; try { prepareStatement =
		 * con.prepareStatement(DELETE_PRODUCT); prepareStatement.setInt(1,
		 * prodId);
		 * 
		 * int res = prepareStatement.executeUpdate(); if (res == 0) {
		 * System.out.println("Record not deleted"); } else {
		 * System.out.println("Record deleted with prodid " + prodId); } } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */
		int res = jdbc.update(DELETE_PRODUCT, prodId);
		Product.display(listProducts());

	}

	public void updateProduct(int prodId, String newProd) {
		/*
		 * Product old = findProduct(prodId); if (old != null) {
		 * PreparedStatement prepareStatement = null; try { prepareStatement =
		 * con.prepareStatement(UPDATE_PRODUCT); prepareStatement.setString(1,
		 * newProd); prepareStatement.setInt(2, prodId); int res =
		 * prepareStatement.executeUpdate(); if (res == 0) {
		 * System.out.println("Record not Updated"); } else {
		 * System.out.println("Record Updated with prodid " + prodId +
		 * " with productName " + newProd); } } catch (SQLException e) {
		 * e.printStackTrace(); } } else {
		 * System.out.println("Product Not Found"); }
		 */
		jdbc.update(UPDATE_PRODUCT, newProd, prodId);
		Product.display(listProducts());

	}

}
