package prototypes;
import java.util.concurrent.TimeUnit;

import com.aldebaran.proxy.ALAudioPlayerProxy;
import com.jcraft.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

import com.aldebaran.proxy.*;

import java.io.File;
import java.io.IOException;
public class test7 {
	private ALAudioPlayerProxy alp =  new ALAudioPlayerProxy("	",9559);
	public void playMusic(){
		String a = "In_Camera_-_Nothing_s_Over.mp3";
		alp.playFile(a);
	}
	public static void main(String[] args) throws Exception {
		//ALAudioPlayerProxy ap =  new ALAudioPlayerProxy("192.168.0.3",9559);
		//ALAudioDeviceProxy ad = new ALAudioDeviceProxy("192.168.0.3",9559);
		//String a = "In_Camera_-_Nothing_s_Over.mp3";
		
	//	JSch jsch=new JSch();

	      //jsch.setKnownHosts("/home/foo/.ssh/known_hosts");

	   ///   String host="192.168.0.3";
	    //  System.out.println(host);
	     // Session session=jsch.getSession("nao", host, 22);

	    //  String passwd = "nao";
	   //   session.setPassword(passwd);
	   //   session.setConfig("StrictHostKeyChecking", "no");
	    //  
	    //  session.connect(30000);
	    ///  
	      // making a connection with timeout.
	    //  Channel channel=session.openChannel("exec");
	      

	      //String upload = "scp "+a+ " nao@"+host+":/var/persistent/home/nao/.local/share/naoqi/ In_Camera_-_Nothing_s_Over.mp3";
	      
	     // System.out.println(upload);
	      //((ChannelExec)channel).setCommand(upload);
	      //channel.connect();

	    //  ap.playFile("/var/persistent/home/nao/.local/share/naoqi/enemy_FlyingBuzzer_DestroyedExplosion.wav");
	      //channel.disconnect();
	     // Channel channel2=session.openChannel("Sftp");
	     // channel2.connect();
	     // ChannelSftp c=(ChannelSftp)channel2;
	      //c.sendSignal("rm -f /var/persistent/home/nao/.local/share/"+ a);
	     // c.rm(" -f /var/persistent/home/nao/.local/share/naoqi/enemy_FlyingBuzzer_DestroyedExplosion.wav");
	      
	      //channel2.disconnect();
	     // session.disconnect();

	      File file = new File("In_Camera_-_Nothing_s_Over.mp3");
	      System.out.println("Path : " + file.getAbsolutePath());
	      
	}

}
