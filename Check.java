
public class Check {
	private double menuPrice;
	private double salesTax;
	private double tip;

	public Check(double menuPrice) {
		this.menuPrice = menuPrice;

		//the sales tax is 15% of the menu price
		salesTax = menuPrice * 0.15;
		
	}

	public double getMenuPrice() {
		return this.menuPrice;
	}

	public double getSalesTax() {
		return this.salesTax;
	}

	public double getTip() {
		return this.tip;
	}

	public void setTipByPct(double tipPct ) {
		
		//it sets the tip to be that percentage of the menuPrice
		this.tip = tipPct * menuPrice * 0.01;
	}
}

