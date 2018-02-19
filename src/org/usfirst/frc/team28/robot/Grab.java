package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Grab {

//	public static Spark claw = new Spark(PinConstants.CLAW);
//	public static Spark intake = new Spark(PinConstants.INTAKE);
	
	
	
//	private Controller controller;
	
	private Input input;
	
	public Grab(Input newInput){
		input = newInput;
	}
	
	public void update(){
		 
		input.setClaw(input.getClaw());
		
		
		input.setIntake(input.getIntake());
		
				
//		intake.set(controller.getAxis("intake"));
//			
//		if(controller.getButton("intake"))
//		{
//			intake.set(1);
//		}
//		else if(controller.getButton("out"))
//		{
//			intake.set(-1);
//		}
//		
//		
//		if (controller.getButton("grab"))
//		{
//			
//			claw.set(-1);
//			
//			
//			
//		}
//		else if (controller.getButton("drop"))
//		{
//			
//			claw.set(1);
//			intake.set(0);
//			
//		}
//		else
//		{
//			claw.set(0);
//			intake.set(0);
//		}
//		
//		SmartDashboard.putNumber("Out Volt", intake.getSpeed());
		
	}
}


