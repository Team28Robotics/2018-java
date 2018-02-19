package org.usfirst.frc.team28.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoPlay {

	Scanner scanner;
	long startTime;

	boolean onTime = true;
	double nextDouble;
	
	public AutoPlay() throws FileNotFoundException
	{
		scanner = new Scanner(new File(Robot.autoFile));
		
		scanner.useDelimiter(",|\\n");
		
		startTime = System.currentTimeMillis();	
	}
	
	public void play(Input input)
	{
		if ((scanner != null) && (scanner.hasNextDouble()))
		{
			double t_delta;
			
			if(onTime)
			{
				nextDouble = scanner.nextDouble();
			}
			
			t_delta = nextDouble - (System.currentTimeMillis()-startTime);
			
			if (t_delta <= 0)
			{
				
				input.setFrontLeft(scanner.nextDouble());
				input.setFrontRight(scanner.nextDouble());
				input.setBackLeft(scanner.nextDouble());
				input.setBackRight(scanner.nextDouble());
				
				input.setLift1(scanner.nextDouble());
				input.setLift2(scanner.nextDouble());

				input.setIntake(scanner.nextDouble());
				input.setClaw(scanner.nextDouble());
				
				onTime = true;
			}
			
			else
			{
				onTime = false;
			}
		}
		
		else
		{
			this.end(input);
			if (scanner != null) 
			{
				scanner.close();
				scanner = null;
			}
		}
		
	}
	
	public void end(Input input)
	{
		
		input.setFrontLeft(0);
		input.setFrontRight(0);
		input.setBackLeft(0);
		input.setBackRight(0);
		
		input.setLift1(0);
		input.setLift2(0);

		input.setIntake(0);		
		input.setClaw(0);
		
		if (scanner != null)
		{
			scanner.close();
		}
		
	}
	
	public double test(Input input)
	{
		return input.getLift1();
	}
}
