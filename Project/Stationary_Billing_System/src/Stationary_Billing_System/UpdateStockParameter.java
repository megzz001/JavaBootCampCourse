package Stationary_Billing_System;

class employee{
	private String name;
	private int id;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
public class UpdateStockParameter {
	public static void main(String[] args){
		employee E1 = new employee();
		E1.setName("MEGHA");
		E1.getName();
	}
}