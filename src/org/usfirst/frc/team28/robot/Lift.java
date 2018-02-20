package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift {
	

	private Controller controller;
	
	private Spark extend = new Spark(PinConstants.EXTEND);
	
	private Spark Lift1 = new Spark(PinConstants.LIFT_1);
	private Spark Lift2 = new Spark(PinConstants.LIFT_2);	
	
	
	public Lift(Controller newController){
		controller = newController;
	}
		
	
	public double getExtend()
	{
		if (controller.getButton("extend"))
		{	
			return -1;	
		}
		
		else if (controller.getButton("retract"))
		{
			return 1;
		}
		
		else
			return 0;
	}
	
	public void setExtend(double x)
	{
		extend.set(x);
	}


	public double getLift1()
	{
		return controller.getAxis("Lift1");
	}
	
	public void setLift1(double x)
	{
		Lift1.set(x);
	}
	
	public double getLift2()
	{
		return controller.getAxis("Lift2");
	}
	
	public void setLift2(double x)
	{
		Lift2.set(x);
	}

	
	public void update(){
		
		this.setLift1(this.getLift1());
		this.setLift2(this.getLift2());
		this.setExtend(this.getExtend());

		
		
		
	}
}

