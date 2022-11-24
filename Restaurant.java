
import java.util.LinkedList;
import java.util.List;

public class Restaurant extends FoodPlace {

	private Staff cook;
	private Server server;

	public Restaurant(String name, double fixedCosts, Owner owner, Staff cook, Server server) {
		super(name,fixedCosts,owner);
		this.cook = cook;
		this.server = server;
	}

	public Staff getCook() {
		return cook;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "Name of restaurant: " + this.getName() +
				"\n" + "Owner: " + this.getOwner() +
				"\n" + "Cook: " + cook +
				"\n" + "Server: " + server;
	}

	@Override
	public void workShift(int hours) {
		
		//increases the cook’s and server’s incomes based on the number of hours worked and per hour salary;
		cook.setIncome(cook.getIncome() + (hours * cook.getSalaryPerHour()));
		server.setIncome(server.getIncome() + (hours * server.getSalaryPerHour()));
		
		//adds these wages to the owner’s accumulated salary expenses
		getOwner().setSalaryExpenses(cook.getIncome() + server.getIncome());
	}

	@Override
	public List<IncomeTaxPayer> getIncomeTaxPayers() {
		
		//returns a List of IncomeTaxPayers that work at that Restaurant (cook, server, owner)
		LinkedList<IncomeTaxPayer> myList = new LinkedList<IncomeTaxPayer>();
		
		myList.addFirst(getCook());
		myList.addFirst(getServer());
		myList.addFirst(getOwner());
		
		return myList;
	}

	@Override
	public void distributeIncomeAndSalesTax(Check check) {
		
		//menu price component of the check is added to the owner’s income
		getOwner().setIncome(getOwner().getIncome() + check.getMenuPrice());
		
		//the tip component is added to the income of the cook(20 % of tip)
		getCook().setIncome(getCook().getIncome() + (0.2 * check.getTip()));
		
		//the tip component is added to the income of the server(80 % of tip)
		getServer().setIncome(getServer().getIncome() + (0.8 * check.getTip()));
		
		//the total sales tax is accumulated
		setTotalSalesTax(getTotalSalesTax() + check.getSalesTax());
	}

	@Override
	public double getTipPercentage() {
		
		//returns the Server’s target tip percentage
		return getServer().getTargetTipPct();
	}

}

