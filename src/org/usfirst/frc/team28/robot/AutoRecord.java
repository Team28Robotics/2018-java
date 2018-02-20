package org.usfirst.frc.team28.robot;

import java.io.FileWriter;
import java.io.IOException;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;

public class AutoRecord {

		FileWriter writer;
		
		long startTime;
		
		public AutoRecord() throws IOException
		{

				startTime = System.currentTimeMillis();
				
				writer = new FileWriter(Robot.autoFile);
		}
		

		public void record(Movement move, Lift lift, Grab grab) throws IOException
		{
			if(writer != null)
			{
				
			writer.append("" + (System.currentTimeMillis()-startTime));
			
			writer.append("," + move.getFrontLeft());
			writer.append("," + move.getFrontRight());
			writer.append("," + move.getBackLeft());
			writer.append("," + move.getBackRight());
			
			writer.append("," + lift.getLift1());
			writer.append("," + lift.getLift2());

			writer.append("," + grab.getIntake());
			
			
			
			/*
			 * THE LAST ENTRY OF THINGS YOU RECORD NEEDS TO HAVE A DELIMITER CONCATENATED TO 
			 * THE STRING AT THE END. OTHERWISE GIVES NOSUCHELEMENTEXCEPTION
			 */ 
			
			writer.append("," + grab.getClaw() + "\n");
			
			/*
			 * CAREFUL. KEEP THE LAST THING YOU RECORD BETWEEN THESE TWO COMMENTS AS A
			 * REMINDER TO APPEND THE DELIMITER
			 */
			}
		}
		
		
		public void end() throws IOException
		{
			if(writer !=null)
			{
			writer.flush();
			writer.close();
			}
		}
	
	
}
