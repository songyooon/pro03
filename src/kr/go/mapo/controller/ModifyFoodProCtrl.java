package kr.go.mapo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.FoodDTO;
import kr.go.mapo.model.FoodDAO;

@WebServlet({"/ModifyFoodProCtrl.do"})
public class ModifyFoodProCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    String name = request.getParameter("name");
    String kind = request.getParameter("kind");
	String menu = request.getParameter("menu");
	String pos = request.getParameter("pos");
	String tel = request.getParameter("tel");
    FoodDTO dto = new FoodDTO();
    dto.setNo(no);
    dto.setName(name);
    dto.setKind(kind);
    dto.setMenu(menu);
    dto.setPos(pos);
    dto.setTel(tel);
    FoodDAO dao = new FoodDAO(); 
    int cnt = dao.modifyFood(dto);
    if (cnt >= 1) {
      response.sendRedirect("GetFoodListCtrl.do");
    } else {
      response.sendRedirect("ModifyFoodCtrl?no=" + no);
    } 
  }
}
