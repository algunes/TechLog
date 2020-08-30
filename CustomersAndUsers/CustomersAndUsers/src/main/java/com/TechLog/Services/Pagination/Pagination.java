package com.TechLog.Services.Pagination;

public class Pagination {
	
	private Integer first;
	private Integer max;
	private Integer totalPage;
	private Integer currentPage;
	private Long numberOfObjects;
	
	private Boolean nextIsNotActive;
	private Integer nextLink;
	
	private Boolean prevIsNotActive;
	private Integer prevLink;
	
	
	public Pagination(Integer first, Integer max, Long numberOfObjects) {
		super();
		
		this.first = first;
		this.max = max;
		this.numberOfObjects = numberOfObjects;
		
		this.totalPage = (int)Math.ceil((double)numberOfObjects/(double)max);
		this.currentPage = (int)(first+max)/max;
		
		this.nextIsNotActive = currentPage >= totalPage ? true : false;
		this.nextLink = first+max;
		
		this.prevIsNotActive = currentPage <= 1 ? true : false;
		this.prevLink = first-max;
			
	}


	public Integer getFirst() {
		return first;
	}


	public Integer getMax() {
		return max;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public Long getNumberOfObjects() {
		return numberOfObjects;
	}


	public Boolean getNextIsNotActive() {
		return nextIsNotActive;
	}


	public Integer getNextLink() {
		return nextLink;
	}


	public Boolean getPrevIsNotActive() {
		return prevIsNotActive;
	}


	public Integer getPrevLink() {
		return prevLink;
	}
	
	
	
}
