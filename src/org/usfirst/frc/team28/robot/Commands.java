package org.usfirst.frc.team28.robot;


public class Commands {

	Movement move;
	Grab grab;
	Lift lift;
		
	public Commands()
	{
		
	}
	
	
	public void driveDistance(double dist, double speed)
	{		
		
		if(move.getFLEncDist() < dist)
		{
			str8(speed);
		}
		
		if(move.getFREncDist() < dist)
		{
			str8(speed);
		}
		
		if(move.getBLEncDist() < dist)
		{
			str8(speed);
		}
		
		if(move.getBREncDist() < dist)
		{	
			str8(speed);
		}
		
		
	}
	
	public void turn(double deg)
	{
		
	}
	
	public void str8(double speed)
	{
		move.setAll(speed);
		
		if(move.rotaion.getGyro() > 15)
		{
			move.setRight(speed + 0.01);
			move.setLeft(speed - 0.01);
		}
		
		else if(move.rotaion.getGyro() < -15)
		{
			move.setRight(speed - 0.01);
			move.setLeft(speed + 0.01);
		}
		
		
	}
	
	
	
}
