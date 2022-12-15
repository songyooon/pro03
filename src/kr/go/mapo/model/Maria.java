package kr.go.mapo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Maria {
    static final String DRIVER = "org.mariadb.jdbc.Driver";
    static final String URL = "jdbc:mariadb://127.0.0.1:3308/government?serverTimezone=Asia/Seoul";
    static final String USER = "root";
    static final String PW = "1234";
    
    
	final static String NOTICE_SELECT_ALL = "select * from notice order by regdate desc";
	final static String NOTICE_VISITED_UPDATE = "update notice set visited = visited + 1 where no=?";
	final static String NOTICE_SELECT_ONE = "select * from notice where no=?";
	final static String NOTICE_INSERT = "insert into notice(title, content) values (?, ?)";
	final static String NOTICE_DELEDTE = "delete from notice where no=?";
	final static String NOTICE_UPDATE = "update notice set title=?, content=? where no=?";
	
	final static String USER_JOIN = "insert into user(id, pw, name, birth, email, tel, addr) values (?,?,?,?,?,?,?)";
	final static String USER_LOGIN = "select * form user where id=? and pw=?";
	final static String USER_ID_CHECK = "select * from user where id=?";
	final static String USER_ALL = "select * from user";
	final static String USER_UPDATE = "update user set pw=?, name=?, birth=?, email=?, tel=?, addr=? where id=?";
	final static String VISIT_UPDATE = "update user set visted=visted+1 where id=?";
	
	final static String LOAD_LAST_NO = "select no from tour order by no desc limit 1";
	final static String FILE_UPLOAD = "insert into pic(tourno, picname, pos) values (?,?,?)";
	final static String JSON_PICLIST = "select * from pic where tourno=?";
	final static String ADD_TOUR = "insert into tour(tourno, cate, place, comment1, comment2, addr) values (?,?,?,?,?,?)";
	final static String TOUR_LIST_ALL = "select * from tour";
	final static String TOUR_CATE_LIST = "select a.no, a.tourno, a.cate, a.place, a.comment1, a.comment2, b.picname, b.pos from tour a inner join pic b on a.tourno=b.tourno where a.cate=? and b.pos=1";
	
	final static String ADD_SHOPPING = "insert into shopping(shopno, cate, place, comment1, comment2, addr) values (?,?,?,?,?,?)";
	final static String SHOPPING_LIST_ALL = "select * from shopping";
	final static String SHOPPING_CATE_LIST = "select a.no, a.shopno, a.cate, a.place, a.comment1, a.comment2, b.picname, b.pos from shopping a inner join pic b on a.shopno=b.shopno where a.cate=? and b.pos=1";
	
	
	final static String TOUR_SEARCH_PLACE_LIST = "select * from tour where place like CONCAT('%',?,'%')"; //'%'+?+'%'
	final static String TOUR_SEARCH_COMMENT_LIST = "select * from tour where comment2 like ?";
	final static String TOUR_SEARCH_ALL_LIST = "select * from tour where place like ? or comment2 like ?";
	final static String TOUR_LIST_DETAIL = "select * from tour where no=?";
	final static String TOUR_DEL = "delete from tour where no=?";
	final static String MODIFY_TOUR = "update tour set tourno=?, cate=?, place=?, comment1=?, comment2=?, addr=? where no=?";
	
	public final static String TEST_SELECT_ONE = "select * from test where name=?";
	public final static String TEST_SELECT_ALL = "select * from test";

	final static String QNA_SELECT_ALL = "select * from qna order by regdate desc";
	final static String QNA_VISITED_UPDATE = "update qna set visited = visited + 1 where no=?";
	final static String QNA_SELECT_ONE = "select * from qna where no=?";
	final static String QNA_INSERT = "insert into qna(title, content) values (?, ?)";
	final static String QNA_DELEDTE = "delete from qna where no=?";
	final static String QNA_UPDATE = "update qna set title=?, content=? where no=?";
	
	final static String FOOD_SELECT_ALL = "select * from food order by no asc";
	final static String FOOD_SELECT_ONE = "select * from food where no=?";
	final static String FOOD_INSERT = "insert into food(name, kind, menu, pos, tel) values (?, ?, ?, ?, ?)";
	final static String FOOD_DELEDTE = "delete from food where no=?";
	final static String FOOD_UPDATE = "update food set name=?, kind=?, menu=?, pos=?, tel=? where no=?";
    
	final static String SHOPPING_SEARCH_PLACE_LIST = "select * from shopping where place like CONCAT('%',?,'%')"; //'%'+?+'%'
	final static String SHOPPING_SEARCH_COMMENT_LIST = "select * from shopping where comment2 like ?";
	final static String SHOPPING_SEARCH_ALL_LIST = "select * from shopping where place like ? or comment2 like ?";
	final static String SHOPPING_LIST_DETAIL = "select * from shopping where no=?";
	final static String SHOPPING_DEL = "delete from shopping where no=?";
	final static String MODIFY_SHOPPING = "update shopping set shopno=?, cate=?, place=?, comment1=?, comment2=?, addr=? where no=?";
	
	final static String HISTORY_SELECT_ALL = "select * from history";
	final static String HISTORY_SELECT_ONE = "select * from history where no=?";
	final static String HISTORY_INSERT = "insert into history(title, content) values (?, ?)";
	final static String HISTORY_DELEDTE = "delete from history where no=?";
	final static String HISTORY_UPDATE = "update history set title=?, content=? where no=?";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER, PW);
		return con;
	}
	
	public static void close(PreparedStatement pstmt, Connection con) {
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if(rs!=null){
			try {
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
