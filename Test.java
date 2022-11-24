import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		Restaurant MamaAfrica = setUpRestaurant();
		FoodStand HotDawgs = setUpFoodStand();
		FastFood McDonald = setUpFastFood();

		List<FoodPlace> foodPlaces = Arrays.asList(MamaAfrica, HotDawgs, McDonald);

		Customer Adrian = new Customer("Adrian", 20);
		Customer Alissa = new Customer("Alissa", 15);
		Customer Jess = new Customer("Jess", 10);
		Customer Mike = new Customer("Mike", 20);
		Customer Joe = new Customer("Joe", 20);

		Adrian.dineAndPayCheck(MamaAfrica, 100);
		Adrian.dineAndPayCheck(McDonald, 50);
		Adrian.dineAndPayCheck(McDonald, 30);
		Alissa.dineAndPayCheck(HotDawgs, 20);
		Jess.dineAndPayCheck(MamaAfrica, 150);
		Mike.dineAndPayCheck(McDonald, 20);
		Mike.dineAndPayCheck(McDonald, 40);
		Joe.dineAndPayCheck(HotDawgs, 30);

		for (FoodPlace foodPlace : foodPlaces) {
			foodPlace.workShift(8);
			System.out.println("--------------------");
			System.out.println(foodPlace);
		}

		TaxCollector taxer = new TaxCollector(foodPlaces);
		taxer.collectTax();
		System.out.println("--------------------");
		System.out.println( taxer );
		System.out.println("--------------------");
	}

	public static Restaurant setUpRestaurant() {
		Owner Amara = new Owner("Amara");

		Staff Sade = new Staff("Sade", false);
		Server Nia = new Server("Nia", 20);
		Restaurant MamaAfrica = new Restaurant("Mama Africa", 1000, Amara, Sade, Nia);
		return MamaAfrica;
	}

	public static FoodStand setUpFoodStand() {
		WorkingOwner John = new WorkingOwner("John", 20);

		FoodStand HotDawgs = new FoodStand("Hot Dawgs", 200, John);
		return HotDawgs;
	}

	public static FastFood setUpFastFood() {
		Owner Ricardo = new Owner("Ricardo");

		Staff Andrew = new Staff("Andrew", false);
		Staff Alphonse = new Staff("Alphonse", false);
		Staff Rissah = new Staff("Rissah", false);
		Staff Yung = new Staff("Yung", false);
		Staff Peter = new Staff("Peter", false);

		List<Staff> staff = Arrays.asList(Andrew, Alphonse, Rissah, Yung, Peter);

		FastFood McDonald = new FastFood("McDonald", 700, Ricardo, staff);

		return McDonald;
	}
}
