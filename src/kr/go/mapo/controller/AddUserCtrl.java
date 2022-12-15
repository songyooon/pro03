package kr.go.mapo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.UserDTO;
import kr.go.mapo.model.UserDAO;
import kr.go.mapo.service.AES256;



@WebServlet({"/AddUserCtrl.do"})
public class AddUserCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  private static String DRIVER = "org.mariadb.jdbc.Driver";
  private static String URL = "jdbc:mariadb://127.0.0.1:3308/government?serverTimezone=Asia/Seoul";
  private static String USER = "root";
  private static String PW = "1234";
  
  String sql = "";
  
  int cnt = 0;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String address1 = request.getParameter("address1");
    String address2 = request.getParameter("address2");
    String email = request.getParameter("email");
    String tel = request.getParameter("tel");
    String birth = request.getParameter("birth");
    boolean result=false;
    System.out.println("입력된 아이디:"+id);
    int cnt=0, suc=0;
    UserDAO dao = new UserDAO();
    UserDTO user = new UserDTO();
    String key = "%02x";
    String encrypted ="";
    
    try {
    	encrypted = AES256.encryptAES256(pw,key);
    	System.out.println("비밀번호 암호화:"+encrypted);
    } catch (Exception e) {
    	
      e.printStackTrace();
    } 
    
    if(cnt>=1){
    	result=false;
    	response.sendRedirect("./user/signUp.jsp?qid="+id);
    	
    } else{
    	result=true;
    	
    	user.setId(id);
    	user.setPw(encrypted);
    	user.setName(name);
    	user.setAddr(String.valueOf(address1)+"<br>"+address2);
    	user.setTel(tel);
    	user.setEmail(email);
    	user.setBirth(birth);
    	suc = dao.addUser(user);
    	if (suc>=1){
    		response.sendRedirect(request.getContextPath());
    	} else {
    		response.sendRedirect("./user/signUp.jsp?qid="+id);
    	}
    }
  }
}
