package cover_generator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

class Generator_back_end {
	private QuestsTable qt = new QuestsTable();

	
	
	public QuestsTable getQt() {
		return qt;
	}

	public void setQt(QuestsTable qt) {
		this.qt = qt;
	}




	public void generate_cover(Quest q) throws IOException{
			for (int i = 1; i < q.partNum +1; i++){
				String partNumberStr = ""+i;
				String classCode = q.getClassCode();
				
				// set srcImg
				File srcImgFile = new File(q.getImgPath());  
		        Image srcImg = ImageIO.read(srcImgFile);
		        
		        //set loction of Img
		        int x = (int) (830);  
		        int y = (int) (1370); 
		        
		        int partnum_x = (int) (1670);
		        int partnum_y = (int) (867);
		        
		        BufferedImage bufImg = new BufferedImage(Constant.WIDTH, Constant.HEIGHT, BufferedImage.TYPE_INT_RGB);  
		        Graphics2D g = bufImg.createGraphics();  
		        
		        g.drawImage(srcImg, 0, 0, Constant.WIDTH, Constant.HEIGHT, null); 
		        
		        if (q.QR){
		        	// draw QR code if QR.
		        	File qrImgFile = new File(Constant.QR_PATH);  
		            Image qrImg = ImageIO.read(qrImgFile);
		        	g.drawImage(qrImg, 0, 0, Constant.WIDTH, Constant.HEIGHT, null); 
		        }
		        // Draw classcode.
		        g.setColor(Color.BLACK);
		        g.setFont(Constant.FONT1);
		        g.drawString(classCode, x, y);  
		        // Draw partnum
		        g.setFont(Constant.FONT2);
		        g.drawString(partNumberStr, partnum_x, partnum_y);  
		        g.dispose(); 
		        
		        
		        // OutPut
		        FileOutputStream outImgStream = new FileOutputStream(getImgOutPath(i,q));  
		        ImageIO.write(bufImg, "png", outImgStream);  
		        outImgStream.flush();  
		        outImgStream.close();  
		        System.out.println("输出文件："+this.getImgOutPath(i,q));
			}
            
	}
	
	
	public void generate_wechat_cover(Quest q) throws IOException{
		for (int i = 1; i < q.partNum +1; i++){
			String partNumberStr = ""+i;
			String classCode = q.getClassCode();
			
			// set srcImg
			File srcImgFile = new File(q.getImgPath());  
	        Image srcImg = ImageIO.read(srcImgFile);
	        
	        //set loction of Img
	        int x = (int) (830);  
	        int y = (int) (1370); 
	        
	        int x2 = (int) (1670);
	        int y2 = (int) (867);
	        
	        BufferedImage bufImg = new BufferedImage(Constant.WIDTH, Constant.HEIGHT, BufferedImage.TYPE_INT_RGB);  
	        Graphics2D g = bufImg.createGraphics();  
	        
	        g.drawImage(srcImg, 0, 0, Constant.WIDTH, Constant.HEIGHT, null); 
	        if (q.QR){
	        	File qrImgFile = new File(Constant.QR_PATH);  
	            Image qrImg = ImageIO.read(qrImgFile);
	        	g.drawImage(qrImg, 0, 0, Constant.WIDTH, Constant.HEIGHT, null); 
	        }
	        g.setColor(Color.BLACK);
	        g.setFont(Constant.FONT1);
	        g.drawString(classCode, x, y);  
	        g.setFont(Constant.FONT2);
	        g.drawString(partNumberStr, x2, y2);  
	        g.dispose(); 
	        
	        
	        // OutPut
	        FileOutputStream outImgStream = new FileOutputStream(getImgOutPath(i,q));  
	        ImageIO.write(bufImg, "png", outImgStream);  
	        outImgStream.flush();  
	        outImgStream.close();  
	        System.out.println("输出文件："+this.getImgOutPath(i,q));
		}
        
}

	


	public String getImgOutPath(int part,Quest q) {
		return Constant.OUTPATH + q.getClassCode() + "_" + part+ "_"+q.QR + ".png";
	}

	public void reverseQR() {
		Constant.QR = !Constant.QR;
	}
	
	public void createAndAddQuest(){
		if(Constant.PART_NUM <10 & Constant.PART_NUM>0){
			Quest q = new Quest(this.qt.getQuestsList().size()+1,Constant.CLASSNAME, Constant.CLASS_NUM, Constant.PART_NUM, Constant.QR);
			this.qt.addQuest(q);
			System.out.println(q.getClassCode());
		}else{
			System.out.println("Wrong parts number.");
		}
	}
	
	public void startQuests(){
            System.out.println("开始任务：");
            for (Quest item:qt.getQuestsList()){
            	if (item.done == false){
                    try {
                            this.generate_cover(item);
                            this.qt.finishQuest(item);
                    } catch (IOException e) {
                            System.out.println("失败："+item.getClassCode());
                            e.printStackTrace();
                            this.qt.failQuest(item);
                    }
            	}
            }
	}

}
