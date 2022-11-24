
import java.util.LinkedList;
import java.util.List;

public class FoodStand extends FoodPlace {

    public FoodStand(String name, double fixedCosts, WorkingOwner owner) {
        super(name,fixedCosts,owner);
    }

    @Override
    public String toString() {
        return "Name of FoodStand: " + this.getName() +
                "\n" + "Owner: " + this.getOwner();
    }

    @Override
    public void workShift(int hours) {
        // no salaried workers so do nothing
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
    	
    	//return a List containing one element (the owner)
    	LinkedList<IncomeTaxPayer> myList = new LinkedList<IncomeTaxPayer>();
    	
    	myList.add(getOwner());
    	
        return myList;

    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
    	
    	//it updates the owner’s income by adding the menu price and the tip
    	getOwner().setIncome(getOwner().getIncome() + check.getMenuPrice() + check.getTip());
    	
    	//update the total sales tax
    	setTotalSalesTax(getTotalSalesTax() + check.getSalesTax());
    }

    @Override
    public double getTipPercentage() {

    	//returns the target tip percentage defined by the owner (Working Owner)
    	WorkingOwner myOwner = (WorkingOwner) this.getOwner();    	//casting
    	
        return myOwner.getIncomeTaxPct();
    }
}

