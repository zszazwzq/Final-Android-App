package prototypes;

import com.aldebaran.proxy.Variant;

import com.aldebaran.proxy.ALMotionProxy;
import com.aldebaran.proxy.ALTextToSpeechProxy;

//import prototypes.Prototype2;





	public class Prototype2 {
		//private static String NAOQI_IP = "192.168.1.65";
		//private static String NAOQI_IP = "192.168.0.3";
		//private static int NAOQI_PORT = 9559;
		private Variant names;
		private static ALMotionProxy motion;
		private  ALTextToSpeechProxy tts;
		private class HelloThread extends Thread {

		    public void run() {
		    	tts.say("hello");
		    }

		   

		};

		public Prototype2(String NAOQI_IP,int NAOQI_PORT){
			this.motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
			this.names  = new Variant(new String[] {"RShoulderPitch","RElbowRoll",  "RWristYaw", "RShoulderRoll", "RElbowYaw"});
			this.tts = new ALTextToSpeechProxy(NAOQI_IP, NAOQI_PORT);

		}
		public void wave(){
			
			motion.setStiffnesses(names, new Variant(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f}));
			
			rise();
			waveHand();
			
			down();
			motion.setStiffnesses(names, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f}));
			
		}
		private void rise(){
			
			Variant angles = new Variant(new float[] { -0.5f, 1.5f, -0.75f, -0.5f, 1.25f});	
			
			motion.setAngles(names, angles,0.2f);
			motion.openHand("RHand");
		}
		private void down(){
			
			Variant angles = new Variant(new float[] {1.5f,1.0f,0.0f,-0.25f,1.0f });
		
			motion.setAngles(names, angles,0.2f);
			motion.closeHand("RHand");
			motion.closeHand("RHand");
			
			
		}
		private void waveHand(){
			(new HelloThread()).start();

			motion.angleInterpolationWithSpeed(new Variant(new String[] { "RElbowRoll"}), new Variant(new float[] {  1.25f,0.5f}),0.2f);
		
			
		}
		public static void main(String[] args) {
			
			Prototype2 t = new Prototype2("192.168.0.3",9559);
			t.wave();
		}
	}

