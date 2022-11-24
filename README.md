 # Restaurant-Management-System

<h3>Description</h3>

We model parts of a small economy, namely the food service industry. We model places where customers can buy food: restaurants, food stands, and fast food. We model the payment of bills, including sales tax and tip. We do not model many other things such as the food or menu. We also model a tax collector who collects both sales tax and income tax. We only model one year: the workers each have some income and pay tax for that year.

We present a UML diagram for each class, and indicate if one class extends another. For all the classes in this assignment, all fields are private and all methods are public. In the class descriptions below, we do not bother to mention fields or methods whose meaning is obvious, such as getter or setter methods.

We start with a few classes that model the food places. Here are a UML diagram for FoodPlace classes and subclasses.

FoodPlace is an abstract class. It has several private fields such as:

• foodPlaceID – each FoodPlace has a unique ID; the id’s are determined by a counter, namely the following static variable (currentMaxFoodPlaceID)

• currentMaxFoodPlaceID – at any time, this is the largest ID of any FoodPlace; when a new Food- Place is instantiated, the value of this variable is incremented and becomes the id of this new Food- Place

• fixedCosts – every FoodPlace has certain maintenance, supply, and other fixed costs (lumped to- gether)

• totalSalesTax - each Check paid by a Customer will have a sales tax that is added; the FoodPlace needs to accumulate these sales taxes; they will be collected by a TaxCollector.

You will implement the following public methods. See the UML diagrams for the parameters of all methods.

• a constructor FoodPlace() - sets the fields; also, sets the owner’s FoodPlace field.

• equals() – returns true if the argumen to bject is indeed a FoodPlace and the foodPlaceID’s
match; otherwise, it returns false

There are also abstract methods which will be described in the the subclasses below.

The Restaurant class extends FoodPlace. You will implement the following public methods:

• a constructor Restaurant() – sets the fields; note that a Restaurant is a FoodPlace, so call super().

• workShift() – returns nothing (void). This method models that the cook and server are paid an hourly wage: specifically, the method increases the cook’s and server’s incomes based on the number of hours worked and per hour salary; the method also adds these wages to the owner’s accumulated salary expenses.

• getIncomeTaxPayers() – returns a List of IncomeTaxPayers that work at that Restaurant, namely a cook, server, and owner; the List return type allows you to use either a LinkedList or ArrayList (either is fine). The order of IncomeTaxPayer’s in the list doesn’t matter.

• distributeIncomeAndSalesTax() – returns nothing(void); the parameter for this method is a Check. In all restaurants, the menu price component of the check is added to the owner’s income; the tip component is added to the income of the cook (20 % of tip) and to the server (80 % of tip); the total sales tax is accumulated as well.

• getTipPercentage() – returns the Server’s target tip percentage

The FoodStand class extends FoodPlace. You will implement the following methods:

• a constructor FoodStand() – sets the fields; note that a FoodStand is a FoodPlace, so call super().

• getIncomeTaxPayers() – returns a List containing one element (the owner); it can be either a LinkedList or ArrayList – your choice!

• distributeIncomeAndSalesTax() – using the check, it updates the owner’s income by adding the menu price and the tip; it also updates the total sales tax.

• getTipPercentage() – returns the target tip percentage defined by the owner; note that (1) the owner of a FoodStand is a WorkingOwner which has a field targetTipPct, and (2) this method requires casting.

The FastFood class extends FoodPlace. You will implement the following methods:

• a constructor FastFood – sets the fields; note that a FastFood is a FoodPlace, so call super(). The Staff list field must contain a shallow copy of the Staff list argument.

• workShift() – returns nothing (void) ; it models that the owner pays each staff an hourly wage. The method adds an amount to each of the staff’s incomes, and it adds these amounts to the owner’s total salary expenses. Hint: use the Staff.workHours() method to add to a staff’s income.

• getIncomeTaxPayers() – returns a list (ArrayList or LinkedList) that includes the owner and all the staff in any order. Return a shallow copy of the list here.

• distributeIncomeAndSalesTax() – returns nothing (void); in all fastfood places, the menu price is an income for the owner. It is also possible to have tips, but the tip only depends on the customer. The tip is split equally between all the staff (which does not include the owner). The totalSalesTax must also be set.

IncomeTaxPayer

This is an abstract class. You will implement the following methods:

• constructor IncomeTaxPayer() – assigns a uniqueID to this income tax payer; just incre- ment a static counter currentMaxTaxID here to get unique id’s.

• equals() – returns true if the argument is indeed an IncomeTaxPayer and if the id’s match, and otherwise returns false. Note that two IncomeTaxPayers might have the same name, but they cannot have the same id’s. So you don’t need to check the names.

