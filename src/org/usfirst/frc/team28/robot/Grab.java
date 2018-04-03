package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Grab {
	
	private Spark claw = new Spark(PinConstants.CLAW);
	private Spark intake1 = new Spark(PinConstants.INTAKE_R);
	private Spark intake2 = new Spark(PinConstants.INTAKE_L);
	private Controller controller;
		
	public Grab(Controller newController){
		controller = newController;
	}
	
	public double getClaw()
	{
		if (controller.getButton("grab"))
		{	
			return -1;	
		}
		
		else if (controller.getButton("drop"))
		{
			return 1;
		}
		
		else
			return 0;
	}
	
	public void setClaw(double x)
	{
		claw.set(x);
	}
	
	public double getIntake()
	{		
		return  controller.getAxis("intake") - controller.getAxis("out");
	}
	
	public void setIntake(double x)
	{
		intake1.set(x);
		intake2.set(x);
		
	}
	
	
	public void update(){
		 
		this.setClaw(this.getClaw());
		this.setIntake(this.getIntake());
		
				

		
	}
}


