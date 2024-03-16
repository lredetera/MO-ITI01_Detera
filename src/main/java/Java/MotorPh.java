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
    private static EmployeeModel employeeModel;
    private static AttendanceModel attendanceModel;


    public static void main(String[] args) {
//    employeeModel = new EmployeeData();
//        attendanceModel = new AttendanceData();

        attendanceModel = new AttendanceModelFromFile();
        employeeModel = new EmployeeDataFromFile();

        Employee[] employeeList = employeeModel.getEmployeeDataList();
        Attendance[] attendances = attendanceModel.getAttendanceModelList();
        SalaryDeductions salaryDeductions = new SalaryDeductions();

        List<String> list=new ArrayList<String>();
        List<String> listTimeIn=new ArrayList<String>();
        List<String> listTimeOut=new ArrayList<String>();
        List<Double> hoursWorked=new ArrayList<Double>();

        String id = "";
        String name = "", bday = "", status = "", position = "", supervisor = "", sssNum = "",
                philHealth = "", tin = "", pagIbig = "", basicSalary = "";
        String month = "";
        Double hourlyRate = 0.0;
        Double sumHoursWorked = 0.0;
        Double salary = 0.0, rice =0.0,phoneAllow = 0.0,clothing = 0.0;

        String junkDate = "";

        System.out.println("        **MOTORPH PAYROLL SYSTEM**     ");
        System.out.println("---------------------------------------------");
        String str = "";
        System.out.println("---------------------------------------------");
        //instantiation
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Employee Number: ");
        str=s.nextLine();

        for (Employee obj : employeeList) {
            if (Objects.equals(obj.getEmpID(), str)){
                id = obj.getEmpID();
                name = obj.getFirstName()+" "+obj.getLastName();
                bday = obj.getBirthday();
                status = obj.getStatus();
                sssNum = obj.getSss();
                tin = obj.getTin();
                philHealth = obj.getPhilhealth();
                pagIbig = obj.getPagIbig();
                hourlyRate = obj.getHourlyRate();
                rice = obj.getRiceSubsidy();
                phoneAllow = obj.getPhoneAllowance();
                clothing = obj.getClothingAllowance();
                break;
            }
            id = "";
        }


        if (Objects.equals(id, "")){
            System.out.println("No data found");
        }else{

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
//            System.out.print("Enter Employee Number: "+ attendances[2].getDate());

            Scanner s2 = new Scanner(System.in);
            System.out.print("Payroll Month(1-12):");
            month = s2.nextLine();

            for (Attendance obj : attendances) {
                if (obj != null){
                    if (Objects.equals(id, obj.getEmployeeID())){
                        if (Objects.equals(month.length(), 1)){
                            junkDate = obj.getDate().substring(1,2);
                        }else{
                            junkDate = obj.getDate().substring(0,2);
                        }

                        if (Objects.equals(month, junkDate)){
                            list.add(obj.getDate());
                            listTimeIn.add(obj.getTimeIn());
                            listTimeOut.add(obj.getTimeOut());
                        }
//                    list.add(obj.getDate()
                    }
                }
            }

            for (int i = 0; i < listTimeIn.size(); i++) {
                String timein = listTimeIn.get(i).replace(":",".");
                String timeout = listTimeOut.get(i).replace(":",".");

                double sum =   (Double.parseDouble(timeout)-Double.parseDouble(timein)-1);
                hoursWorked.add(sum);
            }
            for (Double i : hoursWorked)
                sumHoursWorked += i;

            salary = (hourlyRate * sumHoursWorked)+rice+phoneAllow+clothing;
            Month selectMonth = Month.of(Integer.parseInt(month));
            String monthName = selectMonth.toString();
            System.out.println("Pay Period: " +monthName);
            System.out.println("---------------------------------------------");
            System.out.println("ALLOWANCE" );
            System.out.println("Rice Subsidy: "+rice );
            System.out.println("Phone Allowance: " +phoneAllow);
            System.out.println("Clothing Allowance: "+ clothing);
            System.out.println("---------------------------------------------");
            System.out.println("DEDUCTIONS" );
            System.out.println("Pag-ibig: "+salaryDeductions.getPagibigDeduc(salary) );
            System.out.println("Philhealth: ");
            System.out.println("SSS: "+ salaryDeductions.getSSSdeduc(salary));
            System.out.println("Withholding Tax: " );
            System.out.println("---------------------------------------------");
            System.out.println("EARNINGS" );
            System.out.println("Hourly Rate: "+hourlyRate );
            System.out.println("Hours worked: " +sumHoursWorked);
            System.out.println("Days Worked: "+ list.size());
            System.out.println("Salary: " + (salary - salaryDeductions.getTotalDeductions(salary)));
            System.out.println("---------------------------------------------");
            System.out.println("date: " + list);
            System.out.println("Time in: " + listTimeIn);
            System.out.println("Time out: " + listTimeOut);
        }
    }
}