Staff is a class which extends IncomeTaxPayer. You will implement the following methods:

a constructor Staff – the salaryPerHour is determined by the parameter isCook: a cook is paid $20 per hour and otherwise a staff is paid $10 per hour.

• workHours() – returns the amount of money earned by that staff, and modifies that staff’s income.

The parameter of this method is the number of hours worked in a shift; whenever a staff works this number of hours, the staff’s income increases; this method will be called in the different implemen- tations of FoodPlace.workShift() method. Note that this method is both a mutator and an accessor, namely it changes a field in the staff object and it also returns the amount of money earned by that staff.

• calculateIncomeTax() – all staff pay 25% income tax.

Server is a class which extends Staff. (Note that Restaurant is the only FoodPlace that has a Server.) You will implement one method:

• a constructor Server() – note that a Server is a Staff and in particular a Server is not a cook.

Each server (and cook) receives a tip from each Customer as part of the check – see the Restaurant’s dis- tributeIncomeAndSalesTax() method. The tip is calculated by the Customer.dineAndPayCheck() method: the tip depends on both the Server (e.g. their skill and friendliness) and on the Customer (whether they are generous or not), namely the final tip percentage is the average of the target tip percentages of the Server and the Customer.

The Owner class extends IncomeTaxPayer. You will implement the following methods:

• a constructor Owner() – sets the name of this owner (but note that owner inherits1 its name field from its superclass)

• calculateIncomeTax() – returns the amount of tax that the owner needs to pay, based on the owner’s income and expenses. The owner’s income is the sum of the menu prices on all the customer’s checks. The owner’s expenses are the hourly wages paid to the staff (salaryExpenses), and certain fixed costs (fixedCosts) for running the restaurant (e.g. maintenance, equipment, food supplies, etc) which we do not model in detail. The owner’s income tax is 10 percent of the dif- ference of the income and the expenses, assuming the income is greater than the expenses; if the income is less than the expenses, then the income tax is zero rather than negative.

WorkingOwner extends Owner. In our model, the only WorkingOwners are the owners of FoodStands. WorkingOwners are different from general Owners in that working owners get tips. An example of a WorkingOwner would be a hot dog stand owner.

You will implement just one method:

• a constructor WorkingOwner() – sets the name (but note that WorkingOwner inherits its name field) as well as the targetTipPct field.

Check models a customer’s payment. It is used to specify the menu price, sales tax, and tip. You will implement these methods:

• a constructor – sets the field values; in particular, the sales tax is 15% of the menu price;

• setTipByPct() – returns nothing (void); This setter method has one parameter which is the tip percentage; it sets the tip to be that percentage of the menuPrice. Note that percentage is a value between 0 and 100.

Customer

You will implement two methods:

aconstructorCustomer() – there are two parameters: the name(this is the only place where the customer identity is used) and the targetTipPct (this is the tip percentage that this customer give for their expected level of service; the tip is determined by the Customer in its dineAndPayCheck method – see next)

• dineAndPayCheck() – returns nothing (void); the details of this method are given below.

The idea of the dineAndPayCheck() method is that a customer visits a FoodPlace, eats, and pays the check. The tip calculation and the way the payment is distributed depends on the FoodPlace. Specifically, the method does the following:

1. construct a new check;

2. calculate the tip: The tip percentage is the average of a target tip for that customer and the Food- Place’s tip percentage returned by the getTipPercentage() method of the FoodPlace. For example, a customer might have a target tip of 10% and the food place might have a target tip of 20%, and in this case the customer would tip the average, namely 15%. Another example is a customer with 15% tip percentage who goes to a FastFood place like McDonalds; the FastFood tip percentage is 0 % and so the customer would only give 7.5% tip percentage on the check. These target tips are fields within the Customer and Foodplace objects. Hint: the method Check.setTipByPct() should be called here.

3. distribute earnings of this check: the owner gets an income contribution of the menu price; the tip is distributed according to the FoodPlace’s class policy; the sales tax is set aside for the tax collector. This procedure is done with the FoodPlace.distributeEarnings() method.

There is a helper method included in the starter code getDescriptiveMessage() which prints out that a customer went to a particular FoodPlace. You can use it for debugging purposes, if you wish. You can also add a toString() method if you wish; it can help you with debugging.

TaxCollector

You will implement the following methods:

• a constructor TaxCollector - assigns the food place list; you can use the reference i.e. you don’t need to make a shallow copy.

• collectTax() – returns nothing (void); for each FoodPlace in the list of all FoodPlace’s, the sales tax is collected and the income taxes from all IncomeTaxPayer’s are collected, and these values are added to the incomeTaxCollected and salesTaxCollected fields.


