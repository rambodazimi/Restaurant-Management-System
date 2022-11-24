
public abstract class IncomeTaxPayer {

	private static int currentMaxTaxID;
	private int  taxID;
	private String  name;
	private double  income;

	public IncomeTaxPayer(String name){
		this.name = name;
		
		//assign a unique ID to this income tax payer
		taxID = currentMaxTaxID;
		currentMaxTaxID ++;
	}

	public static int getCurrentMaxTaxID() {
		return currentMaxTaxID;
	}

	public int getTaxID() {
		return taxID;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome( double income) {
		this.income = income;
	}

	public String toString() {
		return "  " + taxID + " " + name + " income " + income ;
	}

	public boolean equals(Object obj) {
		//returns true if the argument is indeed an IncomeTaxPayer and if the id’s match
    	if (obj instanceof IncomeTaxPayer) {
    		IncomeTaxPayer myObj = (IncomeTaxPayer) obj;
    		return (myObj.getTaxID() == taxID);
    	}else {
    		return false;
    	}
	}

	public abstract double calculateIncomeTax();
}

