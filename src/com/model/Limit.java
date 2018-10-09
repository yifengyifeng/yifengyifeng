package com.model;

public class Limit {
	private int id=1;
	private boolean allneed=false;
	private boolean addneed=true;
	private boolean checkneed=false;
	private boolean uppwd=true;
	private boolean queryneed=false;
	private boolean staneed=false;
	
	public Limit(int id,boolean allneed,boolean addneed,boolean checkneed,boolean uppwd,boolean queryneed,boolean staneed){
		this.id = id;
		this.allneed = allneed;
		this.addneed = addneed;
		this.checkneed = checkneed;
		this.uppwd = uppwd;
		this.queryneed = queryneed;
		this.staneed = staneed;
	}
	public Limit() {
		// TODO 自动生成的构造函数存根
	}
	public int getId() {
		return id;
	}
	public boolean isAllneed() {
		return allneed;
	}
	public boolean isAddneed() {
		return addneed;
	}
	public boolean isCheckneed() {
		return checkneed;
	}
	public boolean isUppwd() {
		return uppwd;
	}
	public boolean isQueryneed() {
		return queryneed;
	}
	public boolean isStaneed() {
		return staneed;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAllneed(boolean allneed) {
		this.allneed = allneed;
	}
	public void setAddneed(boolean addneed) {
		this.addneed = addneed;
	}
	public void setCheckneed(boolean checkneed) {
		this.checkneed = checkneed;
	}
	public void setUppwd(boolean uppwd) {
		this.uppwd = uppwd;
	}
	public void setQueryneed(boolean queryneed) {
		this.queryneed = queryneed;
	}
	public void setStaneed(boolean staneed) {
		this.staneed = staneed;
	}
	
	
}
