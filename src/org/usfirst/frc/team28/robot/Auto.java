package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auto {

	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	Movement move;
	Lift lift;
	Grab grab;
	Commands c;
	
	public Auto()
	{
		
	}
	
	public void L_RRR()
	{
		
	}
	
	public void M_RRR()
	{

	}
	
	public void R_RRR()
	{

	}
	
	public void L_LLL()
	{
		
	}
	
	public void M_LLL()
	{
		
	}
	
	public void R_LLL()
	{
		
	}
	
	public void L_RLR()
	{
		
	}
	
	public void M_RLR()
	{
		
		
	}
	
	public void R_RLR()
	{
		
	}
	
	public void L_LRL()
	{
		
	}
	
	public void M_LRL()
	{
		
	}
	
	public void R_LRL()
	{
		
	}
	
	public void cross()
	{		
		c.driveDistance(1000, 0.3);
	}
	
	public void defaultAuto()
	{
		
	}
	
	
	
	
	
	
}
