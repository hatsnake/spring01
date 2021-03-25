package com.hatsnake.spring01.domain;

public class CommentsVO {
	private int no;
	private int bNo;
	private String id;
	private String content;
	private String cDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	
	@Override
	public String toString() {
		return "CommentsVO [no=" + no + ", bNo=" + bNo + ", id=" + id + ", content=" + content + ", cDate=" + cDate
				+ "]";
	}

}
