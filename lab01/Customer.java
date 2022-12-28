/**
 * @(#)Customer.java
 *
 *
 * @author 
 * @version 1.00 2018/1/15
 */


public class Customer {
	private String custName;
	private String custEmail;
	private boolean dietCustomer;
	//Data member to store customer FoodOrder
	public FoodOrder foodorder;
	//update constructor to initialize FoodOrder
    public Customer(String custName, String custEmail, boolean dietCustomer) {
    	this.custName = custName;
    	this.custEmail = custEmail;
    	this.dietCustomer = dietCustomer;
    	this.foodorder = new FoodOrder();
    }
    public void setCustName(String custName){
    	this.custName = custName;
    }
    public String getCustName(){
    	return custName;
    }
    public void setCustEmail(String custEmail){
    	this.custEmail = custEmail;
    }
    public String getCustEmail(){
    	return custEmail;
    }
    //getter method for food order
    public FoodOrder getFoodOrder(){
        return foodorder;
    }
    public int getTotalCalories(){
        if (dietCustomer){
            return foodorder.calculateTotalCalories()*80/100;
        }
        else return foodorder.calculateTotalCalories();
    }
    
    //get total calories
	
	
	
    public String toString(){
    	return "\n"+custName+" ["+custEmail+"]"+(dietCustomer ? " DIET ":"") + "\n";
    }
    
    
}