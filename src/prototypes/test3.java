package prototypes;

import java.util.List;

import com.aldebaran.proxy.Variant;

import com.aldebaran.proxy.ALMemoryProxy;
import com.aldebaran.proxy.ALMotionProxy;

public class test3 {
//	private static String NAOQI_IP = "192.168.110.230";
	private static String NAOQI_IP = "192.168.0.3";
	private static int NAOQI_PORT = 9559;

	// This is required so that we can use the 'Variant' object

	public static void main(String[] args) {
		Thread t = new Thread(); 
		ALMotionProxy motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
		ALMemoryProxy memory = new ALMemoryProxy(NAOQI_IP, NAOQI_PORT);
		// This lets you use bound methods that excpects ALValue from Java:
		//String[] nameList = new String[] {"RShoulderPitch","RElbowRoll",  "RWristYaw", "RShoulderRoll", "RElbowYaw"};
		Variant names  = new Variant(new String[] {"RShoulderPitch"});
		Variant angles = new Variant(new float[] {  0.75f});
		Variant times  = new Variant(new float[] {	2.0f,2.0f,2.0f,2.0f,2.0f,2.0f});
		//motion.openHand("RHand");
		
		motion.setStiffnesses(names, new Variant(new float[] {1.0f}));
		
		
		long startTime = System.nanoTime();
		motion.angleInterpolationWithSpeed(names, angles,0.2f);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		motion.changeAngles(names, angles,0.1f);
		names  = new Variant( new String[] {"RShoulderPitch"});
		angles = new Variant(new float[] {1.0f });

		//motion.angleInterpolation(names, angles,times, true);
		motion.setStiffnesses(names, new Variant(new float[] {0.0f}));
	
		//motion.setAngles(names, angles, 2f);
	}
}
