/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EM
 */
public class EmployeeDataFromFile extends EmployeeModel {

    //    public static void main(String[] args) {
//        EmployeeModelFromFile emp = new EmployeeModelFromFile();
//    }
    public EmployeeDataFromFile() {
        String textFile = "C:\\opt\\Java\\MotorPHEmployeeDataTextTile.txt";
        employees = new Employee[34];
        getDataFromFile(textFile);

    }

    @Override
    public Employee[] getEmployeeDataList() {
        return employees;
    }

    private void getDataFromFile(String textFile) {
        try {
            Scanner scannerToGetFile = new Scanner(new File(textFile));
            int counter = 0;
            while (scannerToGetFile.hasNextLine()) {
                String data = scannerToGetFile.nextLine();
                Scanner scannerForParsing = new Scanner(data);
                parseDataFromScanner(scannerForParsing, counter);
                counter++;
            }
            scannerToGetFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeDataFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void parseDataFromScanner(Scanner scanner, int counter) {
        scanner.useDelimiter("[|]");
        while (scanner.hasNext()) {
            Employee employee = new Employee();
            employee.setEmpID(scanner.next());
            employee.setLastName(scanner.next());
            employee.setFirstName(scanner.next());
            employee.setBirthday(scanner.next());
            employee.setAddress(scanner.next());
            employee.setPhoneNumber(scanner.next());
            employee.setSss(scanner.next());
            employee.setPhilhealth(scanner.next());
            employee.setTin(scanner.next());
            employee.setPagIbig(scanner.next());
            employee.setStatus(scanner.next());
            employee.setPosition(scanner.next());
            employee.setImmediateSupervisor(scanner.next());
            employee.setBasicSalary(Double.parseDouble(scanner.next()));
            employee.setRiceSubsidy(Double.parseDouble(scanner.next()));
            employee.setPhoneAllowance(Double.parseDouble(scanner.next()));
            employee.setClothingAllowance(Double.parseDouble(scanner.next()));
            employee.setGrossSemiMonthlyRate(Double.parseDouble(scanner.next()));
            employee.setHourlyRate(Double.parseDouble(scanner.next()));
            employees[counter] = employee;
//            System.out.println(employees[counter].getEmpNo() + ", " + employees[counter].getLastName());
        }
        scanner.close();
    }

}
