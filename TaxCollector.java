
import java.util.ArrayList;
import java.util.List;

public class TaxCollector {

	private List<FoodPlace> foodPlaces = new ArrayList<>();

	private double incomeTaxCollected;
	private double salesTaxCollected;

	public TaxCollector(List<FoodPlace> foodPlaces) {
		
		//assigns the food place list(using reference)
		//this.foodPlaces = foodPlaces;
		
		for(int i = 0 ; i < foodPlaces.size() ; i++) {
			this.foodPlaces.add(foodPlaces.get(i));
		}
	}

	public List<FoodPlace> getFoodPlaces() {
		return foodPlaces;
	}

	public double getIncomeTaxCollected() {
		return incomeTaxCollected;
	}

	public double getSalesTaxCollected() {
		return salesTaxCollected;
	}

	public void collectTax() {
		
		for(int i = 0 ; i < getFoodPlaces().size() ; i++) {
			
			FoodPlace fp = getFoodPlaces().get(i);
			
			
			//income taxes from all IncomeTaxPayer’s are collected
			for(int j = 0 ; j < fp.getIncomeTaxPayers().size() ; j++) {
				incomeTaxCollected += foodPlaces.get(i).getIncomeTaxPayers().get(j).calculateIncomeTax();
			}	
			//sales tax is collected
			salesTaxCollected += foodPlaces.get(i).getTotalSalesTax();
		}
	}
	
	public String toString() {
		return "TaxCollector: income tax collected: " + incomeTaxCollected + ", sales tax collected: " + salesTaxCollected;
	}
	
}

