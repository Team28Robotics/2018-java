package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Auto {

	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	public Auto(){
		
	}
	
	public void L_RRR()
	{
		fR.set(ControlMode.PercentOutput, -0.3);
		fL.set(ControlMode.PercentOutput, -0.3);
		bR.set(ControlMode.PercentOutput, 0.3); 
		bL.set(ControlMode.PercentOutput, 0.3);

	}
	
	public void M_RRR()
	{
		fL.set(ControlMode.PercentOutput, 0.3);

	}
	
	public void R_RRR()
	{

		bR.set(ControlMode.PercentOutput, -0.3); 
	}
	
	public void L_LLL()
	{
		//mecanum
//		fR.set(ControlMode.PercentOutput, 0.3);
//		fL.set(ControlMode.PercentOutput, -0.3);
//		bR.set(ControlMode.PercentOutput, 0.3); 
//		bL.set(ControlMode.PercentOutput, -0.3);
	
		//tank
		fR.set(ControlMode.PercentOutput, 0.3);
		fL.set(ControlMode.PercentOutput, 0.3);
		bR.set(ControlMode.PercentOutput, -0.3); 
		bL.set(ControlMode.PercentOutput, -0.3);
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
		//this works for mecanum drive (i think)
		
		/*fR.set(ControlMode.PercentOutput, -0.3);
		fL.set(ControlMode.PercentOutput, 0.3);
		bR.set(ControlMode.PercentOutput, -0.3); 
		bL.set(ControlMode.PercentOutput, 0.3);*/
		
		//this works for tank drive
		
		fR.set(ControlMode.PercentOutput, -0.3);
		fL.set(ControlMode.PercentOutput, -0.3);
		bR.set(ControlMode.PercentOutput, 0.3); 
		bL.set(ControlMode.PercentOutput, 0.3);
		
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
	
	public void defaultAuto()
	{
		fR.set(ControlMode.PercentOutput, 0);
		fL.set(ControlMode.PercentOutput, 0);
		bR.set(ControlMode.PercentOutput, 0); 
		bL.set(ControlMode.PercentOutput, 0);
	}
	
	
	
	
}
