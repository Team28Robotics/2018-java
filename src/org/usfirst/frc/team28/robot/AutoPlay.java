package org.usfirst.frc.team28.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoPlay {

	Scanner scanner;
	long startTime;

	boolean onTime = true;
	double nextDouble;
	
	public AutoPlay(String autoFile) throws FileNotFoundException
	{
		scanner = new Scanner(new File(autoFile));
		
		scanner.useDelimiter(",|\\n");
		
		startTime = System.currentTimeMillis();	
	}
	
	
	
	public void play(Movement move, Lift lift, Grab grab)
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
				
				move.setFrontLeft(scanner.nextDouble());
				move.setFrontRight(scanner.nextDouble());
				move.setBackLeft(scanner.nextDouble());
				move.setBackRight(scanner.nextDouble());
				
				lift.setLift1(scanner.nextDouble());
				lift.setLift2(scanner.nextDouble());

				grab.setIntake(scanner.nextDouble());
				grab.setClaw(scanner.nextDouble());
				
				onTime = true;
			}
			
			else
			{
				onTime = false;
			}
		}
		
		else
		{
			this.end(move, lift, grab);
			if (scanner != null) 
			{
				scanner.close();
				scanner = null;
			}
		}
		
	}
	
	public void end(Movement move, Lift lift, Grab grab)
	{
		
		move.setFrontLeft(0);
		move.setFrontRight(0);
		move.setBackLeft(0);
		move.setBackRight(0);
		
		lift.setLift1(0);
		lift.setLift2(0);

		grab.setIntake(0);		
		grab.setClaw(0);
		
		if (scanner != null)
		{
			scanner.close();
		}
		
	}
	
}
