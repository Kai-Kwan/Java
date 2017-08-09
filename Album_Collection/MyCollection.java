import java.util.List;
import au.edu.uow.Collection.*;
import au.edu.uow.UserInterface.*;
public class MyCollection
{
	public static void main(String[] args) 
	{
		if(args.length == 1)
		{
			List<Album> myCollection =	CollectionFactory.loadCollection(args[0]);		
			if 	(myCollection != null){
			UserInterface ui = 	new	UserInterface(myCollection); 
			ui.start();
			}
			else
			{
				System.out.println("Error: Failed to load collection. Exit!");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("Usage: MyCollection collectionFilename"); 
		}
	}
}