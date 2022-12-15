package kr.go.mapo.dto;

import kr.go.mapo.dto.NoticeDTO;

public class NoticeDTO {
  private int no;
  
  private String title;
  
  private String content;
  
  private String regDate;
  
  private int visited;
  
  public int getNo() {
    return this.no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getRegDate() {
    return this.regDate;
  }
  
  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }
  
  public int getVisited() {
    return this.visited;
  }
  
  public void setVisited(int visited) {
    this.visited = visited;
  }
}
