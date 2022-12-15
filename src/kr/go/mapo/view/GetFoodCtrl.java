package kr.go.mapo.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.FoodDTO;
import kr.go.mapo.model.FoodDAO;

@WebServlet("/GetFoodCtrl.do")
public class GetFoodCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		FoodDAO dao = new FoodDAO();
		FoodDTO dto = dao.getFood(no);
		

		request.setAttribute("dto", dto);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/food/foodDetail.jsp");
		view.forward(request, response);
	}
}
