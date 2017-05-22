package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class SubcategoryFilter {

	private String search = "";
	
	private List<Integer>  categoryIds = new ArrayList<>();

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
