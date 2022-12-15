package kr.go.mapo.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.mapo.dto.HistoryDTO;

public class HistoryDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	
	public ArrayList<HistoryDTO> getHistoryList(int no) {
		ArrayList<HistoryDTO> historyList = new ArrayList<HistoryDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.HISTORY_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				HistoryDTO dto = new HistoryDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				historyList.add(dto);
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
		return historyList;
	}
	
	
	public int addHistory(HistoryDTO dto){
		int cnt = 0;
		try {
			con = Maria.getConnection();
			//
			pstmt = con.prepareStatement(Maria.HISTORY_INSERT);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
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

	public int delHistory(int no) {

		return 0;
	}

	public int modifyHistory(HistoryDTO dto) {

		return 0;
	}
}
