import java.io.*;
import java.util.*;
public class transposition {

	public static void encrypt(String in, String file_output, String key) throws IOException {
		String ciphertext = "";	
		char key_arr[] = key.toCharArray();
		int hight = (int) Math.ceil((double) in.length()/(key.length()));
		
  	     if(hight*key.length()>in.length())
  	     {
  	   		int addX = hight*key.length()-in.length(); 	   	
  	    	 for(int i=0; i < addX ;i++)
  	    	 {	  	    		 
  	    		 in += " ";				
  	    	 }
  	     }
  	     

			
		for(int i=0;i<key.length();i++)
		{
			for(int j=0;j<key.length();j++)
			{	
				if( Character.getNumericValue(key_arr[j]) == i )
				{			
					
					for(int k=j;k<in.length(); k+=key.length())
					{
						ciphertext += in.charAt(k);
					}
				}
			}

		}
		/*
		System.out.println(ciphertext);
		*/
		try (PrintWriter out = new PrintWriter(file_output))
		{
		
		out.print(ciphertext);
		}
		
		System.out.println("file encripted");
	}
	
	
	public static void decrypt(String in, String file_output, String key)throws IOException {
		String plaintext = "";
		char key_arr[] = key.toCharArray();
		int hight = (int) Math.ceil((double) in.length()/(key.length()));
		
		
		for(int i=0;i<hight;i++)
		{
			for(int j=0;j<key.length();j++)
			{

				plaintext += in.charAt(hight*Character.getNumericValue(key_arr[j])+i);	
		
			}

		}
		while(plaintext.charAt(plaintext.length()-1)==' ')
			plaintext = plaintext.substring(0, plaintext.length()-1);
		/*
		System.out.println(plaintext);
		*/
		try (PrintWriter out = new PrintWriter(file_output))
		{
		
		out.print(plaintext);
		}
		
	
		
	}
	

	


	public static void main(String[] args) throws IOException {

		
		String opreation = args[0]; 
		String password = args[1];
		String file_input = args[2];
		String file_output = args[3];
		
		/*
		String opreation = "-e";
		String password = "42031";
		String file_input = "text.txt";
		String file_output = "ciphertext.txt";
		*/
		
		String key = "";
        
		String in =new Scanner(new File(file_input)).useDelimiter("\\Z").next();
	         

	  	     for(int i=0;i<password.length();i++)
	  	     {
	  	    	 int rank = 0;
	  	    	 for(int j=0;j<password.length();j++)
	  	    	 { 
	  	    	 if(password.charAt(i)>password.charAt(j))
	  	    	 rank++;
	  	    	 }
	  	    	 key += rank;
	  	     }
	  	     
	  	     
	  		if(opreation.equals("-e")){
	  			encrypt(in,file_output,key);
	  		}
	  		else
	  		if(opreation.equals("-d")){
	  			decrypt(in,file_output,key);
	  		}
	     
	      
    }
}
