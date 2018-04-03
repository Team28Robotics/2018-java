package org.usfirst.frc.team28.robot;

public class Util {

	public Util()
	{
		
	}
	
	public static double coerce2Range(double input, double min, double max){
        double inputMin, inputMax, inputCenter;
        double outputMin, outputMax, outputCenter;
        double scale, result;
        double out;
        
        inputMin = min; 
        inputMax = max;
        
        outputMin = -1;
        outputMax = 1;
        
            inputCenter = Math.abs(inputMax - inputMin) / 2 + inputMin;
            outputCenter = Math.abs(outputMax - outputMin) / 2 + outputMin;

            scale = (outputMax - outputMin) / (inputMax - inputMin);
            result = (input + -inputCenter) * scale + outputCenter;
            out = Math.max(Math.min(result, outputMax), outputMin);

       return out;
    }
	
}
