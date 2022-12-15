package kr.go.mapo.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.mapo.dto.FoodDTO;

public class FoodDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	
	public ArrayList<FoodDTO> getFoodList() {
		ArrayList<FoodDTO> foodList = new ArrayList<FoodDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.FOOD_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				FoodDTO dto = new FoodDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setKind(rs.getString("kind"));
				dto.setMenu(rs.getString("menu"));
				dto.setPos(rs.getString("pos"));
				dto.setTel(rs.getString("tel"));
				foodList.add(dto);
			}
		} catch(ClassNotFoundException e){
			System.out.println("");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL" );
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return foodList;
	}
	
	public FoodDTO getNotice(int no){
		FoodDTO dto = new FoodDTO();
		try {
			con = Maria.getConnection();

			pstmt = con.prepareStatement(Maria.FOOD_SELECT_ONE);
			pstmt.setInt(1, no);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setKind(rs.getString("kind"));
				dto.setMenu(rs.getString("menu"));
				dto.setPos(rs.getString("pos"));
				dto.setTel(rs.getString("tel"));
			}

		} catch(ClassNotFoundException e){
			System.out.println("");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL" );
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("");
		} finally {
			Maria.close(rs, pstmt, con);
		}
		return dto;
	}
	
	public int addNotice(FoodDTO dto){
		int cnt = 0;
		try {
			con = Maria.getConnection();
			//
			pstmt = con.prepareStatement(Maria.FOOD_INSERT);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getKind());
			pstmt.setString(3, dto.getMenu());
			pstmt.setString(4, dto.getPos());
			pstmt.setString(5, dto.getTel());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e){
			System.out.println("");
			e.printStackTrace();
		} catch(SQLException e){
			System.out.println("SQL" );
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("");
		} finally {
			Maria.close(pstmt, con);
		}
		return cnt;
	}

	public int delNotice(int no) {

		return 0;
	}

	public int modifyNotice(FoodDTO dto) {

		return 0;
	}

	public int addFood(FoodDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delFood(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifyFood(FoodDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FoodDTO getFood(int no) {
		// TODO Auto-generated method stub
		return null;
	}
}
