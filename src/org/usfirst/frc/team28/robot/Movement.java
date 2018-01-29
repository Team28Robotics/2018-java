package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Movement {
	
	private static final String kMecanumDrive = "Mecanum";
	private static final String kTankDrive = "My Auto";
	private String m_driveSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	 
	private Controller controller;
	
	private double spin, gyroAngle;
	
	// motor controllers
	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	// multiplier for slow mode
	private final double SLOW = 0.5; 
	
	
	public Movement(Controller newController){
		controller = newController;
		
	}
	
 	public void update(){
 		
 		
 		
 		
 		// variables for joystick inputs
 		double turnRight = rotaion.update(controller.getAxis("turnRight"));
 		double forward = controller.getAxis("forward");
 		double right = controller.getAxis("right");
 		 		
 		// code for 
 		double f = forward;
 		
 		if(f <= -0.9 && f >= -1)
 		{
 			forward = -1;
 			right = 0;
 		}
 		
 		 	SmartDashboard.putNumber("forward", forward);
 		 	SmartDashboard.putNumber("right", right);
 		 	SmartDashboard.putNumber("turn", turnRight);

 		double negate = -1;
 		
 		
 		
 		m_chooser.addDefault("Mecanum Drive", kMecanumDrive);
		m_chooser.addObject("Tank Drive", kTankDrive);
		SmartDashboard.putData("Auto choices", m_chooser);
 		
		m_driveSelected = m_chooser.getSelected();
		
		switch (m_driveSelected) {
		case kTankDrive:
			
	 		if(controller.getButton("slow"))
	 		{
	 			
	 			fR.set(ControlMode.PercentOutput, SLOW * (negate * (-1 * (forward + turnRight))));
	 	 		fL.set(ControlMode.PercentOutput, SLOW * (negate * (forward - turnRight)));
	 			bR.set(ControlMode.PercentOutput, SLOW * (negate * (-1 * (forward + turnRight)))); 
	 	 		bL.set(ControlMode.PercentOutput, SLOW * (negate * (forward - turnRight)));	
	 			
	 		}
	 		
	 		else
	 		{
	 		
	 			fR.set(ControlMode.PercentOutput, negate * (-1 * (forward + turnRight)));
	 			fL.set(ControlMode.PercentOutput, negate * (forward - turnRight));
	 			bR.set(ControlMode.PercentOutput, negate * (-1 * (forward + turnRight))); 
	 			bL.set(ControlMode.PercentOutput, negate * (forward - turnRight));
	 		
	 		}
 
			
			break;
		case kMecanumDrive:
		default:
			
	 		if(controller.getButton("slow"))
	 		{
	 			
	 			fR.set(ControlMode.PercentOutput, SLOW * (negate * (-1 * (forward + right + turnRight))));
	 	 		fL.set(ControlMode.PercentOutput, SLOW * (negate * (forward - right - turnRight)));
	 			bR.set(ControlMode.PercentOutput, SLOW * (negate * (-1 * (forward - right + turnRight)))); 
	 	 		bL.set(ControlMode.PercentOutput, SLOW * (negate * (forward + right - turnRight)));	
	 			
	 		}
	 		
	 		else
	 		{
	 		
	 			fR.set(ControlMode.PercentOutput, negate * (-1 * (forward + right + turnRight)));
	 			fL.set(ControlMode.PercentOutput, negate * (forward - right - turnRight));
	 			bR.set(ControlMode.PercentOutput, negate * (-1 * (forward - right + turnRight))); 
	 			bL.set(ControlMode.PercentOutput, negate * (forward + right - turnRight));
	 		
	 		}
 
	 		SmartDashboard.putNumber("front right speed", -1 * fR.getSensorCollection().getQuadratureVelocity());
			SmartDashboard.putNumber("front left speed", fL.getSensorCollection().getQuadratureVelocity());
			
			double difference = Math.abs(-1 * fR.getSensorCollection().getQuadratureVelocity() - fL.getSensorCollection().getQuadratureVelocity());
			
			
			
			SmartDashboard.putNumber("difference", difference);
			
			SmartDashboard.putNumber("back right speed", bR.getSensorCollection().getQuadratureVelocity());
			SmartDashboard.putNumber("back left speed", bL.getSensorCollection().getQuadratureVelocity());

			
			break;
 		
 		
 		
		
 		
 		
 		
 		
 		
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
		
				
		
		
		
		
		/*
		if ((-1 * (controller.getAxis("forward")) + controller.getAxis("right") + rotaion.update(controller.getAxis("turnRight"))) == 0){
			//System.out.println("nothing wrong");
		}
		else
			System.out.println("everything is wrong");
		*/
			
	}
	
	
 	}
}

