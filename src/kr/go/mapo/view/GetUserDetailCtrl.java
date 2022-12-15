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
import kr.go.mapo.dto.UserDTO;
import kr.go.mapo.model.UserDAO;

@WebServlet({"/GetUserDetailCtrl.do"})
public class GetUserDetailCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String id = request.getParameter("id");
    UserDAO dao = new UserDAO();
    UserDTO dto = dao.userInfo(id);
    request.setAttribute("dto", dto);
    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/user/userDetail.jsp");
    view.forward((ServletRequest)request, (ServletResponse)response);
  }
}
