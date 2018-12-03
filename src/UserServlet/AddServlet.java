package UserServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.cn.Message;
import Utils.UserUtils;

/**
 * 增加消息体中的内容
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html,charset=UTF-8");	
			//获取输入的标题，时间，内容
			String title = request.getParameter("title");
	        String time = request.getParameter("time");
	        String content =request.getParameter("content");
	        
	        Message message = new Message();
	        message.setTitle(title);  
	        message.setTime(time);
	        message.setContent(content);
	        
	        try {
	        	UserUtils uu = new UserUtils();			// 创建工具类
				uu.addMessage(message);					// 调用增加的方法
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.getRequestDispatcher("MessageServlet").forward(request, response);
	    }    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
