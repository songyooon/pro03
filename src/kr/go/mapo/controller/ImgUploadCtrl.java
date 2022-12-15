package kr.go.mapo.controller;

import com.oreilly.servlet.MultipartRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.go.mapo.dto.PicDTO;
import kr.go.mapo.model.TourDAO;
import net.sf.json.JSONObject;

@WebServlet({"/ImgUploadCtrl.do"})
public class ImgUploadCtrl extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    int maxSize = 10485760;
    String saveFolder = "D:/nsy/pro01/pro03/webapps/upload";
    String uploadPath = request.getRealPath("/upload");
    TourDAO dao = new TourDAO();
    PicDTO dto = new PicDTO();
    try {
      MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "UTF-8");
      int pos = Integer.parseInt(multi.getParameter("pos"));
      String tourno = multi.getParameter("tourno");
      Enumeration<String> files = multi.getFileNames();
      String file1 = files.nextElement();
      String fileName1 = multi.getFilesystemName(file1);
      String imageURL = String.valueOf(uploadPath) + fileName1;
      try {
        File imgURL = new File(imageURL);
        String extension = imageURL.substring(imageURL.lastIndexOf(".") + 1);
        BufferedImage image = ImageIO.read(imgURL);
        File file = new File(String.valueOf(saveFolder) + fileName1);
        if (!file.exists())
          file.mkdirs(); 
        ImageIO.write(image, extension, file);
        System.out.println("");
      } catch (Exception e) {
        e.printStackTrace();
      } 
      dto.setPicname(fileName1);
      dto.setPos(pos);
      dto.setTourno(tourno);
      int cnt = dao.fileUpload(dto);
      if (cnt >= 1) {
        System.out.println("");
      } else {
        System.out.println("");
        response.sendRedirect("./tour/imgUpload.jsp?no=" + pos + "&tourno=" + tourno);
      } 
      PrintWriter out = response.getWriter();
      TourDAO tour = new TourDAO();
      ArrayList<PicDTO> picList = tour.JSONPicList(tourno);
      HashMap<String, Object> map = new HashMap<>();
      map.put("picList", picList);
      JSONObject json = new JSONObject();
      json.putAll(map);
      out.println(json);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
