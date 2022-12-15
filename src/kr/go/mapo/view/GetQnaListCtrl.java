package kr.go.mapo.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.QnaDTO;
import kr.go.mapo.model.QnaDAO;

@WebServlet("/GetQnaListCtrl.do")
public class GetQnaListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		QnaDAO dao = new QnaDAO();
		ArrayList<QnaDTO> qnaList = dao.getQnaList();
		

		request.setAttribute("list", qnaList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/qnaList.jsp");
		view.forward(request, response);
	}
}

