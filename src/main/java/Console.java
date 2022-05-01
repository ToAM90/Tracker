import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Console {
    private PrintWriter out;
    private Scanner in;


    public Console(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public void printHeading(String text) {
        System.out.println("\n" + text);
        for (int i = 0; i < text.length(); i++) {
            System.out.print("-");

        }
        System.out.println();
    }

    public void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }
        out.println("\nPlease select an option >>> ");
        out.flush();
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);

        }
        return choice;
    }

    public Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        int userInput = 0;
        try {
            userInput = Integer.valueOf(in.nextLine());
            if (userInput <= options.length) {
                choice = options[userInput - 1];
            } else if (choice == null) {
                out.println("\n*** " + userInput + " is not a valid option ***\n");
            }
        } catch (NumberFormatException e) {
            out.println("\n*** " + userInput + " is not a valid option ***\n");
        }
        return choice;

    }

    public String readStr(String prompt) {
        String input = null;
        System.out.println(prompt);
        input = in.nextLine();
        return input;
    }

    public int readInt(String prompt) {
        int input = 0;
        System.out.println(prompt);
        try {
            input = Integer.parseInt(in.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Data");
        }
        return input;
    }

    public LocalDate enteringDateBlankIsNow(String prompt) {
        LocalDate date = LocalDate.now();
        boolean running = true;
        while (running) {
            try {
                System.out.println(prompt + "(Blank = today) (yyyy-mm-dd): ");
                String dateInput = in.nextLine();
                if (dateInput != null && !dateInput.isEmpty()) {
                    date = LocalDate.parse(dateInput);
                }
                running = false;
            } catch (Exception e) {
                System.out.println("Invalid format!");
            }
        } return date;

    }

    public LocalDate enteringDateBlankMinus7(String prompt) {
        LocalDate date = LocalDate.now();
        boolean running = true;
        while (running) {
            try {
                System.out.println(prompt + "(Blank = 7 days before today) (yyyy-mm-dd): ");
                String dateInput = in.nextLine();
                if (dateInput != null && !dateInput.isEmpty()) {
                    date = LocalDate.parse(dateInput);
                } else {
                    date = date.minusDays(7);
                    running = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid format!");
            }

        } return date;

    }
}
