/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Java;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author EM
 */
public class MotorPh {
    // Declare variables to hold employee and attendance data
    private static EmployeeModel employeeModel;
    private static AttendanceModel attendanceModel;
    private static String selectedEmployeeId = "1";

    public static void main(String[] args) {
        // Initialize employee and attendance models
        attendanceModel = new AttendanceModelFromFile();
        employeeModel = new EmployeeDataFromFile();
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("***********************************************");
        System.out.println("        Motor PH Main Menu      ");
        System.out.println("***********************************************");
        System.out.println("1: View Employee Records     ");
        System.out.println("2: Calculate Net Salary Based on Hours Worked    ");
        System.out.println("3: Calculate Net Salary    ");
        System.out.println("************************************************");
        /**
         * Creates an object of Scanner Resource from Camu:
         * https://www.programiz.com/java-programming/scanner
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Pleas choose the screen you would like to view: ");
        // takes input from the keyboard
        String option = input.nextLine();
        // prints the option
        processOption(option);
        // closes the scanner
        input.close();
    }

    private static void processOption(String option) {
        // Used conditional branch "switch" statement
        switch (option) {
            case "1":
                chooseEmployee();
                break;
            case "2":
                employeeNetSalary(selectedEmployeeId);
                break;
            case "3":
                calculateNetSalary();
                break;
            default:
                break;
        }
    }

    private static void goBackToMainMenu() {
        System.out.println("**********************************************************");
        System.out.println("    Would you like to go back to main menu?   ");
        System.out.println("    Option 1: Yes   ");
        System.out.println("    Option 2: No  ");
        System.out.println("**********************************************************");
        Scanner inputToMainMenu = new Scanner(System.in);
        String optionToMainMenu = inputToMainMenu.nextLine();
        switch (optionToMainMenu) {
            case "1":
                displayMainMenu();
                break;
            default:
                break;
        }
        inputToMainMenu.close();
    }

    /**
     * The chooseEmployee method allows the user to input an employee ID and
     * retrieves
     * information about that employee.
     */
    private static void chooseEmployee() {
        // Instanciating new object
        // Retrieve the list of employees
        Employee[] employeeList = employeeModel.getEmployeeDataList();

        String employeeID = "";
        String fullName = "", birthday = "", employmentStatus = "", sssNumber = "",
                philHealth = "", tin = "", pagIbig = "";
        String setEmpId = "";

        System.out.println("***********************************************");
        System.out.println("        **MOTORPH PAYROLL SYSTEM**     ");
        System.out.println("        You have chosen option #1    ");
        System.out.println("          View Employee Records      ");
        System.out.println("***********************************************");
        // instantiation
        Scanner inputEmployeeID = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        setEmpId = inputEmployeeID.nextLine();

        // Iterate through the list of employees to find the specified employee
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmpID(), setEmpId)) {
                // Retrieve employee details
                employeeID = employee.getEmpID();
                fullName = employee.getFirstName() + " " + employee.getLastName();
                birthday = employee.getBirthday();
                employmentStatus = employee.getStatus();
                sssNumber = employee.getSss();
                tin = employee.getTin();
                philHealth = employee.getPhilhealth();
                pagIbig = employee.getPagIbig();
                break;
            }
            employeeID = "";
        }

        // Display employee details if found, otherwise display "No data found"
        if (Objects.equals(employeeID, "")) {
            System.out.println("No data found");
        } else {
            selectedEmployeeId = employeeID;
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Full Name:" + fullName);
            System.out.println("Birthday: " + birthday);
            System.out.println("Employment Status: " + employmentStatus);
            System.out.println("---------------------------------------------");
            System.out.println("SSS: " + sssNumber);
            System.out.println("TIN: " + tin);
            System.out.println("Philhealth: " + philHealth);
            System.out.println("Pag-ibig: " + pagIbig);
            System.out.println("---------------------------------------------");
        }
        goBackToMainMenu();
        inputEmployeeID.close();

    }

    /**
     * The employeeNetSalary method calculates the net salary of an employee
     * based on their attendance and other details.
     */
    private static void employeeNetSalary(String employeeId) {
        // Retrieve the list of attendances and employees
        Attendance[] attendances = attendanceModel.getAttendanceModelList();
        Employee[] employeeList = employeeModel.getEmployeeDataList();
        // Initialize variables to store salary-related details
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        List<String> listDaysWork = new ArrayList<String>();
        List<String> listTimeIn = new ArrayList<String>();
        List<String> listTimeOut = new ArrayList<String>();
        List<Double> listHoursWork = new ArrayList<Double>();
        Double hourlyRate = 0.0;
        Double totalHoursWork = 0.0;
        Double salary = 0.0, riceAllowance = 0.0, phoneAllowance = 0.0, clothingAllowance = 0.0;

        String selectedPayrollMonth = "";

        String payrollMonth = "";

        DecimalFormat df = new DecimalFormat("#.##");

        // Iterate through the list of employees to find details of the specified
        // employee
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmpID(), employeeId)) {
                hourlyRate = employee.getHourlyRate();
                riceAllowance = employee.getRiceSubsidy();
                phoneAllowance = employee.getPhoneAllowance();
                clothingAllowance = employee.getClothingAllowance();
                break;
            }
        }

        Scanner inputPayrollMonth = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #2    ");
        System.out.println("          Calculate Net Salary  Based on Hours Worked      ");
        System.out.println("***********************************************");

        System.out.print("Enter Payroll Month(1-12):");
        selectedPayrollMonth = inputPayrollMonth.nextLine();
        System.out.println("Pay Period: " + employeeId);

        // Iterate through the list of attendances to find data for the specified month
        for (Attendance attendance : attendances) {
            if (attendance != null) {
                if (Objects.equals(employeeId, attendance.getEmployeeID())) {
                    if (Objects.equals(selectedPayrollMonth.length(), 1)) {
                        payrollMonth = attendance.getDate().substring(1, 2);
                    } else {
                        payrollMonth = attendance.getDate().substring(0, 2);
                    }

                    if (Objects.equals(selectedPayrollMonth, payrollMonth)) {
                        listDaysWork.add(attendance.getDate());
                        listTimeIn.add(attendance.getTimeIn());
                        listTimeOut.add(attendance.getTimeOut());
                    }
                }
            }
        }

        // Calculate hours worked for each day
        for (int i = 0; i < listDaysWork.size(); i++) {
            String timein = listTimeIn.get(i).replace(":", ".");
            String timeout = listTimeOut.get(i).replace(":", ".");
            double sum = (Double.parseDouble(timeout) - Double.parseDouble(timein) - 1);
            // Appends the hours worked to the end of this list
            listHoursWork.add(sum);
        }

        // Calculate total hours worked
        for (Double i : listHoursWork)
            totalHoursWork += i;

        // Calculate basic salary
        double allowance = riceAllowance + phoneAllowance + clothingAllowance;
        salary = computeSalary(totalHoursWork, allowance, hourlyRate);

        // Convert month number to month name
        Month selectedMonth = Month.of(Integer.parseInt(selectedPayrollMonth));
        String monthName = selectedMonth.toString();

        System.out.println("Pay Period: " + monthName);
        System.out.println("---------------------------------------------");
        System.out.println("ALLOWANCE");
        System.out.println("Rice Subsidy: " + df.format(riceAllowance));
        System.out.println("Phone Allowance: " + df.format(phoneAllowance));
        System.out.println("Clothing Allowance: " + df.format(clothingAllowance));
        System.out.println("---------------------------------------------");
        System.out.println("DEDUCTIONS");
        System.out.println("Pag-ibig: " + df.format(salaryDeductions.getPagibigDeduc(salary)));
        System.out.println("Philhealth: " + df.format(salaryDeductions.getPhilHealthDeduc(salary)));
        System.out.println("SSS: " + df.format(salaryDeductions.getSSSdeduc(salary)));
        System.out.println("Withholding Tax: " + df.format(salaryDeductions.getTax(salary)));
        System.out.println("---------------------------------------------");
        System.out.println("EARNINGS");
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours worked: " + df.format(totalHoursWork));
        System.out.println("Days Worked: " + listDaysWork.size());
        System.out.println("Net Salary: " + df.format((salary - salaryDeductions.getTotalDeductions(salary))));
        System.out.println("---------------------------------------------");
        System.out.println("Date: " + listDaysWork);
        System.out.println("Time in: " + listTimeIn);
        System.out.println("Time out: " + listTimeOut);

        goBackToMainMenu();
        inputPayrollMonth.close();
    }

    private static void calculateNetSalary() {
        // Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeDataList();
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #3    ");
        System.out.println("          Employee Net Salaries      ");
        System.out.println("***********************************************");
        // Iterate through the list of employees to find the specified employee
        for (int i = 0; i < employeeList.length; i++) {
            Employee employee = employeeList[i];
            if (Objects.equals(employee.getEmpID(), selectedEmployeeId)) {
                System.out.print("Last Name: " + employee.getLastName()
                        + ", First Name: " + employee.getFirstName()
                        + ", Basic Salary: " + employee.getBasicSalary()
                        + ", Net Salary: "
                        + (employee.getBasicSalary() - salaryDeductions.getTotalDeductions(employee.getBasicSalary()))
                        + "\n");
            }
        }
        goBackToMainMenu();
    }

    /**
     * The computeSalary method calculates the total salary of an employee
     * based on the hours worked, hourly rate, and allowances.
     * 
     * @param hoursWorked The total hours worked by the employee.
     * @param allowance   The total allowance provided to the employee.
     * @param hourlyRate  The hourly rate of the employee.
     * @return The total salary of the employee.
     */
    static double computeSalary(double hoursWorked, double allowance, double hourlyRate) {
        double salary = (hourlyRate * hoursWorked) + allowance;
        return salary;
    }
}