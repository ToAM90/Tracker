
public class Menu {

    private String exit = "Exit";

    public String getExit() {
        return exit;
    }

    // MAIN MENU

    private final String mainMenu_trackWeight = "Track Weight";
    private final String mainMenu_trackWater = "Track Water";
    private final String[] MAIN_MENU_OPTIONS = new String [] {mainMenu_trackWeight, mainMenu_trackWater, exit};

    public String getMainMenu_trackWeight() {
        return mainMenu_trackWeight;
    }

    public String getMainMenu_trackWater() {
        return mainMenu_trackWater;
    }


    public String[] getMAIN_MENU_OPTIONS() {
        return MAIN_MENU_OPTIONS;
    }

    // WATER MENU

    private final String waterMenu_log = "Log water consumption";
    private final String waterMenu_report = "Run drinking reports";
    private final String [] WATER_MENU_OPTIONS = new String [] {waterMenu_log, waterMenu_report, exit};

    public String getWaterMenu_log() {
        return waterMenu_log;
    }

    public String getWaterMenu_report() {
        return waterMenu_report;
    }

    public String[] getWATER_MENU_OPTIONS() {
        return WATER_MENU_OPTIONS;
    }

    // WEIGHT MENU

    private final String weightMenu_log = "Log weight";
    private final String weightMenu_report = "Run weight reports";
    private final String[] WEIGHT_MENU_OPTIONS = new String[] {weightMenu_log, weightMenu_report, exit};

    public String getWeightMenu_log() {
        return weightMenu_log;
    }

    public String getWeightMenu_report() {
        return weightMenu_report;
    }

    public String[] getWEIGHT_MENU_OPTIONS() {
        return WEIGHT_MENU_OPTIONS;
    }
}

