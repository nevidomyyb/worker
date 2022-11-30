package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entitites.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("-Enter worker data-");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double workerBaseSalary = sc.nextDouble();

		Department department = new Department(departmentName);
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, department);
		
		System.out.print("How many contracts to this worker? ");
		int contracts = sc.nextInt();
		
		for (int x = 0; x < contracts; x++) {
			System.out.printf("Enter contract #%d data:\n", (x + 1));
			System.out.print("Date (DD/MM/YYYY): ");
			String contractDateString = sc.next();
			LocalDate contractDate = LocalDate.parse(contractDateString, formato);
			System.out.print("Value per hour: ");
			double contractValuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int contractHours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, contractValuePerHour, contractHours);
			worker.addContract(contract);
			System.out.println();

		}
		System.out.print("Enter the month and year to calculate income (MM/YYYY): ");
		String incomeString = sc.next();
		int month = Integer.parseInt(incomeString.substring(0,2));
		int year = Integer.parseInt(incomeString.substring(3));
		double income = worker.income(year, month);
		
		System.out.printf("Name: %s\n", worker.getName());
		System.out.printf("Department: %s\n", worker.getDepartment());
		System.out.printf("Income for %s: %.2f\n", incomeString, income);
		
		sc.close();
		
		
	}

}
