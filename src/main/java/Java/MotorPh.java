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


    public static void main(String[] args) {
        // Initialize employee and attendance models
        attendanceModel = new AttendanceModelFromFile();
        employeeModel = new EmployeeDataFromFile();
        // Call method to choose an employee
        chooseEmployee();
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

        String id = "";
        String name = "", bday = "", status = "", sssNum = "",
                philHealth = "", tin = "", pagIbig = "";
        String setEmpId = "";


        System.out.println("        **MOTORPH PAYROLL SYSTEM**     ");
        System.out.println("---------------------------------------------");
        //instantiation
        Scanner s1 = new Scanner(System.in);

        System.out.print("Enter Employee Number: ");
        setEmpId = s1.nextLine();

        // Iterate through the list of employees to find the specified employee
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmpID(), setEmpId)) {
                // Retrieve employee details
                id = employee.getEmpID();
                name = employee.getFirstName() + " " + employee.getLastName();
                bday = employee.getBirthday();
                status = employee.getStatus();
                sssNum = employee.getSss();
                tin = employee.getTin();
                philHealth = employee.getPhilhealth();
                pagIbig = employee.getPagIbig();
                break;
            }
            id = "";
        }

        // Display employee details if found, otherwise display "No data found"
        if (Objects.equals(id, "")){
            System.out.println("No data found");
        } else {
            System.out.println("Employee ID: " + id);
            System.out.println("Full Name:"+ name);
            System.out.println("Birthday: " + bday);
            System.out.println("Employment Status: " + status);
            System.out.println("---------------------------------------------");
            System.out.println("SSS: " + sssNum);
            System.out.println("TIN: " + tin);
            System.out.println("Philhealth: " + philHealth);
            System.out.println("Pag-ibig: " + pagIbig);
            System.out.println("---------------------------------------------");

            // Call method to calculate net salary for the employee
            employeeNetSalary(id);
            s1.close();
        }

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
        Double salary = 0.0, rice = 0.0, phoneAllow = 0.0, clothing = 0.0;

        String month = "";

        String stringDate = "";

        DecimalFormat df = new DecimalFormat("#.##");

        // Iterate through the list of employees to find details of the specified
        // employee
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmpID(), employeeId)) {
                hourlyRate = employee.getHourlyRate();
                rice = employee.getRiceSubsidy();
                phoneAllow = employee.getPhoneAllowance();
                clothing = employee.getClothingAllowance();
                break;
            }
        }

        Scanner s2 = new Scanner(System.in);

        System.out.print("Payroll Month(1-12):");
        month = s2.nextLine();
        System.out.println("Pay Period: " + employeeId);

        // Iterate through the list of attendances to find data for the specified month
        for (Attendance attendance : attendances) {
            if (attendance != null) {
                if (Objects.equals(employeeId, attendance.getEmployeeID())) {
                    if (Objects.equals(month.length(), 1)) {
                        stringDate = attendance.getDate().substring(1, 2);
                    } else {
                        stringDate = attendance.getDate().substring(0, 2);
                    }

                    if (Objects.equals(month, stringDate)) {
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
        double allowance = rice + phoneAllow + clothing;
        salary = computeSalary(totalHoursWork, allowance, hourlyRate);

        // Convert month number to month name
        Month selectedMonth = Month.of(Integer.parseInt(month));
        String monthName = selectedMonth.toString();

        System.out.println("Pay Period: " + monthName);
        System.out.println("---------------------------------------------");
        System.out.println("ALLOWANCE");
        System.out.println("Rice Subsidy: " + df.format(rice));
        System.out.println("Phone Allowance: " + df.format(phoneAllow));
        System.out.println("Clothing Allowance: " + df.format(clothing));
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

        s2.close();
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