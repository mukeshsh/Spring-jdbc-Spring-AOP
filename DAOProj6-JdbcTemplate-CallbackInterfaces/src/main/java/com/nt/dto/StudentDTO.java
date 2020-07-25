package com.nt.dto;

public class StudentDTO {
	private int srNo;
	private int sno;
	private String sname;
	private String sadd;
	private float savg;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public float getSavg() {
		return savg;
	}
	public void setSavg(float savg) {
		this.savg = savg;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	@Override
	public String toString() {
		return "StudentDTO [srNo=" + srNo + ", sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", savg=" + savg
				+ "]";
	}
	
	}
	
