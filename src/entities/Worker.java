package entities;

import java.util.ArrayList;
import java.util.List;

import entitites.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private double baseSalary;

	private List<HourContract> contracts = new ArrayList<>(); 
	private Department department;
	
	public Worker (String name, WorkerLevel level, double salary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = salary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}

	public String getDepartment() {
		return department.getName();
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = this.baseSalary;
		
		for (HourContract contract : this.contracts) {
			if (contract.getDate().getYear() == year && contract.getDate().getMonthValue() == month) {
				sum = sum + contract.totalValue();
			}
		}
		
		return sum;
	}
}
