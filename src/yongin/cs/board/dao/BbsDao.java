package yongin.cs.board.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import yongin.cs.board.dto.BbsDto;

public class BbsDao {
	private static BbsDao mDao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	
	private BbsDao() {
		
	}

	public static synchronized BbsDao getInstance() {
		if (mDao == null) {
			mDao = new BbsDao();
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
	
	public int write(BbsDto mDto) {
		con = this.getConnection();
		String query = "insert into bbs(bbstitle, bbscontent, bbscategory, id) values(?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mDto.getBbstitle());
			pstmt.setString(2, mDto.getBbscontent());
			pstmt.setString(3, mDto.getBbscategory());
			pstmt.setString(4, mDto.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, null);
		}
		return result;
	}
	
	public List<BbsDto> selectList(){
		List<BbsDto> list = new ArrayList<>();
		
		try {
			con = getConnection();
			String sql ="SELECT * FROM bbs ORDER BY bbsId DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BbsDto bbsDto = new BbsDto();
				bbsDto.setBbsid(rs.getInt("bbsid"));
				bbsDto.setBbstitle(rs.getString("bbstitle"));
				bbsDto.setBbscontent(rs.getString("bbscontent"));
				bbsDto.setBbsdate(rs.getString("bbsdate"));
				bbsDto.setBbshit(rs.getInt("bbshit"));
				bbsDto.setBbscategory(rs.getString("bbscategory"));
				bbsDto.setId(rs.getString("id"));
				list.add(bbsDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}
}
	
	
