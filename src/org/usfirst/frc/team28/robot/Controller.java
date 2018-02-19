package org.usfirst.frc.team28.robot;

import java.util.*;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {
	
	private Map<String,Double> axisMap;
	private Map<String, Boolean> buttonMap;
	private XboxController Controller1;
	private XboxController Controller2;
	
	public Controller()
	{
		
		axisMap = new HashMap <>();
		buttonMap = new HashMap<>();
		Controller1 = new XboxController(0);
		Controller2 = new XboxController(1);
		update();
		
	}
	
	public void update()
	{
		axisMap.put("forward", Controller1.getY(GenericHID.Hand.kLeft)); 
		axisMap.put("right", Controller1.getX(GenericHID.Hand.kLeft));
		axisMap.put("turnRight", Controller1.getTriggerAxis(GenericHID.Hand.kRight) - (Controller1.getTriggerAxis(GenericHID.Hand.kLeft)));
		
		
		buttonMap.put("slow", Controller1.getBumper(GenericHID.Hand.kRight));
		buttonMap.put("record", Controller1.getBumper(GenericHID.Hand.kLeft));



		
		axisMap.put("Lift1", Controller2.getY(GenericHID.Hand.kLeft));
		axisMap.put("Lift2", Controller2.getY(GenericHID.Hand.kRight));
		
		axisMap.put("intake", Controller2.getTriggerAxis(GenericHID.Hand.kRight));
		axisMap.put("out", Controller2.getTriggerAxis(GenericHID.Hand.kLeft));
		
		
		buttonMap.put("retract", Controller2.getBumper(GenericHID.Hand.kRight));
		buttonMap.put("extend", Controller2.getBumper(GenericHID.Hand.kLeft));
		
		buttonMap.put("grab", Controller2.getAButton());
		buttonMap.put("drop", Controller2.getBButton());
		
		//moves the tower forwards and backwards
//		buttonMap.put("front", Controller2.getXButton());
//		buttonMap.put("back", Controller2.getYButton());
		
//		buttonMap.put("ground", Controller2.getAButton());
//		buttonMap.put("switch", Controller2.getBButton());
//		buttonMap.put("scale", Controller2.getYButton());
//		buttonMap.put("hang", Controller2.getXButton());
		
		


	}
	
	
	public double getAxis(String name)
	{
		return axisMap.get(name);
	}
	
	public boolean getButton(String name)
	{
		return buttonMap.get(name);
	}
	
}
 