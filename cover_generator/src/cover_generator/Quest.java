package cover_generator;

import java.awt.Component;
import java.io.File;

public class Quest extends Component {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2272448721244743649L;
	int id;
	boolean QR ;
	boolean done = false;
	Integer partNum ;
	
	public boolean isQR() {
		return QR;
	}

	public void setQR(boolean qR) {
		QR = qR;
	}

	public Integer getPartNum() {
		return partNum;
	}

	public void setPartNum(Integer partNum) {
		this.partNum = partNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	String classNum ;
	String className;
	
	
	Quest(int id, String className,String classNum, int partNum, boolean qr){
		this.id = id;
		this.classNum = classNum;
		this.className = className;
		this.partNum  = partNum;
		this.QR = qr;
	}
	
	public String getClassCode() {
		return this.className + this.classNum;
	}

	public String getImgPath() {
		return "Img"+ File.separator +"Bg"+File.separator + this.className + ".png";
	}

}
