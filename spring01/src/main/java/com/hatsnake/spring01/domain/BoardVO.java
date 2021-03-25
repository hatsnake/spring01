package com.hatsnake.spring01.domain;

public class BoardVO {
	private int no;
	private String id;
	private String title;
	private String content;
	private int gNo;
	private int step;
	private int indent;
	private int count;
	private String bDate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", id=" + id + ", title=" + title + ", content=" + content + ", gNo=" + gNo
				+ ", step=" + step + ", indent=" + indent + ", count=" + count + ", bDate=" + bDate + "]";
	}
	
}
