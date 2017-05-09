package prototypes;
/*
 * Make the robot move its head
 */

import com.aldebaran.proxy.ALMotionProxy;
import com.aldebaran.proxy.Variant;

import com.aldebaran.proxy.*;

public class test2 {
	private static String NAOQI_IP = "192.168.0.3";
	private static int NAOQI_PORT = 9559;

	// This is required so that we can use the 'Variant' object

	public static void main(String[] args) {
		ALMotionProxy motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
		// This lets you use bound methods that excpects ALValue from Java:
		Variant names  = new Variant(new String[] {"RHand" });
		motion.openHand("RHand");
		float[] f = motion.getAngles(names, true);
		System.out.printf("%f",f[0]);
		motion.closeHand("RHand");
		f = motion.getAngles(names, true);
		System.out.printf("%f",f[0]);
	}
}
