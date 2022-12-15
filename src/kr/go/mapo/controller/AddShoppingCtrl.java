package kr.go.mapo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.ShoppingDTO;
import kr.go.mapo.model.ShoppingDAO;

@WebServlet("/AddShoppingCtrl.do")
public class AddShoppingCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cate = request.getParameter("cate");
		String shopno = request.getParameter("shopno");
		String place = request.getParameter("place");
		String comment1 = request.getParameter("comment1");
		String comment2 = request.getParameter("comment2");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String addr = address1 + address2;
		
		ShoppingDTO dto = new ShoppingDTO();
		dto.setCate(cate);
		dto.setShopno(shopno);
		dto.setPlace(place);
		dto.setComment1(comment1);
		dto.setComment2(comment2);
		dto.setAddr(addr);
		
		ShoppingDAO dao = new ShoppingDAO();
		int cnt = dao.addShopping(dto);
		
		if(cnt>=1){
			response.sendRedirect("GetShoppingListCtrl.do");
		} else {
			response.sendRedirect("./tour/addShopping.jsp");
		}
	}
}