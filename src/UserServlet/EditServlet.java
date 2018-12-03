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
 * �༭��Ϣ�����û���Ϣ
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
				//��ȡ��Ϣ���е��û�id������
				String Str = request.getParameter("id");
				String title = request.getParameter("title");
				String time = request.getParameter("time");
				String content = request.getParameter("content");
				// ������Ϣ��
				Message message = new Message();
				int id = Integer.parseInt(Str);
				message.setId(id);
				message.setTitle(title);
				message.setTime(time);
				message.setContent(content);
				// ���ñ༭�ķ���
				UserUtils uu = new UserUtils();
				try {
				uu.editMessage(message);
				
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
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
