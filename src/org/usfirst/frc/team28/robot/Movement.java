package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Movement {
	
	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	
	Controller controller;
	
	public Movement(Controller newController){
		controller = newController;
	
		rotaion.update(controller.getAxis("turnRight"));
		controller.getAxis("forward");
		controller.getAxis("right");
	}
	
	
	public double getFrontLeft()
	{
		return -1 * (controller.getAxis("forward") - controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setFrontLeft(double x)
	{
		fL.set(ControlMode.PercentOutput, x);
	}
	
	public double getFrontRight()
	{
		return (controller.getAxis("forward") + controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setFrontRight(double x)
	{
		fR.set(ControlMode.PercentOutput, x);
	}
	
	public double getBackLeft()
	{
		return -1 * (-controller.getAxis("forward") - controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setBackLeft(double x)
	{
		bL.set(ControlMode.PercentOutput, x);
	}
	
	public double getBackRight()
	{
		return (-controller.getAxis("forward") + controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setBackRight(double x)
	{
		bR.set(ControlMode.PercentOutput, x);
	}
	
 	public void update(){
 		
 		this.setFrontRight(this.getFrontRight());
 		this.setFrontLeft(this.getFrontLeft());
 		this.setBackRight(-this.getBackRight());
 		this.setBackLeft(this.getBackLeft());
 		
 		SmartDashboard.putNumber("forward", controller.getAxis("forward"));
    	SmartDashboard.putNumber("right", controller.getAxis("right"));
    	SmartDashboard.putNumber("turnRight", controller.getAxis("turnRight"));
 	}
 	
}
