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
		

		public void record(Input input) throws IOException
		{
			if(writer != null)
			{
				
			writer.append("" + (System.currentTimeMillis()-startTime));
			
			writer.append("," + input.getFrontLeft());
			writer.append("," + input.getFrontRight());
			writer.append("," + input.getBackLeft());
			writer.append("," + input.getBackRight());
			
			writer.append("," + input.getLift1());
			writer.append("," + input.getLift2());

			writer.append("," + input.getIntake());
			
			
			
			/*
			 * THE LAST ENTRY OF THINGS YOU RECORD NEEDS TO HAVE A DELIMITER CONCATENATED TO 
			 * THE STRING AT THE END. OTHERWISE GIVES NOSUCHELEMENTEXCEPTION
			 */ 
			
			writer.append("," + input.getClaw() + "\n");
			
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
