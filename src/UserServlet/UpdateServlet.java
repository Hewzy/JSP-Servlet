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
 * ������Ϣ������ݹ���
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
			// ��ȡ�����ID
		    String str = request.getParameter("id");
		    // �ж������id�Ƿ�Ϊ��
            if(str != null && !str.equals("")){
            	int id = Integer.parseInt(str);
            	UserUtils uu = new UserUtils();
            	Message message = new Message();
            	try {
				message = uu.selectMessageById(id);		// ����id��ѯ��Ϣ�������
				
//				System.out.println(message.getTitle());
				
            	} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(message.getId());
            request.setAttribute("mes",message);
        }
            
        request.getRequestDispatcher("Edit.jsp").forward(request, response); 
      
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}

