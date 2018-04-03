package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.*;


public class Movement {
	
	private WPI_TalonSRX bL = new WPI_TalonSRX(PinConstants.BL_MOTOR);
	private WPI_TalonSRX bR = new WPI_TalonSRX(PinConstants.BR_MOTOR);
	private WPI_TalonSRX fL = new WPI_TalonSRX(PinConstants.FL_MOTOR);
	private WPI_TalonSRX fR = new WPI_TalonSRX(PinConstants.FR_MOTOR);
	
	
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
	Rotaion rotaion;
	
	public Movement(Controller newController, Rotaion newRotaion){
		controller = newController;
		rotaion = newRotaion;
	
		
	}
	
	
	public void manualGyroReset()
	{
		if(controller.getButton("resetGyro"))
		{
			rotaion.gyroReset();
		}
	}
	
	public double getFrontLeft()
	{
		return -1 * (controller.getAxis("forward") - controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
//		return -1 * (controller.getAxis("forward") - controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight"))); 
	}
	
	public void setFrontLeft(double x)
	{
		fL.set(ControlMode.PercentOutput, x);
	}
	
	public double getFrontRight()
	{
		return (controller.getAxis("forward") + controller.getAxis("right") + rotaion.update(controller.getAxis("turnRight")));
//		return (controller.getAxis("forward") + controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setFrontRight(double x)
	{
		fR.set(ControlMode.PercentOutput, x);
	}
	
	public double getBackLeft()
	{
		return -1 * (controller.getAxis("forward") + controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
//		return -1 * (-controller.getAxis("forward") - controller.getAxis("right") - rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setBackLeft(double x)
	{
		bL.set(ControlMode.PercentOutput, x);
	}
	public double getBackRight()
	{
		return (controller.getAxis("forward") - controller.getAxis("right") + rotaion.update(controller.getAxis("turnRight")));
//		return (controller.getAxis("forward") - controller.getAxis("right") + rotaion.update(controller.getAxis("turnRight")));
	}
	
	public void setBackRight(double x)
	{
		bR.set(ControlMode.PercentOutput, x);
	}
	
	public void setAll(double x)
	{
		setFrontLeft(x);
		setFrontRight(x);
		setBackLeft(x);
		setBackRight(x);
	}
	
	public void setRight(double x)
	{
		setFrontRight(x);
		setBackRight(x);
	}
	
	
	public void setLeft(double x)
	{
		setFrontLeft(x);
		setBackLeft(x);
	}
	
 	public void resetEncoder()
 	{
 		bL.getSensorCollection().setQuadraturePosition(0, 0);
 		bR.getSensorCollection().setQuadraturePosition(0, 0);
 		fL.getSensorCollection().setQuadraturePosition(0, 0);
 		fR.getSensorCollection().setQuadraturePosition(0, 0);	
 	}
 	
 	public double getFLEncDist()
 	{
 		return fL.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getFREncDist()
 	{
 		return fR.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getBLEncDist()
 	{
 		return fL.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getBREncDist()
 	{
 		return fL.getSensorCollection().getQuadraturePosition();
 	}
 	
 	public double getFLEncRate()
 	{
 		return fL.getSensorCollection().getQuadratureVelocity();
 	}
 	
 	public double getFREncRate()
 	{
 		return fR.getSensorCollection().getQuadratureVelocity();
 	}
 	
 	public double getBLEncRate()
 	{
 		return fL.getSensorCollection().getQuadratureVelocity();
 	}
 	
 	public double getBREncRate()
 	{
 		return fL.getSensorCollection().getQuadratureVelocity();
 	}
 	
	
	public void update(){
 		
 		rotaion.reset();
 		
 		
 		manualGyroReset();
 		
 		this.setFrontRight(this.getFrontRight());
 		this.setFrontLeft(this.getFrontLeft());
 		this.setBackRight(this.getBackRight());
 		this.setBackLeft(this.getBackLeft());
 		
 		SmartDashboard.putNumber("forward", controller.getAxis("forward"));
    	SmartDashboard.putNumber("right", controller.getAxis("right"));
    	SmartDashboard.putNumber("turnRight", controller.getAxis("turnRight"));
    	
    	SmartDashboard.putNumber("FR Input", this.getFrontRight());
    	SmartDashboard.putNumber("FL Input", this.getFrontLeft());
    	SmartDashboard.putNumber("BR Input", this.getBackRight());
    	SmartDashboard.putNumber("BL Input", this.getBackLeft());
    	
    	double FLEncoderDist = this.getFLEncDist();
    	double FREncoderDist = this.getFREncDist();
    	double BLEncoderDist = this.getBLEncDist();
    	double BREncoderDist = this.getBREncDist();
    	
    	SmartDashboard.putNumber("Front Left Encoder Distance", FLEncoderDist);
    	SmartDashboard.putNumber("Front Right Encoder Distance", FREncoderDist);
    	SmartDashboard.putNumber("Back Left Encoder Distance", BLEncoderDist);
    	SmartDashboard.putNumber("Back Right Encoder Distance", BREncoderDist);
    	
    	double FLEncoderRate = this.getFLEncRate();
    	double FREncoderRate = this.getFREncRate();
    	double BLEncoderRate = this.getBLEncRate();
    	double BREncoderRate = this.getBREncRate();
    	
    	SmartDashboard.putNumber("Front Left Encoder Rate", FLEncoderRate);
    	SmartDashboard.putNumber("Front Right Encoder Rate", FREncoderRate);
    	SmartDashboard.putNumber("Back Left Encoder Rate", BLEncoderRate);
    	SmartDashboard.putNumber("Back Right Encoder Rate", BREncoderRate);
    	
    	    	
    	rotaion.display();
    	
    	
    	
    	
    	    	
 	}
 	

 	
}





















