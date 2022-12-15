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
import kr.go.mapo.dto.TourDTO;
import kr.go.mapo.model.TourDAO;

@WebServlet({"/GetTourListCtrl.do"})
public class GetTourListCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    TourDAO dao = new TourDAO();
    ArrayList<TourDTO> tourList = dao.getTourList();
    request.setAttribute("list", tourList);
    RequestDispatcher view = request.getRequestDispatcher("./tour/tourList.jsp");
    view.forward((ServletRequest)request, (ServletResponse)response);
  }
}
