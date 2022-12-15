package kr.go.mapo.model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.mapo.dto.NoticeDTO;
import kr.go.mapo.dto.QnaDTO;

public class QnaDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql = "";
	
	
	public ArrayList<QnaDTO> getQnaList() {
		ArrayList<QnaDTO> qnaList = new ArrayList<QnaDTO>();
		try {
			con = Maria.getConnection();
			pstmt = con.prepareStatement(Maria.QNA_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnaDTO dto = new QnaDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAuthor(rs.getString("author"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
				dto.setLev(rs.getInt("lev"));
				dto.setSec(rs.getInt("sec"));
				qnaList.add(dto);
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
		return qnaList;
	}
	
	public QnaDTO getQna(int no){
		QnaDTO dto = new QnaDTO();
		try {
			con = Maria.getConnection();
			//
			pstmt = con.prepareStatement(Maria.QNA_VISITED_UPDATE);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			pstmt.close();
			//
			pstmt = con.prepareStatement(Maria.QNA_SELECT_ONE);
			pstmt.setInt(1, no);		
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAuthor(rs.getString("author"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setVisited(rs.getInt("visited"));
				dto.setLev(rs.getInt("lev"));
				dto.setSec(rs.getInt("sec"));
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
	
	public int addNotice(QnaDTO dto){
		int cnt = 0;
		try {
			con = Maria.getConnection();
			//
			pstmt = con.prepareStatement(Maria.QNA_INSERT);
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

	public int delQna(int no) {

		return 0;
	}

	public int modifyQna(QnaDTO dto) {

		return 0;
	}

	public int addQna(QnaDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
}

	

