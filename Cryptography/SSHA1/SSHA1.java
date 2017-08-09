import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
 
public class SSHA1 {
    public static void main(String[] args) throws NoSuchAlgorithmException 
    {
    	   Hashtable<String, String> sshar   = new Hashtable<String, String>();

    	 
           int count = 0;

           
        String msg1 = "5632006";
        String msg2 = "5632006";
while(!(sshar.containsKey(sha1(msg2 + add(count)).substring(0, 8))))
{
	
	sshar.put(sha1(msg2+ add(count)).substring(0, 8), msg2+add(count));
	System.out.println(msg2+ add(count));

	count++;

	
}

        System.out.println("MSG-1 " + msg2 + add(count));
        System.out.println("CHAR-1 " + sha1(msg2 + add(count)));
        System.out.println("MSG-2 " + sshar.get(sha1(msg2+ add(count)).substring(0, 8)));
        System.out.println("CHAR-1 " +  sha1(sshar.get(sha1(msg2+ add(count)).substring(0, 8))));
        
        
    }
    
	static String add(int count)
	{
	char[] addOn = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	  

    String add = "";
    int rem;

while(count>0)
{
	rem=count%addOn.length;
	add=addOn[rem]+add;
	count=count/addOn.length;
}



return add;
}
	


static String sha1(String input) throws NoSuchAlgorithmException
 {
    MessageDigest mDigest = MessageDigest.getInstance("SHA1");
       byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
}
