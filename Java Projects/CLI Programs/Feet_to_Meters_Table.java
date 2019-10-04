import java.util.*;
public class Feet_to_Meters_Table
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String pattern = "[0-9]{1,}.[0-9]{1,}", feetInput, meterInput;
		double foot, meter, meterConversion, footConversion;
		System.out.println("Enter the starting foot value");
		feetInput = in.nextLine();
		if(!(feetInput.matches(pattern)))
			System.out.println("The values entered is an incompatible value");
		else
		{
			foot = Double.parseDouble(feetInput);
			System.out.println("Enter the starting meter value");
			meterInput = in.nextLine();
			if(!(meterInput.matches(pattern)))
				System.out.println("The values entered are an incompatible value");
			else
			{
				meter = Double.parseDouble(meterInput);
				System.out.println("Feet\t\tMeters\t\t|\tMeters\t\t Feet");
				System.out.println("------------------------------------------------------------------");
				for(int i = 0; i < 10; i++)
				{
					meterConversion = footToMeter(foot);
					footConversion = meterToFoot(meter);
					System.out.println(foot + "\t\t" + meterConversion + "\t\t|\t" + meter + "\t\t" + footConversion);
					foot = foot + 1;
					meter = meter + 5;
				}
			}
		}
	}
	public static double footToMeter(double foot)
	{
		double newMeter = 0.305 * foot;
		return newMeter;
	}
	public static double meterToFoot(double meter)
	{
		double newFoot = 3.279 * meter;
		return newFoot;
	}
}