/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team28.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.*;

import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kLeft = "Left";
	private static final String kMiddle  = "Middle";
	private static final String kRight = "Right";
	private static final String kCross = "Cross";
	private static final String kDefault = "Default";
	private static final String kExperimental = "Experimental";

	private String autoMode;
	private SendableChooser<String> mode = new SendableChooser<>();
	
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	private String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	boolean isRecording = false;
	
	static final int autoNumber = 10;
	
	static final String autoFile = new String("/home/lvuser/AutoFiles" + autoNumber + ".csv");
	
	AutoPlay player;
	AutoRecord recorder;
	Input input;
	Movement movement;
	Controller controller1;
	Controller controller2;
	Lift lift;
	Auto auto;
	Grab grab;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Cross", kCross);
		m_chooser.addObject("Left", kLeft);
		m_chooser.addObject("Middle", kMiddle);
		m_chooser.addObject("Right", kRight);

		SmartDashboard.putData("Auto choices", m_chooser);
		
		mode.addDefault("Default", kDefault);
		mode.addObject("Experimental", kExperimental);
		
		SmartDashboard.putData("Auto Modes", mode);
		
		
		controller1 = new Controller();
		controller2 = new Controller();
		input = new Input(controller1, controller2);
		movement = new Movement(input);
		lift = new Lift(input);
		auto = new Auto();
		grab = new Grab(input);
		
		
		
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		
		
		
		
		
		m_autoSelected = m_chooser.getSelected();
		// autoS elected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		
		autoMode = mode.getSelected();
		System.out.println("Auto mode: " + mode);
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		SmartDashboard.putString("Game Data", gameData);
		SmartDashboard.putString("Position", m_autoSelected);
		
		
    	player = null;
    	
    	
    	try 
    	{
    		 player = new AutoPlay();
		} 
    	
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
	switch (autoMode){
	
	case kDefault:

		auto.defaultAuto();
		
		switch (m_autoSelected) {
			
			case kRight:
				
				switch (gameData) {
				case "LLL":
					auto.R_LLL();
					break;
				case "LRL":
					auto.R_LRL();
					break;
				case "RLR":
					auto.R_RLR();
					break;
				case "RRR":
					auto.R_RRR();
					break;
				}
			break;
			
			case kMiddle:
				switch (gameData) {
				case "LLL":
					auto.M_LLL();
					break;
				case "LRL":
					auto.M_LRL();
					break;
				case "RLR":
					auto.M_RLR();
					break;
				case "RRR":
					auto.M_RRR();
					break;
				}
				break;
			
			case kLeft:
				switch (gameData) {
				case "LLL":
					auto.L_LLL();
					break;
				case "LRL":
					auto.L_LRL();
					break;
				case "RLR":
					auto.L_RLR();
					break;
				case "RRR":
					auto.L_RRR();
					break;
				}
				break;
				
			case kCross:
				auto.cross();
				break;
				
			
			}
		break;
	
	case kExperimental:
		
		if (player != null)
		{
			player.test(input);
			player.play(input);
		}
		
		if (recorder == null)
		{
			System.out.print("PLAYERISNULL");
		}
		
		
	}
			
		
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void teleopInit() {
		
		if(player != null)
		{
			player.end(input);
		}
		
		AutoRecord recorder = null;
        try {
			recorder = new AutoRecord();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
        
        try 
    	{
    		if(recorder != null)
    		{
    			recorder.end();
    		}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		
		
		controller1.update();
		controller2.update();
		movement.update();
		lift.update();
		grab.update();
		
		
		if (controller1.getButton("record"))
		{
			isRecording = !isRecording;
		}  

		if (isRecording)
		{
			try
			{
				
				if(recorder != null)
				{
					System.out.println(input.getLift1());
					recorder.record(input);
				}
			
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			
		}
		
		if (recorder == null)
		{
			System.out.print("RECORDERNULL!");
		}
		    	
		
    	
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	/**
	 * This function is called periodically during disabled mode.
	 */
	@Override
	public void disabledInit() {
		
		if(player!= null)
		{
			player.end(input);
		}
		
		
	
		
		
	}
}
