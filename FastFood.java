
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FastFood extends FoodPlace {

    private List<Staff> staff = new ArrayList<>();

    public FastFood(String name, double fixedCosts, Owner owner, List<Staff> staff) {
 
    	//calling the constructor of the superclass (FoodPlace)
    	super(name,fixedCosts,owner);
        
        //shallow copy by hand
        for(int i = 0 ; i < staff.size() ; i++) {
        	this.getStaff().add(staff.get(i));
        }
        
    }

    public List<Staff> getStaff() {
        return staff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name of FastFood: " + this.getName() +
                "\n" + "Owner: " + this.getOwner());
        int index = 1;
        for (Staff staff: staff) {
            builder.append("\n" + "Staff " + index++ + " : " + staff );
        }
        return builder.toString();
    }

    @Override
    public void workShift(int hours) {
    	
    	for(int i = 0 ; i < getStaff().size() ; i++) {
    		double wage = hours * getStaff().get(i).getSalaryPerHour();
    		
    		//add an amount to each of the staff’s incomes,
    		getStaff().get(i).setIncome(getStaff().get(i).getIncome() + wage);
    		
    		//add these amounts to the owner’s total salary expense
    		getOwner().setSalaryExpenses(getOwner().getSalaryExpenses() + wage);	
    	}
    }

    @Override
    public List<IncomeTaxPayer> getIncomeTaxPayers() {
    	
    	// returns a list (shallow copy) that includes the owner and all the staff in any order
    	LinkedList<IncomeTaxPayer> myList = new LinkedList<IncomeTaxPayer>();
    	
    	//add owner to the list
    	myList.add(getOwner());
    	
    	//add all the staff to the list
    	for(int i = 0 ; i < getStaff().size() ; i++) {
    		myList.add(getStaff().get(i));
    	}
        return myList;
    }

    @Override
    public void distributeIncomeAndSalesTax(Check check) {
    	
    	//The menu price is an income for the owner
    	getOwner().setIncome(getOwner().getIncome() + check.getMenuPrice());
    	
    	//The tip is split equally between all the staff (not the owner)
    	double tipForEachStaff = check.getTip() / getStaff().size();
    	
    	for(int i = 0 ; i < getStaff().size() ; i++) {
    		getStaff().get(i).setIncome(getStaff().get(i).getIncome() + tipForEachStaff);
    	}
    	
    	//update the total sales tax
    	setTotalSalesTax(getTotalSalesTax() + check.getSalesTax());
    }

    @Override
    public double getTipPercentage() {
        return 0;
    }
}

