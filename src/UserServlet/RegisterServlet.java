package UserServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.UserUtils;

/**
 * 完成注册的功能 ， 检验用户名 是否存在等
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=UTF-8");
		// 获取输入的用户名手机号和密码
		String name = request.getParameter("username");
		String number = request.getParameter("number");
		String pw = request.getParameter("password");
		//获取输入的验证码
		String code = (String) request.getSession().getAttribute("code");
		String code2 = request.getParameter("safecode");
		// 判断用户名是否存在
		int result = UserUtils.queryUser(name, pw);		
		// 判断验证码是否正确
		if(!code.equals(code2))
		{
			System.out.println("验证码错误");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		// 用户名长度必须在2-5位
		else if(name.length()>5||name.length()<2) {
			System.out.println("用户名长度必须在2-5位");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
		else {
			// 用户名不存在
		if(result==0)
		{
			int t = UserUtils.RegisterUser(name, number,pw);
			// 判断有无成功注册 ，注册成功
			if(t==1)
				{
			System.out.println("注册成功");
			request.getRequestDispatcher("Success.jsp").forward(request, response);
				}
			// 注册失败
		else
		{
			System.out.println("注册失败");
			request.getRequestDispatcher("Fail.jsp").forward(request, response);
		}
	}
		// 用户名存在
		else {
			System.out.println("用户已经存在");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		}
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
