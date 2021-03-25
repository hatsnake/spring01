package com.hatsnake.spring01.domain;

public class PageDTO {
	private int startRow;
	private int endRow;
	private int pageSize;
	private int count;
	private int pageNum;
	private int pageCount;
	private int pageBlock;
	private int startPage;
	private int endPage;
	
	public void pageInit() {
		setPageCount(count / pageSize + (count % pageSize == 0 ? 0 : 1));
		System.out.println("setPageCount : "+(count / pageSize + (count % pageSize == 0 ? 0 : 1)));
		setStartPage(((pageNum - 1) / pageBlock) * pageBlock + 1);
		System.out.println("setStartPage : "+(((pageNum - 1) / pageBlock) * pageBlock + 1));
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		setEndPage(endPage);
		System.out.println("setEndPage : "+(startPage + pageBlock - 1));
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		pageInit();
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "PageDTO [startRow=" + startRow + ", endRow=" + endRow + ", pageSize=" + pageSize + ", count=" + count
				+ ", pageNum=" + pageNum + ", pageCount=" + pageCount + ", pageBlock=" + pageBlock + ", startPage="
				+ startPage + ", endPage=" + endPage + "]";
	}
	
}
