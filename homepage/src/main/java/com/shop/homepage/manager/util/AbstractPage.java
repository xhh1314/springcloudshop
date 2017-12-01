package com.shop.homepage.manager.util;

import com.shop.homepage.manager.exception.PageException;

/**
 * @author 定义一个page抽象类，一页下一页算法由子类决定
 */
public abstract class AbstractPage {
	protected int beginPage;
	protected int endPage;
	protected int currentPage;
	protected int totalNumber;
	protected int totalPage;

	/**
	 * 一个页面要展示几个page按钮，默认值5
	 */
	protected int eachPage;

	/**
	 * 每页显示的行数，默认10行
	 */
	protected int eachPageNumber;

	/**
	 * 传入数据库的起始行
	 */
	protected int beginNumber;

	/**
	 * 返回的行数
	 */
	protected int rows;

	public AbstractPage(int eachPage, int eachPageNumber) {
		this.eachPage = eachPage;
		this.eachPageNumber = eachPageNumber;
	}

	public AbstractPage() {
		this.eachPageNumber = 10;
		this.eachPage = 5;
		this.currentPage = 1; // 初始化当前页为第一页
	}
	
	public static synchronized AbstractPage getPageInstance(){
		return new PageV1();
	}
	public static synchronized AbstractPage getPageInstance(int eachPage, int eachPageNumber)
	{
		return new PageV1(eachPage,eachPageNumber);
	}
	
	public abstract AbstractPage getNextPage(AbstractPage page);
	public abstract AbstractPage getPreviousPage(AbstractPage page);
	public abstract AbstractPage getCurrentPage(AbstractPage page);
	/**
	 * 上一页算法
	 */
	protected abstract void previousPage();
	/**
	 * 下一页算法
	 */
	protected abstract void nextPage();

	/**
	 * 初始化开始和结束页码
	 */
	protected void initialPageNumber() {
		if (eachPageNumber == 0 || eachPage == 0) {
			throw new PageException("初始化page错误！eachPageNumber 或 eachPage 不能为0！");
		}
		if (totalNumber % eachPageNumber == 0) {
			this.totalPage = totalNumber / eachPageNumber;
		} else {
			this.totalPage = totalNumber / eachPageNumber + 1;
		}
		
		if (beginPage * endPage != 0){// 如果page已经被实例化过了，则不需要再实例化
			return;
		}
		if (totalPage <= eachPage) {
			this.beginPage = 1;
			this.endPage = totalPage;
		} else {
			this.beginPage = 1;
			this.endPage = this.eachPage;
		}

	}
	/**
	 * 计算数据库分页查询时需要的起始参数
	 */
	protected void caculateBeginAndRows() {
		this.beginNumber = (this.currentPage - 1) * eachPageNumber + 1;
		this.rows = eachPageNumber;
		if((beginNumber+rows)>totalNumber) {
			this.rows=totalNumber-beginNumber+1;
		}
	}
	

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getBeginNumber() {

		return beginNumber;
	}

	public void setBeginNumber(int beginNumber) {
		this.beginNumber = beginNumber;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getEachPage() {
		return eachPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getEachPageNumber() {
		return eachPageNumber;
	}

	public void setEachPageNumber(int eachPageNumber) {
		this.eachPageNumber = eachPageNumber;
	}

	public void setEachPage(int eachPage) {
		this.eachPage = eachPage;
	}
	

}
