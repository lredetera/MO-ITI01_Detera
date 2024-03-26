package Java;

public class AttendanceData extends AttendanceModel {
    public Attendance[] attendances;

    public AttendanceData() {
        Attendance attendance1 = new Attendance();
        attendance1.setEmployeeID("7");
        attendance1.setDate("01/09/2022");
        attendance1.setTimeIn("8:00");
        attendance1.setTimeOut("17:00");

        Attendance attendance2 = new Attendance();
        attendance2.setEmployeeID("7");
        attendance2.setDate("01/19/2022");
        attendance2.setTimeIn("8:00");
        attendance2.setTimeOut("17:00");

        Attendance attendance3 = new Attendance();
        attendance3.setEmployeeID("8");
        attendance3.setDate("01/19/2022");
        attendance3.setTimeIn("8:00");
        attendance3.setTimeOut("17:00");

        attendances = new Attendance[] { attendance1,attendance2,attendance3 };
    }

    @Override
    public  Attendance[] getAttendanceModelList(){
        return attendances;
    }

}


//employees = new Employee[] { employee1, employee2 };
//        }
//
//@Override
//public Employee[] getEmployeeDataList() {
//    return employees;
//}