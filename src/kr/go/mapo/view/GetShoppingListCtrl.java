package kr.go.mapo.view;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.go.mapo.dto.ShoppingDTO;
import kr.go.mapo.model.ShoppingDAO;

@WebServlet({"/GetShoppingListCtrl.do"})
public class GetShoppingListCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    ShoppingDAO dao = new ShoppingDAO();
    ArrayList<ShoppingDTO> shoppingList = dao.getShoppingList();
    request.setAttribute("list", shoppingList);
    RequestDispatcher view = request.getRequestDispatcher("./shopping/shoppingList.jsp");
    view.forward((ServletRequest)request, (ServletResponse)response);
  }
}
