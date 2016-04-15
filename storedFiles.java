import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class storedFiles {
	public static ArrayList<String> fileNames = new ArrayList<String>();
	public static ArrayList<String> filePaths = new ArrayList<String>();
	public static ArrayList<Long> fileStartLocations = new ArrayList<Long>();
	public static ArrayList<Long> fileEndLocations = new ArrayList<Long>();
	public static ArrayList<String> croppedFileNames = new ArrayList<String>();
	public static ArrayList<String> croppedFilePaths = new ArrayList<String>();
	public static ArrayList<Long> croppedFileStartLocations = new ArrayList<Long>();
	public static ArrayList<Long> croppedFileEndLocations = new ArrayList<Long>();
	
	public static void saveKit(String fileName) throws FileNotFoundException
	{
		PrintWriter TodoFile = new PrintWriter(new FileOutputStream(fileName));
		for(int i = 0; i < fileNames.size(); i++)
		{
			TodoFile.println("");
			TodoFile.println(fileNames.get(i));
			TodoFile.println(filePaths.get(i));
			TodoFile.println(fileStartLocations.get(i));
			TodoFile.println(fileEndLocations.get(i));
		}
		TodoFile.println("CHANGETOCROP");
		for(int i = 0; i < croppedFileNames.size(); i++)
		{
			TodoFile.println(croppedFileNames.get(i));
			TodoFile.println(croppedFilePaths.get(i));
			TodoFile.println(croppedFileStartLocations.get(i));
			TodoFile.println(croppedFileEndLocations.get(i));
		}
	    TodoFile.close();
	}
	
	public static void loadKit(String fileName) throws FileNotFoundException
	{
		Scanner loadFile = new Scanner(new File(fileName));
		fileNames.clear();
		filePaths.clear();
		fileStartLocations.clear();
		fileEndLocations.clear();
		croppedFileNames.clear();
		croppedFilePaths.clear();
		croppedFileStartLocations.clear();
		croppedFileEndLocations.clear();
		while(!loadFile.nextLine().equals("CHANGETOCROP"))
		{
			fileNames.add(loadFile.nextLine());
			filePaths.add(loadFile.nextLine());
			fileStartLocations.add(Long.parseLong(loadFile.nextLine()));
			fileEndLocations.add(Long.parseLong(loadFile.nextLine()));
		}
		while(loadFile.hasNext() == true)
		{
			croppedFileNames.add(loadFile.nextLine());
			croppedFilePaths.add(loadFile.nextLine());
			croppedFileStartLocations.add(Long.parseLong(loadFile.nextLine()));
			croppedFileEndLocations.add(Long.parseLong(loadFile.nextLine()));
		}
	}
	
}
