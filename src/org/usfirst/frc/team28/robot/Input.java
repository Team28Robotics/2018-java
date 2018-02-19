package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;



public class Input {

	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	private Rotaion rotaion = new Rotaion(PinConstants.GYRO_PIN);
	
	private Spark claw = new Spark(PinConstants.CLAW);
	private Spark intake1 = new Spark(PinConstants.INTAKE_1);
	private Spark intake2 = new Spark(PinConstants.INTAKE_2);
	
	private Spark extend = new Spark(PinConstants.EXTEND);
	
	private Spark Lift1 = new Spark(PinConstants.LIFT_1);
	private Spark Lift2 = new Spark(PinConstants.LIFT_2);
	
//	private Spark front_back = new Spark(PinConstants.FRONT_BACK);
	
	private Controller c1;
	private Controller c2;
	
	

	public Input(Controller newController1, Controller newController2)
	{
		c1 = newController1;
		c2 = newController2;
	}
	
	
	
	//Grab
	
		public double getClaw()
		{
			if (c2.getButton("grab"))
			{	
				return -1;	
			}
			
			else if (c2.getButton("drop"))
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
			return  c2.getAxis("intake") - c2.getAxis("out");
		}
		
		public void setIntake(double x)
		{
			intake1.set(x);
			intake2.set(x);
			
		}
		
		
		

	
	//Movement
	
	
	
	
		public double getExtend()
		{
			if (c2.getButton("extend"))
			{	
				return -1;	
			}
			
			else if (c2.getButton("retract"))
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

	
	
	
	
	
	
	
	
	
		
	//Lift
	
	public double getLift1()
	{
		return c2.getAxis("Lift1");
	}
	
	public void setLift1(double x)
	{
		Lift1.set(x);
	}
	
	public double getLift2()
	{
		return c2.getAxis("Lift2");
	}
	
	public void setLift2(double x)
	{
		Lift2.set(x);
	}

	
	
	
	
	
	public double getFrontLeft()
	{
		return -1 * (c1.getAxis("forward") - c1.getAxis("right") - rotaion.update(c1.getAxis("turnRight")));
	}
	
	public void setFrontLeft(double x)
	{
		fL.set(ControlMode.PercentOutput, x);
	}
	
	public double getFrontRight()
	{
		return (c1.getAxis("forward") + c1.getAxis("right") - rotaion.update(c1.getAxis("turnRight")));
	}
	
	public void setFrontRight(double x)
	{
		fR.set(ControlMode.PercentOutput, x);
	}
	
	public double getBackLeft()
	{
		return -1 * (-c1.getAxis("forward") - c1.getAxis("right") - rotaion.update(c1.getAxis("turnRight")));
	}
	
	public void setBackLeft(double x)
	{
		bL.set(ControlMode.PercentOutput, x);
	}
	
	public double getBackRight()
	{
		return (-c1.getAxis("forward") + c1.getAxis("right") - rotaion.update(c1.getAxis("turnRight")));
	}
	
	public void setBackRight(double x)
	{
		bR.set(ControlMode.PercentOutput, x);
	}
	
    public void display()
    {
    	SmartDashboard.putNumber("forward", c1.getAxis("forward"));
    	SmartDashboard.putNumber("right", c1.getAxis("right"));
    	SmartDashboard.putNumber("turnRight", c1.getAxis("turnRight"));
    }
    
    
}
