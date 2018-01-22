package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Movement {
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	private Controller controller;
	private double spin, gyroAngle;
	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	private final double SLOW = 0.5; 
	
	
	public Movement(Controller newController){
		controller = newController;
		
	}
	
 	public void update(){
 		double turnRight = rotaion.update(controller.getAxis("turnRight"));
 		double forward = controller.getAxis("forward");
 		double right = controller.getAxis("right");

// 		double sped = 0.3;
// 		
// 		fR.set(ControlMode.PercentOutput, -1 * sped);
// 		fL.set(ControlMode.PercentOutput, sped);
//		bR.set(ControlMode.PercentOutput, -1 * sped); 
// 		bL.set(ControlMode.PercentOutput, sped);
 		
 		// Negate right motors
 		double negate = -1;
 		
 		
 		
 		 		
 		fR.set(ControlMode.PercentOutput, negate * (-1 * (forward + right + turnRight)));
 		fL.set(ControlMode.PercentOutput, negate * (forward - right - turnRight));
		bR.set(ControlMode.PercentOutput, negate * (-1 * (forward - right + turnRight))); 
 		bL.set(ControlMode.PercentOutput, negate * (forward + right - turnRight));
 		
 		
 		
 		
 		
 		
 		
 		
// 		if(controller.getButton("slow")){
// 			
// 			fR.set(ControlMode.PercentOutput, negate * (SLOW * (-1 * (controller.getAxis("forward")) + controller.getAxis("right") + turnRight)));
//			fL.set(ControlMode.PercentOutput, negate * (-1 * SLOW * (-1 * (controller.getAxis("forward")) + controller.getAxis("right") + turnRight))); 
//		
//			bR.set(ControlMode.PercentOutput, negate * (SLOW * (-1 * (controller.getAxis("forward")) -1 * (controller.getAxis("right")) + turnRight)));
//			bL.set(ControlMode.PercentOutput, negate * (SLOW * (controller.getAxis("forward") -1 * (controller.getAxis("right")) + turnRight)));	
// 		}
// 		else
// 		{
// 			fR.set(ControlMode.PercentOutput, negate * (-1 * (controller.getAxis("forward")) + controller.getAxis("right") + turnRight));
// 			fL.set(ControlMode.PercentOutput, negate * (-1 * (-1 * (controller.getAxis("forward")) + controller.getAxis("right") + turnRight)));
// 		
// 			bR.set(ControlMode.PercentOutput, negate * (-1 * (controller.getAxis("forward")) -1 * (controller.getAxis("right")) + turnRight));
// 			bL.set(ControlMode.PercentOutput, negate * (controller.getAxis("forward") -1 * (controller.getAxis("right")) + turnRight));
// 		}	
//		
 		
 		
		//test.set(0.5);
		//rotaion.reset();
		
		SmartDashboard.putNumber("front right speed", fR.getSensorCollection().getQuadratureVelocity());
		SmartDashboard.putNumber("front left speed", fL.getSensorCollection().getQuadratureVelocity());
		
		/*
		if ((-1 * (controller.getAxis("forward")) + controller.getAxis("right") + rotaion.update(controller.getAxis("turnRight"))) == 0){
			//System.out.println("nothing wrong");
		}
		else
			System.out.println("everything is wrong");
		*/
			
	}
	
	
}
