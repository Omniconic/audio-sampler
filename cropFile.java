import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

public class cropFile {
    public long startPlayback = 0;
    public long endPlayback = 0;
    
    public static void crop(audioFile file, int sliderLow, int sliderHigh) {
    	if((long)sliderLow != file.startPlayback || (long)sliderHigh != file.endPlayback) {
    		file.startPlayback = (long)sliderLow;
    		file.endPlayback = (long)sliderHigh;
    		file.playFile();
    		//System.out.println(file.startPlayback);
    		//System.out.println(file.endPlayback);
    	}
    }
    public static void displayWaveform(String filePath) throws UnsupportedAudioFileException, IOException {
	    String[] paths = {filePath, "waveform.png"};
		if (paths.length != 2) {
			//AudioWaveformCreator.printUsage();
	        System.exit(1);
	    }                
	    AudioWaveformCreator awc = new AudioWaveformCreator(paths[0], paths[1]);
	    try {
			awc.createAudioInputStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
