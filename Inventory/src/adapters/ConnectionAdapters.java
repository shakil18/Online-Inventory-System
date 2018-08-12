package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Category;
import models.Customer;
import models.Employee;
import models.Product;
import models.Stock;
import models.StockInformation;

public class ConnectionAdapters {
	public String Login(Employee emp){
		String sql = "SELECT EmployeeUsername FROM employees WHERE EmployeeUsername LIKE '"+emp.getEmpUsername()+"' AND EmployeePassword LIKE '"+emp.getEmpPassword()+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		String s ="0";
		try{
			while(rs.next()){
				s = rs.getString("EmployeeUsername");
			}
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public String returnPosition(String username){
		String sql = "SELECT EmployeePosition FROM employees WHERE EmployeeUsername = '"+username+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		String s ="";
		try{
			while(rs.next()){
				s = rs.getString("EmployeePosition");
			}
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public int returnCusId(String cusName){
		String sql = "SELECT customerId FROM customers WHERE customername = '"+cusName+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int s = 0;
		try{
			while(rs.next()){
				s = rs.getInt("customerId");
			}
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int returnEmpId(String username){
		String sql = "SELECT EmployeeId FROM employees WHERE EmployeeUsername = '"+username+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int s = 0;
		try{
			while(rs.next()){
				s = rs.getInt("EmployeeId");
			}
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int returnQuantity(int productId){
		String sql = "SELECT productQuantity FROM products WHERE productId = " + productId;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int s = 0;
		try{
			while(rs.next()){
				s = rs.getInt("productQuantity");
			}
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public void insertIntoSale(int productId, String productName, String saleCost, String saleQuantity, String saleDate, int customerId, int EmployeeId){
		String sql = "INSERT INTO sales VALUES (null, "+productId+",'"+productName+"','" +saleCost+"', '"+saleQuantity+"','"+saleDate+"',"+customerId+","+EmployeeId+")";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public String returnProductName(int id){
		String sql = "SELECT productName FROM products WHERE productId = " + id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		String s = "";
		try{
			while(rs.next()){
				s = rs.getString("productName");
			}
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public int returnPrice(int productId){
		String sql = "SELECT productPrice FROM products WHERE productId = "+productId;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int s = 0;
		String q = "";
		try{
			while(rs.next()){
				q = rs.getString("productPrice");
			}
			s = Integer.parseInt(q);
			return s;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public void updateQuantity(int quantity, int productId){
		String sql = "UPDATE products SET productQuantity = productQuantity - "+quantity+" WHERE productId = "+productId;
		String sqls = "UPDATE stock SET stockQuantity = stockQuantity - " + quantity+ " WHERE productId = "+productId;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
		da.executeQuery(sqls);
	}
	public void updateStock(int a,int id)
	{
		DataAccess da = new DataAccess();
		String sql = "UPDATE stock SET stockQuantity = stockQuantity + "+a+" WHERE productId="+id;
		String sqls = "UPDATE products SET productQuantity = productQuantity + "+a+" WHERE productId="+id;
		da.executeQuery(sql);
		da.executeQuery(sqls);
	}
	public ArrayList<Employee> getAll()
	{
		String sql = "SELECT * FROM employees WHERE NOT EmployeePosition = 'admin'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		try {
			while(rs.next())
			{
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EmployeeId"));
				emp.setEmpName(rs.getString("EmployeeName"));
				emp.setEmpPosition(rs.getString("EmployeePosition"));
				emp.setEmpPhone(rs.getString("EmployeePhone"));
				emp.setEmpSalary(rs.getString("EmployeeSalary"));
				emplist.add(emp);
			}
			return emplist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<StockInformation> stockInformation(){
		String sql = "SELECT sl.productName pn, sl.saleCost sc, sl.saleDate sd, cu.customerName cn, em.EmployeeName en, sl.saleQuantity sq "
				+ " FROM sales sl, customers cu, employees em WHERE  cu.customerId = sl.customerId and"
				+ " em.employeeId = sl.employeeId";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<StockInformation> stolist = new ArrayList<StockInformation>();
		try{
			while(rs.next()){
				StockInformation si = new StockInformation();
				si.setSoldItem(rs.getString("pn"));
				si.setEmployeerName(rs.getString("en"));
				si.setCustomerName(rs.getString("cn"));
				si.setSaleCost(rs.getString("sc"));
				si.setDate(rs.getString("sd"));
				si.setSaleQuantity(rs.getString("sq"));
				stolist.add(si);
			}
			return stolist;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public Product get(int id)
	{
		String sql = "SELECT * FROM products WHERE productId="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Product pd = new Product();
		try {
			if(rs.next())
			{	
				pd.setProductId(rs.getInt("productId"));
				pd.setProductName(rs.getString("ProductName"));
				pd.setProductPrice(rs.getString("productPrice"));
			}
			return pd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Product> getAllProduct(){
		String sql = "SELECT * FROM products";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Product> prolist = new ArrayList<Product>();
		try{
			while(rs.next()){
				Product pd = new Product();
				pd.setProductId(rs.getInt("productId"));
				pd.setProductName(rs.getString("productName"));
				pd.setProductPrice(rs.getString("productPrice"));
				pd.setProductQuantity(rs.getInt("productQuantity"));
				prolist.add(pd);
			}
			return prolist;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Customer> getAllCustomer(){
		String sql = "SELECT * FROM customers";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Customer> cuslist = new ArrayList<Customer>();
		try{
			while(rs.next()){
				Customer cus = new Customer();
				cus.setCustomerId(rs.getInt("customerId"));
				cus.setCustomerName(rs.getString("customerName"));
				cus.setCustomerAddress(rs.getString("customerAddress"));
				cus.setCustomerPhone(rs.getString("customerPhone"));
				cuslist.add(cus);
			}
			return cuslist;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Category> getAllCategoryName(){
		String sql = "SELECT categoryName FROM categories ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Category> catlist = new ArrayList<Category>();
		try{
			while(rs.next()){
				Category cat = new Category();
				cat.setCategoryName(rs.getString("categoryName"));
				catlist.add(cat);
			}
			return catlist;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM products WHERE productId="+id;
		String sqls="DELETE FROM stock WHERE productId ="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
		da.executeQuery(sqls);
	}
	public void update(Product pd, int a, int id)
	{
		String sql = "UPDATE products SET ProductName='"+pd.getProductName()+"', productPrice='"+pd.getProductPrice()+"', categoryId='"+a+"' WHERE productId='"+id+"'";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void insert(Product pd, int a)
	{
		String sql = "INSERT INTO products VALUES (null, '"+pd.getProductName()+"', "+pd.getProductPrice()+", '"+pd.getProductQuantity()+"', "+a+")";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void insertIntoStock(Product pd){
		String sql = "INSERT INTO stock VALUES (null, "+pd.getProductId()+", '"+pd.getProductName()+"', 0)";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public int returnRecentProduct(){
		String sql = "SELECT MAX(productId) FROM products";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int productId = 0;
		try{
			while(rs.next()){
				productId = rs.getInt("MAX(productId)");
			}
			return productId;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public int returnCategoryId(String categoryName){
		String sql = "SELECT categoryId FROM categories WHERE categoryName = '"+categoryName+"'";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int a = 0;
		try{
			while(rs.next()){
				a = rs.getInt("categoryId");
			}
			return a;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public ArrayList<Stock> getAllStock(){
		String sql = "SELECT * FROM stock";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Stock> stolist = new ArrayList<Stock>();
		try{
			while(rs.next()){
				Stock st = new Stock();
				st.setStockId(rs.getInt("stockId"));
				st.setProductId(rs.getInt("productId"));
				st.setProductName(rs.getString("productName"));
				st.setStockQuantity(rs.getInt("stockQuantity"));
				stolist.add(st);
			}
			return stolist;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<Product> searchCategory(int cateId){
		String sql = "SELECT * FROM products WHERE categoryId = "+cateId;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Product> searchlist = new ArrayList<Product>();
		try{
			while(rs.next()){
				Product pd = new Product();
				pd.setProductId(rs.getInt("productId"));
				pd.setProductName(rs.getString("productName"));
				pd.setProductPrice(rs.getString("productPrice"));
				searchlist.add(pd);
			}
			return searchlist;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
}
