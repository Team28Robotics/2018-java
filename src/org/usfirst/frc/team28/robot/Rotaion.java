package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotaion{
	AnalogGyro gyro;
	double header;
	PID pid;
	
	
	public Rotaion(int channel){
		gyro = new AnalogGyro(channel);
		header = gyro.getAngle();
		pid = new PID(0, 0, 0, gyro.getAngle());
	}
	
	public void reset(){
		header = gyro.getAngle();
	}
	
	public double update(double turnRight){
		SmartDashboard.putNumber("gyroAngle", gyro.getAngle());
		
		SmartDashboard.putNumber("Gyro", gyro.getAngle() % 360);
		
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
