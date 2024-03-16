/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author EM
 */
public class MotorPh {
    private static EmployeeModel employeeModel;
    private static AttendanceModel attendanceModel;


    public static void main(String[] args) {
//    employeeModel = new EmployeeData();
//        employeeModel = new EmployeeDataFromFile();

        attendanceModel = new AttendanceData();
        employeeModel = new EmployeeDataFromFile();

        Employee[] employeeList = employeeModel.getEmployeeDataList();
        Attendance[] attendances = attendanceModel.getAttendanceModelList();

        List<String> list=new ArrayList<String>();
        List<String> listTimeIn=new ArrayList<String>();
        List<String> listTimeOut=new ArrayList<String>();
        String junkDate = "";


        System.out.println("        **MOTORPH PAYROLL SYSTEM**     ");
        System.out.println("---------------------------------------------");
        String str = "";
        System.out.println("---------------------------------------------");
        String id = "";
        String name = "", bday = "", status= "",position= "",supervisor= "",sssNum= "",
                philHealth= "",tin= "",pagIbig= "",basicSalary= "",rice= "",phoneAllow= "",clothing= "";
        String date = "";
        String month = "";

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

            Scanner s2 = new Scanner(System.in);
            System.out.print("Payroll Month(1-12):");
            month = s2.nextLine();

            for (Attendance obj : attendances) {
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
            System.out.println("date: " + list);
            System.out.println("Time in: " + listTimeIn);
            System.out.println("Time out: " + listTimeOut);

        }

//        for (int i = 0; i < employeeList.length; i++) {
//            employee = employeeList[i];
//            if (Objects.equals(str, employee.getEmpId())) {
//                System.out.println("Employee ID: " + employee.getEmpId());
//                System.out.println("Full Name: " + employee.getLastName() + " " +
//                        employee.getFirstName());
//                System.out.println("Birthday: " + employee.getBirthDay());
//                System.out.println("Employment Status: " + employee.getStatus());
//                System.out.println("---------------------------------------------");
//
//                System.out.println("SSS: " + employee.getSssNum());
//                System.out.println("TIN: " + employee.getTinNum());
//                System.out.println("Philhealth: " + employee.getPhilHealthNum());
//                System.out.println("Pag-ibig: " + employee.getPagibigNum());
//                System.out.println("---------------------------------------------");
//
//                // Scanner s2 = new Scanner(System.in);
//                 Scanner s3 = new Scanner(System.in);
//
//
//                         System.out.print("Payroll Month(1-12):");
//                         x = s2.nextInt();
//                         System.out.print("March 2022");

//                        // get time int and time out
//                        // deduct time out and time in and 1 hour lunch break
//                        // loop in dates and add the hours worked
//                        // this is hours worked
//
//
//                        // System.out.println("---------------------------------------------");
//                        // System.out.println("EARNINGS" );
//                        // System.out.println("Hourly Rate: 200" );
//                        // System.out.println("Hours worked: 25.8" );
//                        // System.out.println("Days Worked: 20");
//                        // System.out.println("Overtime: 120" );
//                        // System.out.println("---------------------------------------------");
//                        // System.out.println("ALLOWANCE" );
//                        // System.out.println("Hourly Rate: 200" );
//                        // System.out.println("Hours worked: 25.8" );
//                        // System.out.println("Days Worked: 20");
//                        // System.out.println("Overtime: 120" );
//                        // System.out.println("---------------------------------------------");
//                        // System.out.println("DEDUCTIONS" );
//                        // System.out.println("Hourly Rate: 200" );
//                        // System.out.println("Hours worked: 25.8" );
//                        // System.out.println("Days Worked: 20");
//                        // System.out.println("TOTAL" );
//                        // System.out.println("---------------------------------------------");
//                        // System.out.println("SUMMARY" );
//                        // System.out.println("GROSS INCOME:" );
//                        // System.out.println("TOTAL BENEFITS" );
//                        // System.out.println("TOTAL DEDUCTIONS");
//                        // System.out.println("TAKE HOME PAY" );
//                        // System.out.println("---------------------------------------------");
//                        //
//
//                        break;
//                    } else {
//                        System.out.println("No data found");
////                                break;
//                    }
//
//        }
    }
}