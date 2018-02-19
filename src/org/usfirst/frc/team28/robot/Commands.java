package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.*;

public class Commands {

	private TalonSRX bL = new TalonSRX(PinConstants.BL_MOTOR);
	private TalonSRX bR = new TalonSRX(PinConstants.BR_MOTOR);
	private TalonSRX fL = new TalonSRX(PinConstants.FL_MOTOR);
	private TalonSRX fR = new TalonSRX(PinConstants.FR_MOTOR);
	
	AnalogGyro gyro = new AnalogGyro(PinConstants.GYRO_PIN);
	
	public Commands()
	{
		
	}
	
	
	//turns set amount of degrees
	public void turn(double degrees)
	{
		
	}
	
	//drives forward for set amount of distance at a specified speed
	public void forward(double speed, double dist)
	{
		
		int time = 3000;
		
		long finishTime = System.currentTimeMillis() + time;
		
		while(System.currentTimeMillis() <= finishTime)
		{
			fR.set(ControlMode.PercentOutput, speed);
			fL.set(ControlMode.PercentOutput, speed);
			bR.set(ControlMode.PercentOutput, -1 * speed); 
			bL.set(ControlMode.PercentOutput, -1 * speed);
		}
		
		
		
		
	}
	
	//drops power cube
	public void drop()
	{
		
	}
	
}
