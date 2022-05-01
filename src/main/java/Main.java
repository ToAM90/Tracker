import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private final Menu menu;
    private final Console console;
    private final WeightLog weightLog;
    private final WaterLog waterLog;

    public Main() {
        this.menu = new Menu();
        this.console = new Console(System.in, System.out);
        this.weightLog = new WeightLog();
        this.waterLog = new WaterLog();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private void run() {
        while (true) {
            console.printHeading("Main Menu");
            String choice = (String) console.getChoiceFromOptions(menu.getMAIN_MENU_OPTIONS());
            if (choice.equals(menu.getMainMenu_trackWater())) {
                waterMenu();
            } else if (choice.equals(menu.getMainMenu_trackWeight())) {
                weightMenu();
            } else if (choice.equals(menu.getExit())) {
                break;
            }
        }
    }

    private void waterMenu() {
        while (true) {
            console.printHeading("Water Menu");
            System.out.println("What would you like to do?");
            String choice = (String) console.getChoiceFromOptions(menu.getWATER_MENU_OPTIONS());
            if (choice.equals(menu.getWaterMenu_log())) {
                String name = console.readStr("Enter the name of the person reporting in: ");
                LocalDate date = console.enteringDateBlankIsNow("Enter the date of consumption");
                int ounces = console.readInt("How much water did they drink (ounces)? ");
                System.out.println(ounces + " oz has been logged for " + name + " on " + date);
                waterLog.printToAuditLog(name, date, ounces);
            } else if (choice.equals(menu.getWaterMenu_report())) {
                String name = console.readStr("Enter the name to retrieve report for: ");

                waterReport(name);
            } else if (choice.equals(menu.getExit())) {
                break;
            }
        }
    }

    private void waterReport(String name) {
        File waterLog = new File("water_log.txt");
        System.out.println("\n");
        System.out.println(name);
        System.out.println("--------------------");
        System.out.printf("%-10s %-10s\n", "Date", "Ounces");
        System.out.printf("%-10s %-10s\n", "----------", "----------");
        try (Scanner waterScanner = new Scanner(waterLog)) {
            while (waterScanner.hasNextLine()) {
                String line = waterScanner.nextLine();
                String[] lineArr = line.split("\\,");

                String fileName = lineArr[0];
                String date = lineArr[1];
                String ounces = lineArr[2];
                if (fileName.equals(name)) {
                    System.out.printf("%-10s %-10s\n", date, ounces + " ounces");
                }
            }
        } catch (Exception e) {
        }
        System.out.println("\n");
    }

    private void weightMenu() {
        while (true) {
            console.printHeading("Weight Menu");
            System.out.println("What would you like to do?");
            String choice = (String) console.getChoiceFromOptions(menu.getWEIGHT_MENU_OPTIONS());
            if (choice.equals(menu.getWeightMenu_log())) {
                console.printHeading("Weigh In");
                String name = console.readStr("Enter the name of the person weighing in: ");
                LocalDate date = console.enteringDateBlankIsNow("Enter the date of the weigh in");
                int weight = console.readInt("Enter the weight (in pounds)? ");
                System.out.println(weight + " lbs has been logged for " + name + " on " + date);

                weightLog.printToAuditLog(name, date, weight);

            } else if (choice.equals(menu.getWeightMenu_report())) {
                console.printHeading("Reports");
                String name = console.readStr("Enter the name of the person for the report:");
                LocalDate startDate = console.enteringDateBlankMinus7("Start date");
                LocalDate endDate = console.enteringDateBlankIsNow("End date");

                weightReport(name, startDate, endDate);

            } else if (choice.equals(menu.getExit())) {
                break;
            }
        }
    }

    private void weightReport(String name, LocalDate startDate, LocalDate endDate) {
        File weightReport = new File("weight_log.txt");
        System.out.println("\n");
        System.out.println(name);
        System.out.println("--------------------");
        System.out.printf("%-10s %-10s\n", "Date", "Weight");
        System.out.printf("%-10s %-10s\n", "----------", "----------");
        try (Scanner weightScanner = new Scanner(weightReport)) {
            while (weightScanner.hasNextLine()) {
                String line = weightScanner.nextLine();
                String[] lineArr = line.split("\\,");

                String fileName = lineArr[0];
                String fileDate = lineArr[1];
                String weight = lineArr[2];
                LocalDate fileDateConverted = LocalDate.parse(fileDate);
                if (fileName.equals(name) && fileDateConverted.compareTo(startDate) >= 0 && fileDateConverted.compareTo(endDate) <= 0) {
                    System.out.printf("%-10s %-10s\n", fileDate, weight + "lbs");
                }
            }
        } catch (Exception e) {

        }
        System.out.println("\n");
    }


}
