package me.quantumti.common;

import java.io.Serializable;
import java.util.List;

public class Page<P> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3788698506332155566L;
	
	//当前页号
	private Integer pageNum = 0;
	//每页数据量
	private Integer pageSize = 0;
	//总页数
	private Integer pageSum = 0;
	//数据开始位置（从1开始）
	private Integer beginNum = 0;
	//数据开始索引（从0开始）
	private Integer beginIndex = 0;
	//数据结束位置
	private Integer endNum = 0;
	//总数据量
	private Integer dataSum = 0;
	//当前页数据
	private List<P> datas;

	public Page() {

	}

	public Page(Integer pageNum, Integer pageSize, Integer dataSum) {
		// 设置当前页号
		this.setPageNum(pageNum);
		// 设置每页数量
		this.setPageSize(pageSize);
		// 设置总数
		this.setDataSum(dataSum);
		// 数据为0时
		if (this.dataSum == 0) {
			this.pageNum = 0;
			this.beginNum = 0;
			this.endNum = 0;
			this.beginIndex = 0;
		} else {
			// 计算总页数
			this.pageSum = (this.dataSum + this.pageSize - 1) / this.pageSize;
			// 当前页号，是否超出范围
			this.pageNum = this.pageNum > this.pageSum ? this.pageSum
					: this.pageNum;
			// 数据开始的位置
			this.beginNum = (this.pageNum - 1) * this.pageSize + 1;
			// 数据开始索引
			this.beginIndex = this.beginNum - 1;
			// 数据结束位置
			this.endNum = this.pageNum * this.pageSize;
			// 超出范围
			this.endNum = this.endNum > this.dataSum ? this.dataSum
					: this.endNum;
		}

	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		pageNum = pageNum < 1 ? 1 : pageNum;
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		pageSize = pageSize < 1 ? 20 : pageSize;
		this.pageSize = pageSize;
	}

	public Integer getPageSum() {
		return pageSum;
	}

	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

	public Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;
	}

	public Integer getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	public Integer getDataSum() {
		return dataSum;
	}

	public void setDataSum(Integer dataSum) {
		this.dataSum = dataSum;
	}

	public List<P> getDatas() {
		return datas;
	}

	public void setDatas(List<P> datas) {
		this.datas = datas;
	}

	public void setPageData(Integer pageNum, Integer pageSize, Integer dataSum) {
		// 设置当前页号
		this.setPageNum(pageNum);
		// 设置每页数量
		this.setPageSize(pageSize);
		// 设置总数
		this.setDataSum(dataSum);
		// 数据为0时
		if (this.dataSum == 0) {
			this.pageNum = 1;
			this.beginNum = 0;
			this.endNum = 0;
			this.beginIndex = 0;
			this.pageSum = 1;

		} else {
			// 计算总页数
			this.pageSum = (this.dataSum + this.pageSize - 1) / this.pageSize;
			// 当前页号，是否超出范围
			this.pageNum = this.pageNum > this.pageSum ? this.pageSum
					: this.pageNum;
			// 数据开始的位置
			this.beginNum = (this.pageNum - 1) * this.pageSize + 1;
			// 数据开始索引
			this.beginIndex = this.beginNum - 1;
			// 数据结束位置
			this.endNum = this.pageNum * this.pageSize;
			// 超出范围
			this.endNum = this.endNum > this.dataSum ? this.dataSum
					: this.endNum;
		}

	}
	
}
