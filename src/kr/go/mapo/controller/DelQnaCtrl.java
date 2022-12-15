package kr.go.mapo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.model.QnaDAO;
import kr.go.mapo.model.QnaDAO;

@WebServlet({"/DelQnaCtrl.do"})
public class DelQnaCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    QnaDAO dao = new QnaDAO();
    int cnt = dao.delQna(no);
    if (cnt >= 1) {
      response.sendRedirect("GetQnaListCtrl.do");
    } else {
      response.sendRedirect("GetQnaCtrl.do?no=" + no);
    } 
  }
}
