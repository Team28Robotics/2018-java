package org.usfirst.frc.team28.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

public class Lift {
	
//	public static Spark Lift1 = new Spark(PinConstants.LIFT_1);
//	public static Spark Lift2 = new Spark(PinConstants.LIFT_2);
//	
//	private Encoder LiftEnc1 = new Encoder(PinConstants.LIFT_1_ENC_A, PinConstants.LIFT_1_ENC_B);
//	private Encoder LiftEnc2 = new Encoder(PinConstants.LIFT_2_ENC_A, PinConstants.LIFT_2_ENC_B);
//	
//	private DigitalInput upLimit = new DigitalInput(PinConstants.UP_LIM);
//	private DigitalInput downLimit = new DigitalInput(PinConstants.DOWN_LIM);
//
//	private final double GROUND = 1.0;
//	private final double SWITCH = 0.0;
//	private final double SCALE = 3.0;
//	private final double HANG = 0.0;
//	
//	private Controller controller;
	
	private Input input;
	
	public Lift(Input newInput){
		input = newInput;
	}
		
	public void update(){
		
		
		input.setLift1(input.getLift1());
		input.setLift2(input.getLift2());
		input.setExtend(input.getExtend());

		
		
		
		
		// sets lift motor to move up or down depending on which limit switch is activated
//		if(upLimit.get() == true)
//		{
//			Lift1.set(-1);
//		}
//		else if(downLimit.get() == true)
//		{
//			Lift1.set(1);
//		}
//		else
//		{
//				
//			// reads position and then sets position of the arm depending on the desired encoder value.
//			if(controller.getButton("ground") || controller.getButton("switch") || controller.getButton("scale") || controller.getButton("hang")){
//				
//				if(controller.getButton("ground")){
//				
//					if((LiftEnc1.get() + LiftEnc2.get()) == GROUND){
//						Lift1.set(0);
//						Lift2.set(0);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) > GROUND){
//						Lift1.set(-1);
//						Lift2.set(-1);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) < GROUND){
//						Lift1.set(1);
//						Lift2.set(1);
//					}
//				}
//			
//				if(controller.getButton("switch")){
//				
//					if((LiftEnc1.get() + LiftEnc2.get()) == SWITCH){
//						Lift1.set(0);
//						Lift2.set(0);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) > SWITCH){
//						Lift1.set(-1);
//						Lift2.set(-1);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) < SWITCH){
//						Lift1.set(1);
//						Lift2.set(1);
//					}
//				}
//			
//				if(controller.getButton("scale")){
//				
//					if((LiftEnc1.get() + LiftEnc2.get()) == SCALE){
//						Lift1.set(0);
//						Lift2.set(0);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) > SCALE){
//						Lift1.set(-1);
//						Lift2.set(-1);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) < SCALE){
//						Lift1.set(1);
//						Lift2.set(1);
//					}
//				}
//			
//				if(controller.getButton("hang")){
//				
//					if((LiftEnc1.get() + LiftEnc2.get()) == HANG){
//						Lift1.set(0);
//						Lift2.set(0);
//					}
//				
//					else if((LiftEnc1.get() + LiftEnc2.get()) > HANG){
//						Lift1.set(-1);
//						Lift2.set(-1);
//					}	
//					
//					else if((LiftEnc1.get() + LiftEnc2.get()) < HANG){
//						Lift1.set(1);
//						Lift2.set(1);
//					}
//				}
//			}
//			
//			// sets the lift motor depending on joystick input
//			else
//			{
//			
//				Lift1.set(-1 * (controller.getAxis("manualLift") + (0.5 * controller.getAxis("precisionLift"))));
//				Lift2.set(controller.getAxis("manualLift") + (0.2 * controller.getAxis("precisionLift")));
//			}
//			
//		}
		

//	Lift1.set((controller.getAxis("manualLift") + (0.5 * controller.getAxis("precisionLift"))));
//	Lift2.set(controller.getAxis("manualLift") + (0.2 * controller.getAxis("precisionLift")));
		
	}
}

