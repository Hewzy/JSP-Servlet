package CheckServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.cn.User;
import Utils.UserUtils;

/**
 * 检查用户名的密码是否正确，弹窗的形式警告
 */
@WebServlet("/CheckPasswordServlet")
public class CheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html,charset=UTF-8");
		//获取密码
		String pw = request.getParameter("password");
		User user = new User();
		user.setPassword(pw);
		
		int t = UserUtils.queryUser(pw);
		if(t==1)
		{
			response.getWriter().println(1);
		}
		else
		{
			response.getWriter().println(0);
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
