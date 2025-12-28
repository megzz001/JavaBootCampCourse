package Stationary_Billing_System;
import java.util.Scanner;

public class PEN extends Pencil{
    Scanner sc = new Scanner(System.in);
	public int pen_Stock;
	public int pen_requirement;
	public final int pen_Price = 20;
	public int book_Price = 50;
	public int pencil_Price = 10;
 
   
   public void pen_Stock(){
   	System.out.print("Enter the Stock of pEN present in the Store:");
   	pen_Stock = sc.nextInt();
   }
  
   public void Number_of_pen() {
		System.out.print("Enter the number of pEN customer wants:");
		pen_requirement  = sc.nextInt();
	}
   
   public void Penbill() {
	   int penbill = (pen_Price*pen_requirement);
	   System.out.println("Total bill for book:" + penbill );
	}
   public void check_pen_stock() {
   	if(pen_requirement > pen_Stock) {
   		System.out.println("Sorry....Pen are out of stock.");
   	}
   	
   }
}
