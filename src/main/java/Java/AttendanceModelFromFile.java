package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AttendanceModelFromFile extends AttendanceModel {
    public AttendanceModelFromFile() {
        String textFile = "C:\\opt\\Java\\MO-ITI01_Detera\\model\\AttendanceTextTile.txt";
        attendances = new Attendance[2176];
        getatDataFromFile(textFile);
    }

    @Override
    public Attendance[] getAttendanceModelList() {
        return attendances;
    }

    private void getatDataFromFile(String textFile) {
        try {
            Scanner scannerToGetFile = new Scanner(new File(textFile));
            int counter = 0;
            while (scannerToGetFile.hasNextLine()) {
                String data = scannerToGetFile.nextLine();
                Scanner scannerForParsing = new Scanner(data);
                parseData(scannerForParsing, counter);
                counter++;
            }
            scannerToGetFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeDataFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void parseData(Scanner scanner, int counter) {
        scanner.useDelimiter("[|]");
        while (scanner.hasNext()) {
            Attendance attendance = new Attendance();
            attendance.setEmployeeID(scanner.next());
            attendance.setLastName(scanner.next());
            attendance.setFirstName(scanner.next());
            attendance.setDate(scanner.next());
            attendance.setTimeIn(scanner.next());
            attendance.setTimeOut(scanner.next());
            attendances[counter] = attendance;
            // System.out.println(employees[counter].getEmpNo() + ", " +
            // employees[counter].getLastName());
        }
        scanner.close();
    }
}
