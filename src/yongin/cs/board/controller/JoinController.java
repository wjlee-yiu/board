package yongin.cs.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yongin.cs.board.dao.MemberDao;
import yongin.cs.board.dto.MemberDto;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/signup.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberDao mDao = MemberDao.getInstance();
		MemberDto mDto = new MemberDto();
		mDto.setId(id);
		mDto.setPw(pw);
		mDto.setName(name);
		mDto.setEmail(email);
		int joinResult = mDao.join(mDto);
		
		if (joinResult == 1) {
			req.setAttribute("joinResult", joinResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("joinResult", 0);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/signUp.jsp");
			rd.forward(req, resp);
		}
	}
}
