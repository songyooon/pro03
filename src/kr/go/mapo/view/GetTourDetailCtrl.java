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
import kr.go.mapo.dto.PicDTO;
import kr.go.mapo.dto.TourDTO;
import kr.go.mapo.model.TourDAO;

@WebServlet({"/GetTourDetailCtrl.do"})
public class GetTourDetailCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    TourDAO dao = new TourDAO();
    TourDTO dto = dao.getTour(no);
    ArrayList<PicDTO> picList = dao.JSONPicList(dto.getTourno());
    request.setAttribute("dto", dto);
    request.setAttribute("list", picList);
    RequestDispatcher view = request.getRequestDispatcher("./tour/tourDetail.jsp");
    view.forward((ServletRequest)request, (ServletResponse)response);
  }
}
