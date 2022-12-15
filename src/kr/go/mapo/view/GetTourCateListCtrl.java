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

@WebServlet({"/GetTourCateListCtrl.do"})
public class GetTourCateListCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String cate = request.getParameter("cate");
    TourDAO dao = new TourDAO();
    ArrayList<TourDTO> tourList = dao.getTourCateList(cate);
    request.setAttribute("list", tourList);
    request.setAttribute("placeCate", cate);
    RequestDispatcher view = request.getRequestDispatcher("./tour/tourCateList.jsp");
    view.forward((ServletRequest)request, (ServletResponse)response);
  }
}
