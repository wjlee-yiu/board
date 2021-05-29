package yongin.cs.board.dto;

public class BbsDto {
	private int bbsid;
	private String bbstitle;
	private String bbscontent;
	private String bbsdate;
	private int bbshit;
	private String bbscategory;
	private String id;
	
	
	@Override
	public String toString() {
		return "BbsDto [bbsid=" + bbsid + ", bbstitle=" + bbstitle + ", bbscontent=" + bbscontent + ", bbsdate="
				+ bbsdate + ", bbshit=" + bbshit + ", bbscategory=" + bbscategory + ", id=" + id + "]";
	}
	
	public int getBbsid() {
		return bbsid;
	}
	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
	}
	public String getBbstitle() {
		return bbstitle;
	}
	public void setBbstitle(String bbstitle) {
		this.bbstitle = bbstitle;
	}
	public String getBbscontent() {
		return bbscontent;
	}
	public void setBbscontent(String bbscontent) {
		this.bbscontent = bbscontent;
	}
	public String getBbsdate() {
		return bbsdate;
	}
	public void setBbsdate(String bbsdate) {
		this.bbsdate = bbsdate;
	}
	public int getBbshit() {
		return bbshit;
	}
	public void setBbshit(int bbshit) {
		this.bbshit = bbshit;
	}
	public String getBbscategory() {
		return bbscategory;
	}
	public void setBbscategory(String bbscategory) {
		this.bbscategory = bbscategory;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
