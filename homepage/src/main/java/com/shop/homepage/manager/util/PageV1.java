package com.shop.homepage.manager.util;

import com.shop.homepage.manager.exception.PageException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lh
 *算法思路： 1、不根据当前页算起始页  2、当用户点击上一页或者下页的时候，才算出下一次需要显示的页码
 */
@Component
@Scope("prototype")
public class PageV1  extends AbstractPage{

	public PageV1() {
		super();
	}
	
	public PageV1(int eachPage, int eachPageNumber) {
		super(eachPage, eachPageNumber);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 计算数据库分页查询时需要的起始参数
	 */
	@Override
	protected void caculateBeginAndRows() {
		this.beginNumber = (this.currentPage - 1) * eachPageNumber + 1;
		this.rows = eachPageNumber;
		if((beginNumber+rows)>totalNumber) {
			this.rows=totalNumber-beginNumber+1;
		}
	}

	/**
	 * 点击上一页的时候，算出开始页面和结束页码
	 * 
	 * @param beginPage
	 *            当前的开始页码
	 */
	@Override
	protected void previousPage() {
		if (beginPage <= 0) {
			throw new PageException("beginPage不能小于1!");
		}
		if (beginPage == 1)// 如果已经是第一页了，还点上一页，则直接返回第一页数据
		{
			this.currentPage = 1;
			return;
		}
		if (beginPage <=eachPage) {//当开始页在2~eachPage之间时，点击上一页，开始页直接设置为1
			this.currentPage = beginPage-1;
			this.beginPage =1;
			this.endPage = beginPage+eachPage-1;
			if(endPage>totalPage) {
				endPage=totalPage;
			}
		} else {//当起始页大于eachPage时，起始页直接减eachPage
			this.currentPage=beginPage-1;
			this.beginPage = beginPage - eachPage;
			this.endPage = endPage-eachPage;
		}
		

	}

	/**
	 * 点击下一页，算出下一页显示的页码，如果遇到尾页，则保持尾页维持显示eachPage
	 * 
	 * @param endPage
	 *            当前endPage
	 * @param totalPage
	 *            总页数
	 */
	@Override
	protected void nextPage() {
		if (endPage == totalPage) {// 如果已经是最后一页了，还点下一页，直接返回最后一页的数据
			this.currentPage = endPage;
			return;
		}
		this.currentPage = endPage + 1;
		if ((endPage + eachPage) >= totalPage) {
			this.endPage = totalPage;
			this.beginPage = endPage - eachPage+1;
		} else {
			this.beginPage = endPage + 1;
			this.endPage = beginPage + eachPage-1;
		}
		
	}
	@Override
	public AbstractPage getNextPage(AbstractPage page) {
		// TODO Auto-generated method stub
		page.initialPageNumber();
		page.nextPage();
		page.caculateBeginAndRows();
		return page;
	}

	@Override
	public AbstractPage getPreviousPage(AbstractPage page) {
		// TODO Auto-generated method stub
		page.initialPageNumber();
		page.previousPage();
		page.caculateBeginAndRows();
		return page;
	}

	@Override
	public AbstractPage getCurrentPage(AbstractPage page) {
		// TODO Auto-generated method stub
		page.initialPageNumber();
		page.caculateBeginAndRows();
		return page;
	}
	

}
