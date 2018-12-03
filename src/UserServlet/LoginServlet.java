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
 * �����û���¼���û����������Ƿ���ȷ
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=UTF-8");
		// ��ȡ������û���������
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		//�����û�������������У��
		User user = new User();
		user.setUsername(name);
		user.setPassword(pw);
		// ���ü����û�������ķ���
		int t = UserUtils.queryUser(name, pw);
		if(t==1)
		{
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("MessageServlet").forward(request, response);  // �û���������ȷ��ת����Ϣ��ҳ��
		}
		else
		{
			request.getRequestDispatcher("Fail.jsp").forward(request, response);	//  �û������벻��ȷ��ת��ʧ��ҳ��
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
