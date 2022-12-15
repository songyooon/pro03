package kr.go.mapo.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.FoodDTO;
import kr.go.mapo.model.FoodDAO;

@WebServlet("/GetFoodListCtrl.do")
public class GetFoodListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		FoodDAO dao = new FoodDAO();
		ArrayList<FoodDTO> foodList = dao.getFoodList();
		

		request.setAttribute("list", foodList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/food/foodList.jsp");
		view.forward(request, response);
	}
}

