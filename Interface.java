import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Interface{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String name;
		double buyPrice = 0;
		double salePrice = 0;
		double quantity = 0;
		int index = 0;

		//profit/loss equation
		double inventoryCost = 0;
		int inventorySize = 0;
		double bulkCost = 0;
		double soldItem = 0;
		double placeHolder1 = 0;
		double placeHolder2 = 0;
		double placeHolder3 = 0;
		double gross = 0;
		double profit = 0;
		double average = 0;

		//interface inputs
		int choice = 0;
		int size = 0;
		double history = 0;
		boolean keepGoing = true;

		List<Product> sales = new ArrayList<>();
		List<Product> sold = new ArrayList<>();

		System.out.println("Welcome User! You are here to record Products");
		System.out.println("Enter the name of the Product, what price you bought it for, and the sale price");

		while(keepGoing){
			try{
				System.out.println("Name: ");
				name = input.next();
				System.out.println("Buy Price");
				buyPrice = input.nextDouble();
				System.out.println("SalePrice");
				salePrice = input.nextDouble();
				System.out.println("Quantity:");
				quantity = input.nextInt();
				System.out.println("");				

				//add up the inventory number for calculations
				sales.add(new Product(name, buyPrice, salePrice, quantity));
				index = index + sales.size();
				for(int i = 0; i <sales.size(); i++){
					bulkCost = sales.get(i).getBuyPrice() * sales.get(i).quantity;
					System.out.println(bulkCost);
					}
				System.out.println("");
				inventoryCost = inventoryCost + bulkCost;
				System.out.println(sales.size());
				System.out.println("");

				for(int i = 0; i < sales.size(); i++){
					System.out.println(sales.get(i).getName() + " " + sales.get(i).getBuyPrice() + " " + sales.get(i).getSalePrice() + " " + sales.get(i).getQuantity());
					}	

//				for(int i = 0; i < sales.size(); i++){
//					System.out.println("Name: " + sales.get(i).getName());
//					System.out.println("Bought: " + sales.get(i).getBuyPrice());
//					System.out.println("Sales: " + sales.get(i).getSalePrice());
//					System.out.println("Quantity: " + sales.get(i).getQuantity());
//					}

				System.out.println("Bulk Cost:" + bulkCost);
				System.out.println("Inventory Price: " + inventoryCost);
				System.out.println("Do you want to continue? Press 1 to continue, Press 2 report sales");
				bulkCost = 0;

				choice = input.nextInt();
				if(choice == 1){
					keepGoing = true;
				} else if(choice == 2){
					keepGoing = false;
					}		
				} catch (Exception e){
					System.out.println("That is not a valid input. Try again");
					}//end catch
		}//end while

		keepGoing = true;
		System.out.println("Here you record your profits. Type in the product name and list the number sold");

		while(keepGoing){
			
			try{
			System.out.println("Inventory:");
			for(int i = 0; i < sales.size(); i++){
				System.out.println("Index: " + i + " Product: " + sales.get(i).getName() + " " + sales.get(i).getBuyPrice() + " " + 
					sales.get(i).getSalePrice() + " " + sales.get(i).getQuantity());
					}				

				System.out.println("Report the product sold today");
				System.out.println("Name: ");
				name = input.next();
				System.out.println("How many " + name + " were sold?");
				soldItem = input.nextDouble();

				inventorySize = sales.size();
				for(int i = 0; i < inventorySize; i++){
					//crunch numbers
					if(name.equals(sales.get(i).getName())){
						sold.add(new Product(name, sales.get(i).getBuyPrice(), sales.get(i).getSalePrice(), soldItem));
						placeHolder1 = sales.get(i).getQuantity();
						placeHolder1 = placeHolder1 - soldItem;		
						sales.get(i).setQuantity(placeHolder1);
						index = i;
						}
					}


				placeHolder2 = sales.get(index).getSalePrice();
				System.out.println(placeHolder2);
				placeHolder3 = placeHolder2 * soldItem;
				gross = gross + placeHolder3;
//				System.out.println(gross);
				history = history + soldItem;

				profit = gross - inventoryCost;
				System.out.println("Gross: " + gross);
				System.out.println("Profits: " + profit);
				System.out.println("");
				System.out.println("Inventory: ");
//				System.out.println("");

				for(int i = 0; i < sales.size(); i++){
					System.out.println(sales.get(i).getName() + " " + sales.get(i).getBuyPrice() + " " + sales.get(i).getSalePrice() + " " + sales.get(i).getQuantity());
					}
				System.out.println("");
//				for(int i = 0; i < sales.size(); i++){
//					System.out.println("Name:" + sales.get(i).getName());
//					System.out.println("Bought:" + sales.get(i).getBuyPrice());
//					System.out.println("Sale:" + sales.get(i).getSalePrice());
//					System.out.println("Quantity:" + sales.get(i).getQuantity());
//					}

				System.out.println("History: " + history + " Items sold.");
				System.out.println("Are there any other products that need to be reported? Press 1 to continue, Press 2 to end the program");
				choice = input.nextInt();
				if(choice == 1){
					keepGoing = true;
				} else if(choice == 2){
					keepGoing = false;		
				}

			} catch (Exception e){
				System.out.println("This product is not in your inventory");
				keepGoing = true;
				}
		}//end while
		
		System.out.println("");
		System.out.println("Report:");
		System.out.println("Sold Items:");
		for(int i = 0; i < sold.size(); i++){
			System.out.println("Index: " + i + " " + sold.get(i).getName() + " " + sold.get(i).getBuyPrice() + " " + sold.get(i).getSalePrice() + " " + sold.get(i).getQuantity());
			average = average + sold.get(i).getQuantity();
			}

		System.out.println("");
		System.out.println("Item Averages:");
		for(int i = 0; i < sold.size(); i++){
			System.out.println("Index: " + i + " " + " Product: " + sold.get(i).getName() + " " + Math.round(sold.get(i).getQuantity()/average * 100));
			}		
		System.out.println("Profits: " + profit);

	}//end main
}//end class







































