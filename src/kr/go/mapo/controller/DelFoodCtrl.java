package kr.go.mapo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.go.mapo.model.FoodDAO;

@WebServlet({"/DelFoodCtrl.do"})
public class DelFoodCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    FoodDAO dao = new FoodDAO();
    int cnt = dao.delFood(no);
    if (cnt >= 1) {
      response.sendRedirect("GetFoodListCtrl.do");
    } else {
      response.sendRedirect("GetFoodCtrl.do?no=" + no);
    } 
  }
}
