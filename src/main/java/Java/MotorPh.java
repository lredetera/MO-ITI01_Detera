/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Java;

import java.util.Scanner;
/**
 *
 * @author EM
 */
public class MotorPh {

public static void main(String[] args) {
        System.out.println("        **MOTORPH PAYROLL SYSTEM**     ");
        System.out.println("---------------------------------------------");
        System.out.println("");
        
        int x;
        String str = "";
        //instantiation 
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter Employee Number: ");
        x=s.nextInt();
        
        EmployeeData employeeData = new EmployeeData();
         
        Employee[] employeeList = employeeData.getEmployeeDataList();
        System.out.println("---------------------------------------------");
        
        for (int i = 0; i < employeeList.length; i++) {
            
                      
            Employee employee = employeeList[i];
            
            if (str == employee.getEmpId()){
        
        }
            
            System.out.println("Employee ID: " + employee.getEmpId());
            System.out.println("Full Name: " + employee.getLastName()+ " "+ employee.getFirstName());
            System.out.println("Birthday: " + employee.getBirthDay());
            System.out.println("Employment Status: " + employee.getStatus());
            System.out.println("---------------------------------------------");
            
            System.out.println("SSS: " + employee.getSssNum());
            System.out.println("TIN: " + employee.getTinNum());
            System.out.println("Philhealth: " + employee.getPhilHealthNum());
            System.out.println("Pag-ibig: " + employee.getPagibigNum());
            System.out.println("---------------------------------------------");
         
            
            
            
        Scanner s2 = new Scanner(System.in);
        
        System.out.print("Payroll Month(1-12):");
        x=s2.nextInt();

    }
}
}