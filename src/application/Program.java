package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		System.out.print("Enter the number of products:  ");
		int n = sc.nextInt();		
		
		for(int i=1; i <=n; i++) {
			System.out.println("Product #"+ i +" data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char option = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(option == 'c') {
				list.add(new Product(name, price));
			
			}else if(option == 'i') {
				
				System.out.print("Customs fee: ");
				Double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
				
			}else if(option == 'u') {
				
				System.out.print("Manufature date (DD/MM/YYYY): ");
				String date = sc.next();
				list.add(new UsedProduct(name, price, date));
			}
			
		}
		System.out.println("\nPRICE TAGS: ");
		for (Product pdt : list) {
			System.out.println(pdt.priceTag());
		}
		
		sc.close();	
	}

}
