package kr.go.mapo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.mapo.dto.PicDTO;
import kr.go.mapo.dto.ShoppingDTO;

public class ShoppingDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int loadLastNo(){	//중복 아이디 체크 / 회원가입시 가입전 체크
		int no = 0;
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.LOAD_LAST_NO);
			rs = pstmt.executeQuery();
			if(rs.next()){ 
				no = rs.getInt("no") + 1;	
			} else { 
				no = 1;	
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return no;
	}
	
	public int fileUpload(PicDTO dto){
		int cnt = 0;
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.FILE_UPLOAD);
			pstmt.setString(1, dto.getShopno());
			pstmt.setString(2, dto.getPicname());
			pstmt.setInt(3, dto.getPos());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}

	public ArrayList<PicDTO> JSONPicList(String shopno) {
		ArrayList<PicDTO> picList = new ArrayList<PicDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.JSON_PICLIST);
			pstmt.setString(1, shopno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PicDTO pic = new PicDTO();
				pic.setNo(rs.getInt("no"));
				pic.setShopno(rs.getString("shopno"));
				pic.setPicname(rs.getString("picname"));
				pic.setPos(rs.getInt("pos"));
				picList.add(pic);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return picList;
	}

	public int addShopping(ShoppingDTO dto) {
		int cnt = 0;
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.ADD_SHOPPING);
			pstmt.setString(1, dto.getShopno());
			pstmt.setString(2, dto.getCate());
			pstmt.setString(3, dto.getPlace());
			pstmt.setString(4, dto.getComment1());
			pstmt.setString(5, dto.getComment2());
			pstmt.setString(6, dto.getAddr());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}

	public ArrayList<ShoppingDTO> getShoppingList() {
		ArrayList<ShoppingDTO> shoppingList = new ArrayList<ShoppingDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_LIST_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ShoppingDTO shopping = new ShoppingDTO();
				shopping.setNo(rs.getInt("no"));
				shopping.setShopno(rs.getString("shopno"));
				shopping.setCate(rs.getString("cate"));
				shopping.setPlace(rs.getString("place"));
				shopping.setComment1(rs.getString("comment1"));
				shopping.setComment2(rs.getString("comment2"));
				shoppingList.add(shopping);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return shoppingList;
	}

	public ShoppingDTO getShopping(int no) {
		ShoppingDTO shopping = new ShoppingDTO();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_LIST_DETAIL);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				shopping.setNo(rs.getInt("no"));
				shopping.setShopno(rs.getString("shopno"));
				shopping.setCate(rs.getString("cate"));
				shopping.setPlace(rs.getString("place"));
				shopping.setComment1(rs.getString("comment1"));
				shopping.setComment2(rs.getString("comment2"));
				shopping.setAddr(rs.getString("addr"));
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return shopping;
	}

	public int delShopping(int no) {
		int cnt = 0;
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_DEL);
			pstmt.setInt(1, no);
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}

	public int modifyShopping(ShoppingDTO dto) {
		int cnt = 0;
		try {
			con = Maria.getConnection();
			//shopno=?, cate=?, place=?, comment1=?, comment2=? where no=?
			pstmt = con.prepareStatement(Maria.MODIFY_SHOPPING);
			pstmt.setString(1, dto.getShopno());
			pstmt.setString(2, dto.getCate());
			pstmt.setString(3, dto.getPlace());
			pstmt.setString(4, dto.getComment1());
			pstmt.setString(5, dto.getComment2());
			pstmt.setString(6, dto.getAddr());
			pstmt.setInt(7, dto.getNo());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}

	public ArrayList<ShoppingDTO> JSONPlaceList() {
		ArrayList<ShoppingDTO> shoppingList = new ArrayList<ShoppingDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_LIST_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ShoppingDTO shopping = new ShoppingDTO();
				shopping.setNo(rs.getInt("no"));
				shopping.setShopno(rs.getString("shopno"));
				shopping.setCate(rs.getString("cate"));
				shopping.setPlace(rs.getString("place"));
				shoppingList.add(shopping);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return shoppingList;
	}

	public ArrayList<ShoppingDTO> getShoppingCateList(String cate) {
		ArrayList<ShoppingDTO> shoppingList = new ArrayList<ShoppingDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_CATE_LIST);
			pstmt.setString(1, cate); 
			rs = pstmt.executeQuery();
			while(rs.next()){
				ShoppingDTO shopping = new ShoppingDTO();
				shopping.setNo(rs.getInt("no"));
				shopping.setShopno(rs.getString("shopno"));
				shopping.setCate(rs.getString("cate"));
				shopping.setPlace(rs.getString("place"));
				shopping.setImgURL(rs.getString("picname"));
				shopping.setComment1(rs.getString("comment1"));
				shopping.setComment2(rs.getString("comment2"));
				shoppingList.add(shopping);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		} catch(Exception e){
			System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return shoppingList;
	}

	public ArrayList<ShoppingDTO> getShoppingSerachList(String keyword) {
		ArrayList<ShoppingDTO> shoppingList = new ArrayList<ShoppingDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_SEARCH_PLACE_LIST);
			//pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ShoppingDTO shopping = new ShoppingDTO();
				shopping.setNo(rs.getInt("no"));
				shopping.setShopno(rs.getString("shopno"));
				shopping.setCate(rs.getString("cate"));
				shopping.setPlace(rs.getString("place"));
				shopping.setComment1(rs.getString("comment1"));
				shopping.setComment2(rs.getString("comment2"));
				shoppingList.add(shopping);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return shoppingList;
	}

	public ArrayList<ShoppingDTO> getTourSerachList(String comment2, String keyword) {
		ArrayList<ShoppingDTO> shoppingList = new ArrayList<ShoppingDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.SHOPPING_SEARCH_COMMENT_LIST);
			pstmt.setString(1, "%"+keyword+"%"); 
			rs = pstmt.executeQuery();
			while(rs.next()){
				ShoppingDTO shopping = new ShoppingDTO();
				shopping.setNo(rs.getInt("no"));
				shopping.setShopno(rs.getString("shopno"));
				shopping.setCate(rs.getString("cate"));
				shopping.setPlace(rs.getString("place"));
				shopping.setComment1(rs.getString("comment1"));
				shopping.setComment2(rs.getString("comment2"));
				shoppingList.add(shopping);
			}
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL 구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return shoppingList;
	}

	public ArrayList<ShoppingDTO> getShoppingSerachList(String place, String comment2, String keyword){
			ArrayList<ShoppingDTO> shoppingList = new ArrayList<ShoppingDTO>();
			try {
				con = Maria.getConnection();
				pstmt = con.prepareStatement(Maria.SHOPPING_SEARCH_ALL_LIST);
				pstmt.setString(1, "%"+keyword+"%"); 
				pstmt.setString(2, "%"+keyword+"%");
				rs = pstmt.executeQuery();
				while(rs.next()){
					ShoppingDTO shopping = new ShoppingDTO();
					shopping.setNo(rs.getInt("no"));
					shopping.setShopno(rs.getString("shopno"));
					shopping.setCate(rs.getString("cate"));
					shopping.setPlace(rs.getString("place"));
					shopping.setComment1(rs.getString("comment1"));
					shopping.setComment2(rs.getString("comment2"));
					shoppingList.add(shopping);
				}
			} catch(ClassNotFoundException e){
				System.out.println("드라이버 로딩 실패");
				e.printStackTrace();
			} catch(SQLException e){
				System.out.println("SQL 구문이 처리되지 못했습니다.");
				e.printStackTrace();
			} catch(Exception e){
				System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
			} finally {
				Maria.close(rs, pstmt, con);
			}
			return shoppingList;
	}
}