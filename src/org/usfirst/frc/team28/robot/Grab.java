package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Grab {

	private Spark grab = new Spark(PinConstants.GRAB);
	
	private Controller controller;
	
	public Grab(Controller newController){
		controller = newController;
	}
	
	public void update(){
		 
		if(controller.getButton("grab")){
			grab.set(1);
		}
		
		else
			grab.set(-1);
	}
}


