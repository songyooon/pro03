package kr.go.mapo.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.mapo.dto.NoticeDTO;

public class NoticeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	
	public ArrayList<NoticeDTO> getNoticeList() {
		ArrayList<NoticeDTO> notiList = new ArrayList<NoticeDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				NoticeDTO dto = new NoticeDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
				notiList.add(dto);
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
		return notiList;
	}
	
	public NoticeDTO getNotice(int no){
		NoticeDTO dto = new NoticeDTO();
		try {
			con = Maria.getConnection();
			//
			pstmt = con.prepareStatement(Maria.NOTICE_VISITED_UPDATE);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			pstmt.close();
			//
			pstmt = con.prepareStatement(Maria.NOTICE_SELECT_ONE);
			pstmt.setInt(1, no);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
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
	
	public int addNotice(NoticeDTO dto){
		int cnt = 0;
		try {
			con = Maria.getConnection();
			//
			pstmt = con.prepareStatement(Maria.NOTICE_INSERT);
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

	public int delNotice(int no) {

		return 0;
	}

	public int modifyNotice(NoticeDTO dto) {

		return 0;
	}
}
