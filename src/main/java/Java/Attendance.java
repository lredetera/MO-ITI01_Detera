package Java;

import java.util.Date;

public class Attendance {
    private String employeeID;
    private String lastName;
    private String firstName;
    private String date;
    private String timeIn;
    private String timeOut;

    public String getEmployeeID() { return employeeID; }
    public void setEmployeeID(String value) { this.employeeID = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getDate() { return date; }
    public void setDate(String value) { this.date = value; }

    public String getTimeIn() { return timeIn; }
    public void setTimeIn(String value) { this.timeIn = value; }

    public String getTimeOut() { return timeOut; }
    public void setTimeOut(String value) { this.timeOut = value; }
}