package kr.go.mapo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.go.mapo.dto.QnaDTO;
import kr.go.mapo.model.QnaDAO;

@WebServlet({"/ModifyQnaProCtrl.do"})
public class ModifyQnaProCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    QnaDTO dto = new QnaDTO();
    dto.setNo(no);
    dto.setTitle(title);
    dto.setContent(content);
    QnaDAO dao = new QnaDAO(); 
    int cnt = dao.modifyQna(dto);
    if (cnt >= 1) {
      response.sendRedirect("GetQnaListCtrl.do");
    } else {
      response.sendRedirect("ModifyQnaCtrl?no=" + no);
    } 
  }
}
