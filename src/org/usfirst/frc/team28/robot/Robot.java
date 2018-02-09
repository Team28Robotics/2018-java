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
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	private String gameData = DriverStation.getInstance().getGameSpecificMessage();
	
	Movement movement;
	Controller controller1;
	Controller controller2;
	Lift lift;
	Auto auto;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Left", kLeft);
		m_chooser.addObject("Middle", kMiddle);
		m_chooser.addObject("Right", kRight);

		SmartDashboard.putData("Auto choices", m_chooser);
		
		controller1 = new Controller();
		controller2 = new Controller();
		movement = new Movement(controller1);
		lift = new Lift(controller2);
		auto = new Auto();
		
		
		
		
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
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		SmartDashboard.putString("Game Data", gameData);
		SmartDashboard.putString("Position", m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
		

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
	
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
