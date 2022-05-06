# Weight and Water Tracker

My second side project that I made to gain more practice in writing codes, keeping in mind consistency and preventing tight coupling as much as possible. 


### Part One: Tracking Water Intake

Water is the source of life, and yet for some it is difficult to drink enough water every day. This CLI is intended to allow a user to enter the how much water they drink each day, and store the data in a .csv file.

A user should also be able to run a report to see how much water they drank on a given day.

The application should write to a single .txt file (e.g. WaterData.txt).

Prompt the user if they wish to log a drink, or run a report.

    What would you like to do?
    
    1) Log water consumption
    2) Run drinking reports
    3) Exit
  
    Please select an option: 

If the user chooses to log water consumption they should be prompted for data.

    Enter the date of consumption (Blank = today): 2022-03-19
    How much water did you drink (ounces)? 64

    64 oz has been logged for 2022-03-19

The report should display 1 row for each date, and include a total amount of water that was consumed on that date.

    Date            Water Consumption
    ----------      -----------------
    2022-03-18      80 oz
    2022-03-19      68 oz
    ...

All data that is input by the user should be written to the WaterData.txt file so that the data is available for reporting in the future.

    WaterData.txt
  
    2022-03-18,32
    2022-03-18,32
    2022-03-18,16
    2022-03-19,64
    2022-03-19,4

### Part Two: Tracking Weight Loss/Gain

Whether your goal is to lose weight or to gain it, you will want to track your progress. This CLI will allow a user to enter a the name of a person, their weight, and date of the weigh in.

A user should also be able to run a report to see the progress of a person over time.

The application should write to a single .txt file (e.g. WeightTracker.txt).

Prompt the user if they wish to log a weigh in, or run a report.

    What would you like to do?
    1) Log weight
    2) Reports
    3) Exit

     Please select an option: 

If the user chooses to log weight they should be prompted for data.

    Weigh in
    ----------------------------------------------
    Enter the name of the person weighing in: Gary
    Enter the date of the weigh in (Blank = today): 2022-03-19
    Enter the weight (in pounds)? 172

172 lbs has been logged for Gary on 2022-03-19
If a weight is entered for a date that already has a weight tracked, the weight should be ***overwriten***.

When running a report a the user should specify the name of the person for whom the report should be run. They should also specify a date range for which the report whould be run.

    Report
    -------------------------------------------------
    Enter the name of the person for the report: Gary
    Start date (Blank = 7 days before today): 2022-03-13
    End date (Blank = today): 2022-03-19

The report should display 1 row for each date, and include a total amount of water that was consumed on that date.

    Name: Gary
    ---------------------------------
    Date            Weight
    ----------      -----------------
    2022-03-13      175 lbs
    2022-03-14      174 lbs
    2022-03-15      175 lbs
    ...

All data that is input by the user should be written to the WeightTracker.txt file so that the data is available for reporting in the future.

    WeightTracker.txt
   
    Gary,2022-03-12,176
    Marin,2022-03-12,111
    Gary,2022-03-13,175
    Marin,2022-03-13,111


> Special Thanks to https://github.com/gdzierzon/devzengarden for this little project! 
