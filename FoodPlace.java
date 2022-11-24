
import java.util.List;

public abstract class FoodPlace {

	public static double fCosts;
    private static int currentMaxFoodPlaceID;
    private int foodPlaceID;
    private String name;
    private double fixedCosts;
    private double totalSalesTax;
    private Owner owner;

    public FoodPlace(String name, double fixedCosts, Owner owner){
    	this.name = name;
    	this.fixedCosts = fixedCosts;
    	this.owner = owner;
    	fCosts = fixedCosts;
    	    	
    	//when a new foodPlace is instantiated, this will be incremented    	
    	foodPlaceID = currentMaxFoodPlaceID;	
    	currentMaxFoodPlaceID++;

    }

    public static int getCurrentMaxFoodPlaceID() {
        return currentMaxFoodPlaceID;
    }

    public int getFoodPlaceID() {
        return foodPlaceID;
    }

    public String getName() {
        return this.name;
    }

    public double getFixedCosts() {
        return this.fixedCosts;
    }

    public double getTotalSalesTax() {
        return this.totalSalesTax;
    }

    public void setTotalSalesTax(double totalSalesTax) {
        this.totalSalesTax = totalSalesTax;
    }

    public Owner getOwner() {
        return this.owner;
    }

    @Override
    //returns true if the object is an instance of FoodPlace and foodPlaceID matches
    public boolean equals(Object obj) {
    	if (obj instanceof FoodPlace) {
    		FoodPlace myObj = (FoodPlace) obj;
    		return (myObj.getFoodPlaceID() == getFoodPlaceID());
    	}else {
    		return false;
    	}
    }

    abstract void workShift(int hours);

    abstract List<IncomeTaxPayer> getIncomeTaxPayers();

    abstract void distributeIncomeAndSalesTax(Check check);

    abstract double getTipPercentage();
}

