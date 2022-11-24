

public class Customer  {

	private String name;
	private int  targetTipPct;

	public Customer(String name, int targetTipPct) {
		this.name = name;
		this.targetTipPct = targetTipPct;
	}

	public String getName() {
		return name;
	}

	public int getTargetTipPct() {
		return targetTipPct;
	}

	public String getDescriptiveMessage(FoodPlace foodPlace) {
		return this.name + " dined in " + foodPlace.getName();
	}

	public void dineAndPayCheck(FoodPlace foodPlace, double menuPrice ) {
		
		//1. construct a new check
		Check check = new Check(menuPrice);
		
		//2. calculate the tip
		double tipPercentage = (getTargetTipPct() + foodPlace.getTipPercentage()) / 2;	//average of both
		
		//calculate the amount of tip and save it in "tip" variable
		check.setTipByPct(tipPercentage);
		double tip = check.getTip();
		
		//3. distribute earnings of this check
		foodPlace.distributeIncomeAndSalesTax(check);
		
		//the owner gets an income contribution of the menu price
		foodPlace.getOwner().setIncome(foodPlace.getOwner().getIncome() + check.getMenuPrice());
	}
}

