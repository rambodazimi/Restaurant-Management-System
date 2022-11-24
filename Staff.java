
public class Staff extends IncomeTaxPayer {

	private int salaryPerHour;
	final private int incomeTaxPercentage = 25;

	public Staff(String name, boolean isCook) {
		super(name);
		
		//a cook is paid $20 per hour and otherwise a staff is paid $10 per hour
		if(isCook) {
			this.salaryPerHour = 20;
		}else {
			this.salaryPerHour = 10;
		}
	}

	public int getSalaryPerHour() {
		return salaryPerHour;
	}

	public int getIncomeTaxPercentage() {
		return incomeTaxPercentage;
	}

	public double workHours(int numHours) {
		
		double staffWage = numHours * getSalaryPerHour();

		//modifies that staff’s income
		setIncome(getIncome() + staffWage);
		
		//returns the amount of money earned by that staff
		return staffWage;
	}

	@Override
	public double calculateIncomeTax() {
		
		//all staff pay 25% income tax
		double incomeTax = 0.25 * getIncome();
		
		return incomeTax;
	}

}

