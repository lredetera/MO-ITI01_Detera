/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java;

/**
 *
 * @author EM
 */
public class EmployeeData extends EmployeeModel {
    
    public Employee[] employees;
    
    public EmployeeData()  {
        Employee employee1 = new Employee();
        employee1.setEmpID("7");
        employee1.setLastName("San Jose");
        employee1.setFirstName("Brad");
        employee1.setBirthday("03/15/1996");
        employee1.setStatus("Regular");
        employee1.setPosition("HR Team Leader");
        employee1.setImmediateSupervisor("Villanueva, Andrea Mae");
        employee1.setSss("40-2400714-1");
        employee1.setPhilhealth("239192926939");
        employee1.setTin("672-474-690-000");
        employee1.setPagIbig("210850209964");
        employee1.setBasicSalary(42975.00);
        employee1.setRiceSubsidy(1500.00);
        employee1.setPhoneAllowance(800.00);
        employee1.setClothingAllowance(800.00);
        employee1.setHourlyRate(255.80);

        Employee employee2 = new Employee();
        employee2.setEmpID("8");
        employee2.setLastName("Romualdez");
        employee2.setFirstName("Alice");
        employee2.setBirthday("05/14/1992");
        employee2.setStatus("Regular");
        employee2.setPosition("HR Rank and File");
        employee2.setImmediateSupervisor("San Jose, Brad");
        employee2.setSss("55-4476527-2");
        employee2.setPhilhealth("545652640232");
        employee2.setTin("888-572-294-000");
        employee2.setPagIbig("211385556888");
        employee2.setBasicSalary(22500.00);
        employee2.setRiceSubsidy(1500.00);
        employee2.setPhoneAllowance(800.00);
        employee2.setClothingAllowance(800.00);
        employee2.setHourlyRate(255.80);

        employees = new Employee[] { employee1, employee2 };
    }

    @Override
    public Employee[] getEmployeeDataList() {
        return employees;
    }
}


    
