package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class ToyFilter {
private List<Integer> producerIds = new ArrayList<>();
	
	private String search = "";

	private List<Integer> systemIds = new ArrayList<>();
	private List<Integer> subcategoryIds = new ArrayList<>();
	private List<Integer> genderIds = new ArrayList<>();
	private List<Integer> ageIds = new ArrayList<>();
	private List<Integer> materialIds = new ArrayList<>();
	public List<Integer> getProducerIds() {
		return producerIds;
	}
	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}
	public List<Integer> getSystemIds() {
		return systemIds;
	}
	public void setSystemIds(List<Integer> systemIds) {
		this.systemIds = systemIds;
	}
	public List<Integer> getSubcategoryIds() {
		return subcategoryIds;
	}
	public void setSubcategoryIds(List<Integer> subcategoryIds) {
		this.subcategoryIds = subcategoryIds;
	}
	public List<Integer> getGenderIds() {
		return genderIds;
	}
	public void setGenderIds(List<Integer> genderIds) {
		this.genderIds = genderIds;
	}
	public List<Integer> getAgeIds() {
		return ageIds;
	}
	public void setAgeIds(List<Integer> ageIds) {
		this.ageIds = ageIds;
	}
	public List<Integer> getMaterialIds() {
		return materialIds;
	}
	public void setMaterialIds(List<Integer> materialIds) {
		this.materialIds = materialIds;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
