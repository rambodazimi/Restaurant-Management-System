
public class Owner extends IncomeTaxPayer {

	final private int incomeTaxPct = 10;
	private double salaryExpenses;

	private FoodPlace foodPlace;

	public Owner(String name) {
		
		//sets the name of this owner
		super(name);
	}

	
	public FoodPlace getFoodPlace() { 
		return foodPlace; 
	} 
	
	
	public int getIncomeTaxPct() {
		return incomeTaxPct;
	}

	public double getSalaryExpenses() {
		return salaryExpenses;
	}

	public void setSalaryExpenses(double salaryExpenses) {
		this.salaryExpenses = salaryExpenses;
	}

	public void setFoodPlace(FoodPlace foodPlace) {
		this.foodPlace = foodPlace;
	}

	@Override
	//NOT completed!
	public double calculateIncomeTax() {
		
		//The owner’s income is the sum of the menu prices on all the customer’s checks
		double ownerIncome = getIncome();
		//double fixedCosts = 0;
		
		
		//The owner’s expenses are the hourly wages paid to the staff (salaryExpenses), and certain fixed costs (fixedCosts)
		double ownerExpense = getSalaryExpenses() + FoodPlace.fCosts;
		//FoodPlace.fCosts
		//+ foodPlace.getFixedCosts() -> A problem!
		
		//The owner’s income tax is 10 percent of the difference of the income and the expenses
		double ownerIncomeTax = 0.1 * (ownerIncome - ownerExpense);
		
		//if the income is less than the expenses, then the income tax is zero rather than negative
		if(ownerIncomeTax > 0) {
			return ownerIncomeTax;
		}else {
			return 0;
		}
	}
	
}

