package yongin.cs.board.dao;
import java.sql.*;
import yongin.cs.board.dto.MemberDto;

public class MemberDao {
	private static MemberDao mDao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	
	private MemberDao() {
		
	}

	public static synchronized MemberDao getInstance() {
		if (mDao == null) {
			mDao = new MemberDao();
		}
		return mDao;
	}
	
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/board?characterEncoding-UTF-8&serverTimezone=UTC";
		String id = "root", pw = "cs1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int join(MemberDto mDto) {
		con = this.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO member").append(" VALUES (?, ?, ?, ?)");
		try {
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPw());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, null);
		}
		return result;
	}
	
	public int login(String id, String pw) {
		con = this.getConnection();
		String query = "select pw from member where id = ? and pw = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					return 1;
				} else {
					return 0;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return -1;
	}
}
