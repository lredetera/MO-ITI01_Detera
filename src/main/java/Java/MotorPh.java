/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Java;

import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author EM
 */
public class MotorPh {
    private static EmployeeModel employeeModel;

public static void main(String[] args) {
    employeeModel = new EmployeeData();

        System.out.println("        **MOTORPH PAYROLL SYSTEM**     ");
        System.out.println("---------------------------------------------");
        System.out.println("");
        
        int x;
        int inpt1;
        int inpt2;

        String str = "";
        Employee employee ;
        //instantiation
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter Employee Number: ");
        //        x=s.nextInt();
        str=s.nextLine();


        Employee[] employeeList = employeeModel.getEmployeeDataList();
        System.out.println("---------------------------------------------");
        String name = "";
        for (Employee obj : employeeList) {
            name = obj.getEmpId();

            if (Objects.equals(obj.getEmpId(), str)){
                name = obj.getEmpId();
                break;
            }
            name = "";
        }

        if (Objects.equals(name, "")){
            System.out.println("No data found");
        }else{
            System.out.println("Employee ID: " + name);
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
//                // Scanner s3 = new Scanner(System.in);
//
//
//                        // System.out.print("Payroll Month(1-12):");
//                        // x = s2.nextInt();
//                        // System.out.print("March 2022");
//
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