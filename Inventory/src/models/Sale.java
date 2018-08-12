package models;

public class Sale {
	private int saleId;
	private int productId;
	private String saleCost = "";
	private String saleQuantity = "";
	private String saleDate = "";
	private int customerId;
	private int EmployeeId;
	private String msg = "";
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getSaleCost() {
		return saleCost;
	}
	public void setSaleCost(String saleCost) {
		this.saleCost = saleCost;
	}
	public String getSaleQuantity() {
		return saleQuantity;
	}
	public void setSaleQuantity(String saleQuantity) {
		this.saleQuantity = saleQuantity;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
}
