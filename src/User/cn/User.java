package User.cn;
//用户实例化类
public class User {
	private String username;
	private int number;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, int number, String password) {
		super();
		this.username = username;
		this.number = number;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", number=" + number + ", password=" + password + "]";
	}
	
}
