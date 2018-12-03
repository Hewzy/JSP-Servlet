package UserServlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * �����֤����������Ĺ���
 */
@WebServlet("/safecode")
public class SafeCodeServlet extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1626673439350527994L;
 
	public SafeCodeServlet() {
		super();
	}
 
	public void destroy() {
		super.destroy();
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	     //����������ͺ�����������滺��
		 response.setContentType("image/jpeg") ;
	     response.setHeader("Cache-Control", "no-cache") ;
	     
	     //����ͼƬ����
	     int width = 60,height = 20 ;
	     BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
	     
	     Graphics g = image.getGraphics() ;
	     
	     //���������
	     Random random = new Random() ;
	     String s = "" ;
	     for(int i=0;i<4;i++){
	    	 s += random.nextInt(10) ;
	     }
	     
	     //��������浽Session���棬���ڵ��±Ƚ�
	     HttpSession session = request.getSession() ;
	     session.setAttribute("code",s) ;
	     
	     //���������ɫ  Color color =  new Color(255,255,255) ;     random.nextInt(256)��ֵ��Χ��0~255
	     Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)) ;
	     
	     //�������д��ͼƬ��
	     String a = null ;
	     Font font = new Font(a,Font.ITALIC,18) ;
	     g.setColor(color) ;
	     g.setFont(font);
	     g.drawString(s,10,height-5) ;
	     g.dispose() ;    //�رջ���
	     
         //��ͼƬ�͵��ͻ���
	     ServletOutputStream output = response.getOutputStream() ;
	     ImageIO.write(image,"JPEG",output) ;
	     output.flush();   //�ر������
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         this.doGet(request,response) ;
	}
	
	public void init() throws ServletException {
	}
}