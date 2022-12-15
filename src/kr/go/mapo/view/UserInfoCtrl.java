package kr.go.mapo.view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.go.mapo.dto.UserDTO;
import kr.go.mapo.model.UserDAO;

@WebServlet({"/UserInfoCtrl.do"})
public class UserInfoCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    String id = (String)session.getAttribute("sid");
    UserDAO dao = new UserDAO();
    UserDTO dto = dao.userInfo(id);
    request.setAttribute("dto", dto);
    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/userUpdate.jsp");
    view.forward((ServletRequest)request, (ServletResponse)response);
  }
}
