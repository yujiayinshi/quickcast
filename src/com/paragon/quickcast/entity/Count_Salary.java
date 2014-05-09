package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Count_Salary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	
	//IT行业
	@Column(nullable = true)
	private int it_salary;
	
	//电子行业
	@Column(nullable = true)
	private int electronic_salary;
	
	//3G行业
	@Column(nullable = true)
	private int thirdgen_salary;
	
	//汽车制造
	@Column(nullable = true)
	private int car_salary;
	
	//电子商务
	@Column(nullable = true)
	private int ec_salary;
	
	//设计产业
	@Column(nullable = true)
	private int design_salary;
	
	//医药
	@Column(nullable = true)
	private int medicine_salary;
	
	//现代物流业
	@Column(nullable = true)
	private int logistics_salary;
	
	//金融行业
	@Column(nullable = true)
	private int finance_salary;
	
	//建筑业
	@Column(nullable = true)
	private int architecture_salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIt_salary() {
		return it_salary;
	}

	public void setIt_salary(int it_salary) {
		this.it_salary = it_salary;
	}

	public int getElectronic_salary() {
		return electronic_salary;
	}

	public void setElectronic_salary(int electronic_salary) {
		this.electronic_salary = electronic_salary;
	}

	public int getThirdgen_salary() {
		return thirdgen_salary;
	}

	public void setThirdgen_salary(int thirdgen_salary) {
		this.thirdgen_salary = thirdgen_salary;
	}

	public int getCar_salary() {
		return car_salary;
	}

	public void setCar_salary(int car_salary) {
		this.car_salary = car_salary;
	}

	public int getEc_salary() {
		return ec_salary;
	}

	public void setEc_salary(int ec_salary) {
		this.ec_salary = ec_salary;
	}

	public int getDesign_salary() {
		return design_salary;
	}

	public void setDesign_salary(int design_salary) {
		this.design_salary = design_salary;
	}

	public int getMedicine_salary() {
		return medicine_salary;
	}

	public void setMedicine_salary(int medicine_salary) {
		this.medicine_salary = medicine_salary;
	}

	public int getLogistics_salary() {
		return logistics_salary;
	}

	public void setLogistics_salary(int logistics_salary) {
		this.logistics_salary = logistics_salary;
	}

	public int getFinance_salary() {
		return finance_salary;
	}

	public void setFinance_salary(int finance_salary) {
		this.finance_salary = finance_salary;
	}

	public int getArchitecture_salary() {
		return architecture_salary;
	}

	public void setArchitecture_salary(int architecture_salary) {
		this.architecture_salary = architecture_salary;
	}
	
	
	

}
