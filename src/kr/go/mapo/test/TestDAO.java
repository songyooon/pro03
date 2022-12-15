package kr.go.mapo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import kr.go.mapo.model.Maria;
import kr.go.mapo.test.TestDAO;
import kr.go.mapo.test.TestDTO;

public class TestDAO {
  private Connection con = null;
  
  private PreparedStatement pstmt = null;
  
  private ResultSet rs = null;
  
  String sql = "";
  
  public TestDTO testDataOne(String name) {
    TestDTO dto = new TestDTO();
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("select * from test where name=?");
      this.pstmt.setString(1, name);
      this.rs = this.pstmt.executeQuery();
      if (this.rs.next()) {
        dto.setName(this.rs.getString("name"));
        dto.setPoint(this.rs.getInt("point"));
      } 
    } catch (Exception e) {
      System.out.println("");
    } finally {
      Maria.close(this.rs, this.pstmt, this.con);
    } 
    return dto;
  }
  
  public ArrayList<TestDTO> testDataAll() {
    ArrayList<TestDTO> list = new ArrayList<>();
    try {
      this.con = Maria.getConnection();
      this.pstmt = this.con.prepareStatement("select * from test");
      this.rs = this.pstmt.executeQuery();
      while (this.rs.next()) {
        TestDTO dto = new TestDTO();
        dto.setName(this.rs.getString("name"));
        dto.setPoint(this.rs.getInt("point"));
        list.add(dto);
      } 
    } catch (Exception e) {
      System.out.println("");
    } finally {
      Maria.close(this.rs, this.pstmt, this.con);
    } 
    return list;
  }
}
