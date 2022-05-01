import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class WeightLog implements AuditLog {

    public void printToAuditLog(String name, LocalDate date, int weight) {
        File file = new File("weight_log.txt");
        PrintWriter writer = null;
        String message = "";

        try {

            if (file.exists()) {
                String newFile = "";

                Scanner sourceScanner = new Scanner(file.getAbsoluteFile());
                while (sourceScanner.hasNextLine()) {
                    String line = sourceScanner.nextLine();
                    String[] lineArr = line.split("\\,");

                    String fileName = lineArr[0];
                    String fileDate = lineArr[1];
                    LocalDate fileDateConverted = LocalDate.parse(fileDate);

                    if (fileDateConverted.isEqual(date) && fileName.equals(name)) {
                        line = (line.replace(line, name + "," + date + "," + weight));
                        newFile += line + "\n";

                    } else {
                        newFile += line + "\n";
                        newFile +=  name + "," + date + "," + weight;
                    }
                    message = newFile;
                }
                writer = new PrintWriter(new FileOutputStream(file.getAbsoluteFile(), false));

            } else {
                writer = new PrintWriter(file.getAbsoluteFile());
                message = name + "," + date + "," + weight;
            }
            writer.println(message);
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
