package kr.go.mapo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.go.mapo.dto.UserDTO;
import kr.go.mapo.model.Maria;
import kr.go.mapo.model.UserDAO;
import kr.go.mapo.service.AES256;

public class UserDAO {
  private Connection con = null;
  
  private PreparedStatement pstmt = null;
  
  private ResultSet rs = null;
  
  String key = "%02x";
  
  public int idCheckPro(String id) {
    int cnt = 0;
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("select * from user where id=?");
      this.pstmt.setString(1, id);
      this.rs = this.pstmt.executeQuery();
      if (this.rs.next()) {
        cnt++;
      } else {
        cnt = 0;
      } 
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패");
    } catch (Exception e) {
      System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다");
    } finally {
      Maria.close(this.rs, this.pstmt, this.con);
    } 
    return cnt;
  }
  
  public int addUser(UserDTO user) {
    int cnt = 0;
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("insert into user(id, pw, name, tel, email, addr, birth) values (?,?,?,?,?,?,?)");
      this.pstmt.setString(1, user.getId());
      this.pstmt.setString(2, user.getPw());
      this.pstmt.setString(3, user.getName());
      this.pstmt.setString(4, user.getTel());
      this.pstmt.setString(5, user.getEmail());
      this.pstmt.setString(6, user.getAddr());
      this.pstmt.setString(7, user.getBirth());
      cnt = this.pstmt.executeUpdate();
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("SQL 구문이 처리되지 못했습니다" );
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다");
    } finally {
      Maria.close(this.pstmt, this.con);
    } 
    return cnt;
  }
  
  public int userLogin(String id, String pw) {
    int cnt = 0;
    String qpw = "";
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("update user set visited=visited+1 where id=?");
      this.pstmt.setString(1, id);
      this.pstmt.executeUpdate();
      this.pstmt.close();
      this.pstmt = this.con.prepareStatement("select * from user where id=?");
      this.pstmt.setString(1, id);
      this.rs = this.pstmt.executeQuery();
      if (this.rs.next()) {
        qpw = AES256.decryptAES256(this.rs.getString("pw"), this.key);
        System.out.println("비밀번호 복호화: " + qpw);
        if (pw.equals(qpw)) {
          cnt = 1;
        } else {
          cnt = 0;
        } 
      } else {
        cnt = 9;
      } 
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("SQL 구문이 처리되지 못했습니다");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("잘못된 연산 및 요청으로 목록을 불러오지 못했습니다");
    } finally {
      Maria.close(this.pstmt, this.con);
    } 
    return cnt;
  }
  
  public UserDTO userInfo(String id) {
    UserDTO dto = new UserDTO();
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("select * from user where id=?");
      this.pstmt.setString(1, id);
      this.rs = this.pstmt.executeQuery();
      if (this.rs.next()) {
        dto.setId(this.rs.getString("id"));
        dto.setPw(AES256.decryptAES256(this.rs.getString("pw"), this.key));
        dto.setName(this.rs.getString("name"));
        dto.setTel(this.rs.getString("tel"));
        dto.setEmail(this.rs.getString("email"));
        dto.setAddr(this.rs.getString("addr"));
        dto.setBirth(this.rs.getString("birth"));
        dto.setRegdate(this.rs.getString("regdate"));
        dto.setPoint(this.rs.getInt("point"));
        dto.setVisited(this.rs.getInt("visited"));
        dto.setGrade(this.rs.getString("grade"));


      } 
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("SQL 구문이 처리되지 못했습니다" );
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다");
    } finally {
      Maria.close(this.rs, this.pstmt, this.con);
    } 
    return dto;
  }
  
  public int updateUser(UserDTO user) {
    int cnt = 0;
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("update user set pw=?, name=?, tel=?, email=?, addr=?, birth=? where id=?");

      this.pstmt.setString(1, user.getPw());
      this.pstmt.setString(2, user.getName());
      this.pstmt.setString(3, user.getTel());
      this.pstmt.setString(4, user.getEmail());
      this.pstmt.setString(5, user.getAddr());
      this.pstmt.setString(6, user.getBirth());
      this.pstmt.setString(7, user.getId());

      cnt = this.pstmt.executeUpdate();
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("SQL 구문이 처리되지 못했습니다" );
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다");
    } finally {
      Maria.close(this.pstmt, this.con);
    } 
    return cnt;
  }
  
  public ArrayList<UserDTO> getUserList() {
    ArrayList<UserDTO> userList = new ArrayList<>();
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("select * from user");
      this.rs = this.pstmt.executeQuery();
      while (this.rs.next()) {
        UserDTO dto = new UserDTO();
        dto.setId(this.rs.getString("id"));
        dto.setPw(AES256.decryptAES256(this.rs.getString("pw"), this.key));
        dto.setName(this.rs.getString("name"));
        dto.setTel(this.rs.getString("tel"));
        dto.setEmail(this.rs.getString("email"));
        dto.setAddr(this.rs.getString("addr"));
        dto.setBirth(this.rs.getString("birth"));
        dto.setRegdate(this.rs.getString("regdate"));
        dto.setPoint(this.rs.getInt("point"));
        dto.setVisited(this.rs.getInt("visited"));
        dto.setGrade(this.rs.getString("grade"));

        System.out.println(dto.getId());
        userList.add(dto);
      } 
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로딩 실패");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("SQL 구문이 처리되지 못했습니다");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다");
    } finally {
      Maria.close(this.rs, this.pstmt, this.con);
    } 
    return userList;
  }
}
