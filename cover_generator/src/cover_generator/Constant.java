package cover_generator;


import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
class Constant {
	public static boolean QR = true;
	public static final String QR_PATH = "Img"+File.separator+"QR_code.png";
	static Integer PART_NUM = 1;
	static String CLASS_NUM = "100";
	static String CLASSNAME = "CSC";
	static String OUTPATH = "output"+File.separator;
 	static int HEIGHT = 3508;
	static int WIDTH = 2480;
	static Font FONT1 = new Font("等线 Light", Font.PLAIN, (int) 230);
	static Font FONT2 = new Font("华文中宋 Regular", Font.PLAIN, (int) 180);
	
	static ArrayList<String> COURSELIST= new ArrayList<String>();
	
	static{
		File root = new File("Img"+File.separator+"Bg");
		for (File f:root.listFiles()){
			COURSELIST.add(f.getName().substring(0, 3));
		}
	}
}


	