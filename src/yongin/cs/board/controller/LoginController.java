package yongin.cs.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yongin.cs.board.dao.MemberDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberDao mDao = MemberDao.getInstance();
		int loginResult = mDao.login(id, pw);
		
		if (loginResult == 1) {
			req.setAttribute("loginResult", loginResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("loginResult", loginResult);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(req, resp);
		}
		
	}


}

