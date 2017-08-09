import java.awt.EventQueue;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class encrypt__app extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					encrypt__app frame = new encrypt__app();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public	String password = "";
	public	String file_input = "";
	public	String file_output = "";
	public	String opreation = "";
	public	String opreation_1 = "";

	public encrypt__app() {

		
		
	    JFileChooser fc = new JFileChooser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while (bg.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if(jrd.isSelected())
						if(jrd.getText().equals("Encrypt"))
						{
							opreation_1 = jrd.getText();
							opreation = "-e"; 
						}
						else if(jrd.getText().equals("Decrypt"))
						{
							opreation_1 = jrd.getText();
							opreation = "-d"; 
						}
							
				}
				 password = textField.getText();
				
				 try {
					start( opreation, password, file_input,  file_output );	
					JOptionPane.showMessageDialog(null,"file " + opreation_1); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"file " + opreation_1 + " error!"); 
					e.printStackTrace();
				}

				
			}
		});
		btnStart.setBounds(59, 309, 424, 23);
		contentPane.add(btnStart);
		
		JRadioButton rdbtnEncrypt = new JRadioButton("Encrypt");
		rdbtnEncrypt.setBounds(5, -1, 98, 304);
		JRadioButton rdbtnDecrypt = new JRadioButton("Decrypt");
		rdbtnDecrypt.setBounds(421, 39, 124, 228);
		rdbtnEncrypt.setSelected(true);
		buttonGroup.add(rdbtnEncrypt);
		buttonGroup.add(rdbtnDecrypt);
		contentPane.add(rdbtnEncrypt);
		contentPane.add(rdbtnDecrypt);
		
		JLabel lblKey = new JLabel("Key");
		lblKey.setBounds(123, 75, 46, 15);
		contentPane.add(lblKey);
		
		textField = new JTextField();
		textField.setBounds(283, 72, 132, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOutputFileName = new JLabel("output file name");
		lblOutputFileName.setBounds(123, 106, 111, 15);
		contentPane.add(lblOutputFileName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(283, 103, 132, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JLabel lblNoFileChosen = new JLabel("No file chosen");
		lblNoFileChosen.setBounds(126, 284, 262, 15);
		contentPane.add(lblNoFileChosen);
		
		Button button = new Button("Choose a file...");
		button.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {

		        //Handle open button action.
		        if (e.getSource() == button) {
		            int returnVal = fc.showOpenDialog(encrypt__app.this);

		            if (returnVal == JFileChooser.APPROVE_OPTION) {
		                file_input = fc.getSelectedFile().getAbsolutePath();
		                file_output = fc.getSelectedFile().getParentFile().getPath()+ "\\" + textField_1.getText() + ".txt";
		              
		                
		                lblNoFileChosen.setText(file_input);
		            }	           

		        }
				
		    }

		});
		button.setBounds(126, 244, 199, 23);
		contentPane.add(button);
		
		
	}
	
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
	

	


	public static void start(String opreation,String password,String file_input, String file_output ) throws IOException {

		
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
