package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Rotaion{

	private double header;
	private PID pid;
	private ADXRS450_Gyro gyro;
	
	
	public Rotaion(int channel){
		gyro = new ADXRS450_Gyro();
		header = gyro.getAngle();
		pid = new PID(0, 0, 0, gyro.getAngle());
	}
	
	public void reset(){
		header = gyro.getAngle();
	}
	
	public void gyroReset()
	{
		gyro.reset();
	}
	
	public void gyroCalibrate()
	{
		gyro.calibrate();
	}
	
	public double getGyro()
	{
		return gyro.getAngle();
	}
	
	public void display()
	{
		SmartDashboard.putNumber("gyroAngle", gyro.getAngle());
		
		SmartDashboard.putNumber("Gyro", Math.abs(gyro.getAngle() % 360));
		
		SmartDashboard.putNumber("Header", header);

	}
	
	public double update(double turnRight){
//		SmartDashboard.putNumber("gyroAngle", gyro.getAngle());
//		
//		SmartDashboard.putNumber("Gyro", Math.abs(gyro.getAngle() % 360));
		
		if (turnRight == 0) {
			
			try{
				return pid.update((header - gyro.getAngle()) % 180);
			} catch(Exception e){
				e.printStackTrace();
				return 0;
			}
			
		} else {
			return turnRight;
		}
		
	}
	
	public static double DiffAngle(int current, int target){
		return Math.floorMod(target - current + 180, 360)-180;
	}
}
