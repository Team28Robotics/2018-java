package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.*;;


public class Movement {
	
	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	
	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	
	NetworkTableEntry tv = table.getEntry("tv");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");
	NetworkTableEntry ts = table.getEntry("ts");
	NetworkTableEntry tl = table.getEntry("tl");
	
	
	double x = tx.getDouble(0);
	double y = ty.getDouble(0);
	double area = ta.getDouble(0);
	
	double v = tv.getDouble(0);
	
	double turnAdjust = 0;
	double error = 0;
	double kP = -0.1;
	
	
	
	Controller controller;
	
	public Movement(Controller newController){
		controller = newController;
	
		
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
    	
    	SmartDashboard.putNumber("FR Input", this.getFrontRight());
    	SmartDashboard.putNumber("FL Input", this.getFrontLeft());
    	SmartDashboard.putNumber("BR Input", this.getBackRight());
    	SmartDashboard.putNumber("BL Input", this.getBackLeft());

 	}
 	
 	public void seek()
 	{
// 		if (v == 0)
// 		{
// 			turnAdjust = 0.3;
// 		}
// 		
// 		else
// 		{
// 			 error = x;
// 			 turnAdjust = kP * x;
// 	}
// 			
// 		 += turnAdjust;
// 		
// 		this.setFrontRight(x);
// 		this.setFrontLeft(x);
// 		this.setBackRight(x);
// 		this.setBackLeft(x);
 	}
 	
}
