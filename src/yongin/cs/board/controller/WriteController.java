package yongin.cs.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yongin.cs.board.dao.*;
import yongin.cs.board.dto.*;

/**
 * Servlet implementation class WriteController
 */
@WebServlet("/write.do")
public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/write.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		if (sessionID == null) {
			sessionID = "��ȸ��";
		}
		
		String bbsCategory = req.getParameter("bbsCategory");
		String bbsTitle = req.getParameter("bbsTitle");
		String bbsContent = req.getParameter("bbsContent");
		
		BbsDao bbsDao = BbsDao.getInstance();
		BbsDto bbsDto = new BbsDto();
		bbsDto.setBbscategory(bbsCategory);
		bbsDto.setBbstitle(bbsTitle);
		bbsDto.setBbscontent(bbsContent);
		bbsDto.setId(sessionID);

		int wResult = bbsDao.write(bbsDto);
		System.out.println(wResult);
		resp.sendRedirect("bbs.do");
	}
	
}