package UserServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.cn.User;
import Utils.UserUtils;

/**
 * 检验用户登录，用户名和密码是否正确
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=UTF-8");
		// 获取输入的用户名和密码
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		//设置用户名和密码用于校验
		User user = new User();
		user.setUsername(name);
		user.setPassword(pw);
		// 调用检验用户名密码的方法
		int t = UserUtils.queryUser(name, pw);
		if(t==1)
		{
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("MessageServlet").forward(request, response);  // 用户名密码正确跳转到消息体页面
		}
		else
		{
			request.getRequestDispatcher("Fail.jsp").forward(request, response);	//  用户名密码不正确跳转到失败页面
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
