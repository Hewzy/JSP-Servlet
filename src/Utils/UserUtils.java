package Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import User.cn.Message;


public class UserUtils {
	// �����û����������ѯ�û�
	public static int queryUser(String username,String password) {
		try {
			password=MD5Utils.getMD5(password);
			String sql="select * from user where username=? and password=?";
			PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
			sta.setString(1, username);
			sta.setString(2, password);
			ResultSet rs=sta.executeQuery();
			if(rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}
	// �����û��� �ֻ��� �����û����ע��
	public static int RegisterUser(String name,String number,String pw) {
		String sql="INSERT INTO `user`.`user`(`username`, `number`, `password`) VALUES (?,?,?)";
		try {
			pw=MD5Utils.getMD5(pw);
			PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
			sta.setString(1, name);
			sta.setString(2, number);
			sta.setString(3, pw);
			return sta.executeUpdate();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}
	// �г�������Ϣ�������
	public  List<Message> findall() {
		List<Message> list=new ArrayList<Message>();
		try {
			String sql="SELECT * FROM `message`";
			PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
			ResultSet rs=sta.executeQuery();
			while(rs.next()) {					
				int id=rs.getInt(1);
				String title=rs.getString(2);
				String time=rs.getString(3);
				String content=rs.getString(4);
				
				Message message=new Message();
				
				message.setId(id);
				message.setTitle(title);
				message.setTime(time);
				message.setContent(content);
				
				list.add(message);
				System.out.println(list.size());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;	
	}
	// ����IDɾ����Ӧ��Ϣ�������
	public void deleteMessage(int id1) {
		    try {
				String sql = "delete from message where id = ?";  
				PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
				sta.setInt(1, id1);
				sta.executeUpdate();
				sta.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	// ����ID��ѯ��Ϣ��Ķ�Ӧ����
	public Message selectMessageById(int id) throws ClassNotFoundException, SQLException {
		
				String sql = "select * from message where id = "+id;
				Message message = new Message();
		    	PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
		    	ResultSet rs = sta.executeQuery();
	    	
		    	while (rs.next()) {
	               message.setId(rs.getInt("id"));
	               message.setTime(rs.getString("time"));
	               message.setTitle(rs.getString("title"));
	               message.setContent(rs.getString("content"));
	         }
			return message;
	}
	// ����û�������Ϣ �����ز���ֵ�Ƿ���ӳɹ�
	public boolean addMessage(Message mes) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO message(title,time,content) VALUES (?,?,?)";  
		 PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
		 System.out.println(mes.getTime()+"*****");
        try {
            
            sta.setString(1, mes.getTitle());
            sta.setString(2, mes.getTime());
            sta.setString(3, mes.getContent());
            int count = sta.executeUpdate();
            sta.close();
            return count>0?true:false;  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	// �����û���Ϣ�����ز���ֵ�Ƿ�༭�ɹ�
	public boolean editMessage(Message message) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE message SET title=?,time=?,content=? WHERE id = ?";  //�޸ĵ�SQL��䣬����ID�޸�
		PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
		 try{
			
			 sta.setString(1, message.getTitle());
			 sta.setString(2, message.getTime());
			 sta.setString(3, message.getContent());
			 sta.setInt(4, message.getId());
			 int count = sta.executeUpdate();
			 sta.close();  //�ر�
			 System.out.println("�޸ġ�������������");
			 return count>0?true:false;  //�Ƿ��޸ĵ��ж�
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	// ������ݿ����û����Ƿ����
	public static int checkName(String username) {
		// TODO Auto-generated method stub
		try {
			String sql="select * from user where username=?";
			PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
			sta.setString(1, username);
			ResultSet rs=sta.executeQuery();
			if(rs.next())
				{return 1;}
			else
				{return 0;}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	// ������ݿ��������Ƿ���ȷ
	public static int queryUser(String pw) {
		// TODO Auto-generated method stub
		try {
			pw=MD5Utils.getMD5(pw);
			String sql="select * from user where password=?";
			PreparedStatement sta=DButils.getConnection().prepareStatement(sql);
			sta.setString(1, pw);
			ResultSet rs=sta.executeQuery();
			if(rs.next())
				{return 1;}
			else
				{return 0;}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	}


