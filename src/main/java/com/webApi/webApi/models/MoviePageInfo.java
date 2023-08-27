package com.webApi.webApi.models;

import java.util.List;
import java.util.Objects;

public class MoviePageInfo {
	private String page;
	private String per_page;
	private String total;
	private String total_pages;
	private List<MovieModel> data;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPer_page() {
		return per_page;
	}
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}
	public List<MovieModel> getData() {
		return data;
	}
	public void setData(List<MovieModel> data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, page, per_page, total, total_pages);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoviePageInfo other = (MoviePageInfo) obj;
		return Objects.equals(data, other.data) && Objects.equals(page, other.page)
				&& Objects.equals(per_page, other.per_page) && Objects.equals(total, other.total)
				&& Objects.equals(total_pages, other.total_pages);
	}
	
	

	
}
