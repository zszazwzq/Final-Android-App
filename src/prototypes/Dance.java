/**
 * 
 */
package prototypes;
import java.io.InputStream;
import java.io.File;

//import com.aldebaran.proxy.ALMotionProxy;
//import com.aldebaran.proxy.Variant;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.naoworld.R;



//import com.aldebaran.proxy.*;

/**
 * @author 31357_000
 *
 */
public class Dance {
	//private Variant lArm;
	//private Variant rArm;
	//private Variant arms;
	//private static ALMotionProxy motion;
	private String addressIP;
	private String target;
	private String input;
	private String musicFile;
	private class music extends Thread {

	    public void run() {
	    	HttpGet mplay = new HttpGet("http://"+ addressIP +":9559/?eval"
					+ "=ALAudioPlayer.playFile(%22"+musicFile+"%22)");
	    	sendRequest(mplay);
	    	
	    }

	   

	};
	public Dance(String NAOQI_IP){
		//this.motion = new ALMotionProxy(NAOQI_IP, NAOQI_PORT);
		this.addressIP = NAOQI_IP;
		//ALRobotPoseProxy rp = new ALRobotPoseProxy(NAOQI_IP, NAOQI_PORT);
		//this.rArm = new Variant(new String[] {"RShoulderPitch", "RShoulderRoll", "RElbowYaw", "RElbowRoll",  "RWristYaw",  "RHand"});
		//this.lArm = new Variant(new String[] {"LShoulderPitch", "LShoulderRoll", "LElbowYaw", "LElbowRoll",   "LWristYaw","LHand"});
		//this.arms = new Variant(new String[] {"RShoulderPitch", "RShoulderRoll", "RElbowYaw", "RElbowRoll",  "RWristYaw",  "RHand","LShoulderPitch", "LShoulderRoll", "LElbowYaw", "LElbowRoll",   "LWristYaw","LHand"});
		
	   

		//File file = new File(input);
		this.musicFile = "/var/persistent/home/nao/.local/share/naoqi/music.mp3";
		
	}
	
