package au.edu.uow.Collection;

import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class CollectionFactory
{

	public static List<Album> loadCollection(String string) {
		
		try
		{
			File f =new File("MyCollection.xml"); 
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("ALBUM");
			List<Album> MyCollection = new ArrayList<Album>();
			for (int i=0; i<nl.getLength() ;i++)
			{
				if(nl.item(i).getFirstChild().getNodeName() == "CD")
				{
					String Title = doc.getElementsByTagName("Title").item(i).getFirstChild().getNodeValue();
					String Genre = doc.getElementsByTagName("Genre").item(i).getFirstChild().getNodeValue();
					String Artist = doc.getElementsByTagName("Artist").item(i).getFirstChild().getNodeValue();
					String Tracks = doc.getElementsByTagName("Tracks").item(i).getFirstChild().getNodeValue();
					MyCollection.addAll(i);
				}
				else
					if(nl.item(i).getFirstChild().getNodeName() == "CD")
					{
						String Title = doc.getElementsByTagName("Title").item(i).getFirstChild().getNodeValue();
						String Genre = doc.getElementsByTagName("Genre").item(i).getFirstChild().getNodeValue();
						String Director = doc.getElementsByTagName("Director").item(i).getFirstChild().getNodeValue();
						String PlotOutline = doc.getElementsByTagName("PlotOutline").item(i).getFirstChild().getNodeValue();
					}

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}