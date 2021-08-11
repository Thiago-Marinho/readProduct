package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private Date manufatureDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, String manufatureDate) throws ParseException {
		super(name, price);
		Date m = sdf.parse(manufatureDate);
		this.manufatureDate = m;
	}

	public Date getManufatureDate() {
		return manufatureDate;
	}

	public void setManufatureDate(Date manufatureDate) {
		this.manufatureDate = manufatureDate;
	}
	
	@Override
	public String priceTag() {
		return super.getName() +"(used), $"+ super.getPrice() +"(manufature date: "+ sdf.format(manufatureDate)+ ")";
	}
}
