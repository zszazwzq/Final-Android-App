package prototypes;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Wave {
	//private static String NAOQI_IP = "192.168.1.65";
	//private static String NAOQI_IP = "192.168.0.3";
	//private static int NAOQI_PORT = 9559;
	private String[] names;
	//private  ALMotionProxy motion;
	//private  ALTextToSpeechProxy tts;
	private String addressIP;
	
	private class HelloThread extends Thread {

	    public void run() {
	    	HttpGet say = new HttpGet("http://"+ addressIP +":9559/?eval"
					+ "=ALTextToSpeech.say(%22hello%22)");
	    	sendRequest(say);
	    }

	   

	};
	public Wave(String NAOQI_IP){
		this.addressIP = NAOQI_IP;
		//this.names  = new String[] {};
		
		
	}
	public void wave(){
		//motion.setStiffnesses(names, new Variant(new float[] {1.0f,1.0f,1.0f,1.0f,1.0f,1.0f}));
		HttpGet setStiffnesses = new HttpGet("http://"+ addressIP +":9559/?eval"
					+ "=ALMotion.setStiffnesses(["
					+"%22RShoulderPitch%22,%22RElbowRoll%22,%22RWristYaw%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RHand%22"
					+"],[1.0,1.0,1.0,1.0,1.0,1.0])");
		sendRequest(setStiffnesses);
		rise();
		waveHand();
		down();
		//motion.setStiffnesses(names, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}));
		HttpGet removeStiffnesses = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.setStiffnesses(["
				+"%22RShoulderPitch%22,%22RElbowRoll%22,%22RWristYaw%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RHand%22"
				+"],[0.0,0.0,0.0,0.0,0.0,0.0])");
		sendRequest(removeStiffnesses);
		
	}
	private void rise(){
		
		//Variant angles = new Variant(new float[] { -0.5f, 1.5f, -0.75f, -0.5f, 1.25f,1.0f});	
		
		//motion.angleInterpolationWithSpeed(names, angles,0.2f);
		HttpGet rise = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolationWithSpeed(["
				+"%22RShoulderPitch%22,%22RElbowRoll%22,%22RWristYaw%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RHand%22"
				+"],[-0.5,1.5,-0.75,-0.5,1.25,1.0],0.2)");
		sendRequest(rise);


	}
	private void down(){
		
		//Variant angles = new Variant(new float[] {1.5f,1.0f,0.0f,-0.25f,1.0f,0.0f });
		//motion.angleInterpolationWithSpeed(names, angles,0.2f);
		HttpGet down = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolationWithSpeed(["
				+"%22RShoulderPitch%22,%22RElbowRoll%22,%22RWristYaw%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RHand%22"
				+"],[1.5,1.0,0.0,-0.25,1.0,0.0],0.2)");

		sendRequest(down);

		
	}
	private void waveHand(){
		(new HelloThread()).start();
		HttpGet wave = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolationWithSpeed(["
				+"%22RElbowRoll%22"
				+"],[1.25,0.5],0.2)");
		sendRequest(wave);
		//motion.angleInterpolationWithSpeed(new Variant(new String[] { "RElbowRoll"}), new Variant(new float[] {  1.25f,0.5f}),0.2f);
		
	}
	public static void main(String[] args) {
		
		Wave t = new Wave("192.168.0.3");
		t.wave();
	}
	private void sendRequest(HttpGet hg){
		try {
			HttpGet selectedAction;
    		//Creating an HTTP client
    		HttpClient httpClient = new DefaultHttpClient();
		
		
		selectedAction = hg;
		try {   
			/* A response is declared and executes each time the action(HttpGet) that
			 * equals the the selectedAction variable.
			 * Afterwards the response is converted to a string and can be used
			 * everywhere in the application is needed
			 */
			HttpResponse response = httpClient.execute(selectedAction);
			String responseBody = EntityUtils.toString(response.getEntity());
			System.out.println(responseBody);
			
				 
			} 
	
		catch (ClientProtocolException e) 
			{
			// writing exception to log
		    e.printStackTrace();								         
			}
	
		catch (IOException e) 
			{
				// writing exception to log
			    e.printStackTrace();
			}
 
	        }

	 	catch (Exception e) {}
		
	}
}