	public void dance(){
		(new music()).start();
		HttpGet setStiffnesses = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.setStiffnesses(["
				+"%22RShoulderPitch%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RElbowRoll%22,%22RWristYaw%22,%22RHand%22,%22LShoulderPitch%22,%22LShoulderRoll%22,%22LElbowYaw%22,%22LElbowRoll%22,%22LWristYaw%22,%22LHand%22"
				+"],[1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0])");
		sendRequest(setStiffnesses);
		
		start();
		
			pos1();
			pos2();
			pos1();
			pos3();
			pos4();
			pos3();
		
		start();
		//motion.setStiffnesses(rArm, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}));
		//motion.setStiffnesses(lArm, new Variant(new float[] {0.0f,0.0f,0.0f,0.0f,0.0f,0.0f}));
		HttpGet removeStiffnesses = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.setStiffnesses(["
				+"%22RShoulderPitch%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RElbowRoll%22,%22RWristYaw%22,%22RHand%22,%22LShoulderPitch%22,%22LShoulderRoll%22,%22LElbowYaw%22,%22LElbowRoll%22,%22LWristYaw%22,%22LHand%22"
				+"],[0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0])");
		sendRequest(removeStiffnesses);
	}
	private void start(){
		//motion.angleInterpolation(arms, new Variant(new float[] {  1.5f,-0.25f,0.0f,1.4f,1.4f,0.0f ,
		//		1.5f,0.25f,0.0f,-1.4f,-1.4f,0.0f }),new Variant(new float[] {1f,1f,1f,1f,1f,2f,1f,1f,1f,1f,1f,2f}),true);
		HttpGet start = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolation(["
				+"%22RShoulderPitch%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RElbowRoll%22,%22RWristYaw%22,%22RHand%22,%22LShoulderPitch%22,%22LShoulderRoll%22,%22LElbowYaw%22,%22LElbowRoll%22,%22LWristYaw%22,%22LHand%22"
				+"],[1.5,-0.25,0.0,1.4,1.4,0.0,1.5,0.25,0.0,-1.4,-1.4,0.0],"
				+ "[2,2,2,2,2,2,2,2,2,2,2,2],true])");
		sendRequest(start);
	}
	private void pos1(){
		//motion.angleInterpolation(arms, new Variant(new float[] {  -0.71f, -0.4f, 0.76f, 1.5f, 0.0f,  0.0f, 
		//		-0.73f, 0.0f, -0.59f, -0.57f, -0.38f, 1.0f}),new Variant(new float[] {1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f}),true);
		//motion.angleInterpolation(lArm, new Variant(new float[] {  -0.38f, -0.31f,-0.59f,-0.57f, -0.38f,1.0f}),new Variant(new float[] {  1f,1f,1f,1f,1f,1f}),true);
		HttpGet pos1 = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolation(["
				+"%22RShoulderPitch%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RElbowRoll%22,%22RWristYaw%22,%22RHand%22,%22LShoulderPitch%22,%22LShoulderRoll%22,%22LElbowYaw%22,%22LElbowRoll%22,%22LWristYaw%22,%22LHand%22"
				+"],[-0.71,-0.4,0.76,1.5,0.0,0.0,-0.73,0.0,-0.59,-0.57,-0.38,1.0],"
				+ "[1,1,1,1,1,1,1,1,1,1,1,1],true])");
		sendRequest(pos1);
	}
	private void pos2(){
		//motion.angleInterpolation(lArm, new Variant(new float[] {  -0.73f, 0.92f, 0.0f, 0.80f, -0.5f, 1.0f}),new Variant(new float[] {  1f,1f,1f,1f,1f,1f}),true);
		HttpGet pos2= new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolation(["
				+"%22LShoulderPitch%22,%22LShoulderRoll%22,%22LElbowYaw%22,%22LElbowRoll%22,%22LWristYaw%22,%22LHand%22"
				+"],[-0.73,0.92,0.0,0.80,-0.5,1.0],"
				+ "[1,1,1,1,1,1],true)");
		sendRequest(pos2);
	}
	private void pos3(){
		//motion.angleInterpolation(arms, new Variant(new float[] {  -0.73f, 0.0f, -0.59f, -0.57f, 0.38f, 1.0f, 
		//		-0.71f, -0.4f, -0.76f, -1.5f, 0.0f,  0.0f }),new Variant(new float[] {  1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f}),true);
		HttpGet pos3 = new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolation(["
				+"%22RShoulderPitch%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RElbowRoll%22,%22RWristYaw%22,%22RHand%22,%22LShoulderPitch%22,%22LShoulderRoll%22,%22LElbowYaw%22,%22LElbowRoll%22,%22LWristYaw%22,%22LHand%22"
				+"],[-0.73,0.0,-0.59,-0.57,0.38,1.0,-0.71,-0.4,-0.76,-1.5,0.0,0.0],"
				+ "[1,1,1,1,1,1,1,1,1,1,1,1],true)");
		sendRequest(pos3);
	}
	private void pos4(){
		//motion.angleInterpolation(rArm, new Variant(new float[] {  -0.73f, -0.92f, 0.0f, -0.80f, -0.5f, 1.0f}),new Variant(new float[] {  1f,1f,1f,1f,1f,1f}),true);
		HttpGet pos4= new HttpGet("http://"+ addressIP +":9559/?eval"
				+ "=ALMotion.angleInterpolation(["
				+"%22RShoulderPitch%22,%22RShoulderRoll%22,%22RElbowYaw%22,%22RElbowRoll%22,%22RWristYaw%22,%22RHand%22"
				+"],[-0.73,-0.92,0.0,-0.80,-0.5,1.0],"
				+ "[1,1,1,1,1,1],true)");
		sendRequest(pos4);
	}	
	public static void main(String[] args) {
		
		//Dance t = new Dance("192.168.0.3");

		//t.dance();
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
