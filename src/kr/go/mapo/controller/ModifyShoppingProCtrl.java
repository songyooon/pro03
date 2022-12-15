package kr.go.mapo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.mapo.dto.ShoppingDTO;
import kr.go.mapo.model.ShoppingDAO;

@WebServlet("/ModifyShoppingProCtrl.do")
public class ModifyShoppingProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String cate = request.getParameter("cate");
		String shopno = request.getParameter("shopno");
		String place = request.getParameter("place");
		String comment1 = request.getParameter("comment1");
		String comment2 = request.getParameter("comment2");
		
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String addr = "";
		
		if(address1!=""){
			addr = address1 + address2;
		} else {
			addr = request.getParameter("addr");
		}
		
		ShoppingDTO dto = new ShoppingDTO();
		dto.setNo(no);
		dto.setCate(cate);
		dto.setShopno(shopno);
		dto.setPlace(place);
		dto.setComment1(comment1);
		dto.setComment2(comment2);
		dto.setAddr(addr);
		
		ShoppingDAO dao = new ShoppingDAO();
		int cnt = dao.modifyShopping(dto);
		
		if(cnt>=1){
			response.sendRedirect("GetShoppingListCtrl.do");
		} else {
			response.sendRedirect("ModifyShoppingCtal.do?no="+no);
		}
	}
}