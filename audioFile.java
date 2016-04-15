import java.io.*;
import javax.sound.sampled.*;
import javax.swing.Timer;

public class audioFile {
    public String fileName = null;
    public String filePath = null;
    public Clip clip;
    public boolean clipRunning = false;
    public long startPlayback = 0;
    public long endPlayback = 0;
    public char keyTrigger = '\0';
    
    audioFile() {
    }
    
    audioFile(String name, String path, long start, long end) {
    	fileName = name;
    	filePath = path;
    	startPlayback = start;
    	endPlayback = end;
    }
    
    public void updateAudioFile(String name, String path, long start, long end) {
    	fileName = name;
    	filePath = path;
    	startPlayback = start;
    	endPlayback = end;
    }
    
	public void playFile() {
		if(clipRunning) {
			clip.stop();
		}
		if(filePath != null) {
			try {
				AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
				clip = AudioSystem.getClip();
				if(!clip.isOpen()) {
					clip.open(stream);
					if(endPlayback == 0) {
						endPlayback = clip.getMicrosecondLength();
					}
				}
				clip.setMicrosecondPosition(startPlayback);		
				clip.start();
				clipRunning = true;						
			}
			catch (Exception e) {
		        System.out.println("Error with playing sound.");
		        e.printStackTrace();
			}
		}
	}
	
	public int getFileLength(String filePath) {
		long fileLength;
		if(filePath != null) {
			try {
				AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
				clip = AudioSystem.getClip();
				if(!clip.isOpen()) {
					clip.open(stream);
				}
				return (int)clip.getMicrosecondLength();
			}
			catch (Exception e) {
		        System.out.println("Error with playing sound.");
		        e.printStackTrace();
			}
		}
		return (int)endPlayback;
	}
	
	public void stopFile() {
		if (clip.getMicrosecondPosition() >= endPlayback) {
			clip.stop();
			clipRunning = false;
			
		}
	}	
}
