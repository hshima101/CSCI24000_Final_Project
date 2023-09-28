public class Product{
	
	String Name = null;
	double buyPrice = 0;
	double salePrice = 0;
	double quantity = 0;

	public Product(){
		this.Name = null;
		this.buyPrice = 0;
		this.salePrice = 0;
		this.quantity = 0;
		}

	public Product(String Name, double buyPrice, double salePrice, double quantity){
		this.Name = Name;
		this.buyPrice = buyPrice;
		this.salePrice = salePrice;
		this.quantity = quantity;
		}
	
	public void setName(String Name){
		this.Name = Name;
		}	

	public String getName(){
		return Name;
		}

	public void setBuyPrice(double buyPrice){
		this.buyPrice = buyPrice;
		}

	public double getBuyPrice(){
		return buyPrice;
		}

	public void setSalePrice(double salePrice){
		this.salePrice = salePrice;
		}

	public double getSalePrice(){
		return salePrice;
		}

	public void setQuantity(double quantity){
		this.quantity = quantity;
		}
	
	public double getQuantity(){
		return quantity;
		}
}
