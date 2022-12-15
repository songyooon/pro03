package kr.go.mapo.dto;

import kr.go.mapo.dto.UserDTO;

public class UserDTO {
  private String id;
  
  private String pw;
  
  private String name;
  
  private int point;
  
  private String grade;
  
  private int visited;
  
  private String tel;
  
  private String addr;
  
  private String email;
  
  private String birth;
  
  private String regdate;
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getPw() {
    return this.pw;
  }
  
  public void setPw(String pw) {
    this.pw = pw;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getPoint() {
    return this.point;
  }
  
  public void setPoint(int point) {
	  this.point = point;
  }
  
  public String getGrade() {
    return this.grade;
  }
  
  public void setGrade(String grade) {
    this.grade = grade;
  }
  
  public int getVisited() {
    return this.visited;
  }
  
  public void setVisited(int visited) {
    this.visited = visited;
  }
  
  public String getTel() {
    return this.tel;
  }
  
  public void setTel(String tel) {
    this.tel = tel;
  }
  
  public String getAddr() {
    return this.addr;
  }
  
  public void setAddr(String addr) {
    this.addr = addr;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getBirth() {
    return this.birth;
  }
  
  public void setBirth(String birth) {
    this.birth = birth;
  }
  
  public String getRegdate() {
    return this.regdate;
  }
  
  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
}
