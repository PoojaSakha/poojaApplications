


package com.sakha.global;
import java.util.Scanner;


class TesterClass 
{

	public static void main(String[] args)
	{
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int ch1=0;
		try
		{
			RegisterUser reg = new RegisterUser();
			LoginUser log = new LoginUser();
			while(ch1!=3)
			{
				System.out.println("Enter the Option 1 to Register");
				System.out.println("Enter the Option 2 to Login");
				System.out.println("Enter the Option 3 to exit");
				ch1=sc1.nextInt();
				switch (ch1) 
				{
				case 1:
					reg.register(sc2);
					break;
				case 2:
					log.login(sc2);
					break;
				case 3:
					System.out.println("Exiting..!!");
					break;
				default:
					System.out.println("Invalid option");
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sc1.close();
		}
		
	}

	/*private static RegisterUser getInstance() {
		// TODO Auto-generated method stub
		return null;
	}*/

}