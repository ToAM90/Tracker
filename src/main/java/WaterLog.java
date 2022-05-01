import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;

public class WaterLog implements AuditLog{


    public void printToAuditLog(String name, LocalDate date, int ounces) {
        File file = new File("water_log.txt");
        PrintWriter writer = null;
        String message = name + "," + date + "," + ounces;
        try {
            if (file.exists()) {
                writer = new PrintWriter(new FileOutputStream(file.getAbsoluteFile(), true));
            } else {
                writer = new PrintWriter(file.getAbsoluteFile());
            }
            writer.append(message);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file.");
        }
    }
}
