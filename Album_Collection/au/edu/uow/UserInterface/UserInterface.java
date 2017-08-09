package au.edu.uow.UserInterface;
import java.util.*;

import au.edu.uow.Collection.Album;
public class UserInterface
{

	public UserInterface(List<Album> myCollection){
		List<Album> Album = myCollection;
	
	}

	public void start() {
		System.out.println("My Album Collection, v.1.0 ");
		System.out.println("Created by YourName");
		System.out.println("Select your choice:");
		System.out.println("1: Display the total number of albums"); 
		System.out.println("2: List all album titles");
		System.out.println("3: Display the album detail"); 
		System.out.println("q: Quit");
		System.out.print("Your Choice: ");
			Scanner reader = new Scanner(System.in);
			String n = reader.next();
			switch(n)
			{
			case "q":
				   System.exit(0);
				   break;
			case "1":
				
				System.out.println("6 albums in the collection.");
			default:
				System.out.println("Invalid input! Press enter re-start");
				Scanner a = new Scanner(System.in);
				start();
				 break;
				
			}
			
		
	}
}