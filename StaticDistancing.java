import java.util.*; /*import all class in java.util library and used for Scanner, Date and Calendar*/
import java.text.SimpleDateFormat; /*import all class in java.text library and used for SimpleDateFormat */
public class StaticDistancing {
    public static boolean enquiry(Scanner input, String question){
        /*this method is a restriction so that user can only answer either Y or N (and the lowercase of the letters) to know whether 
         * there is someone in the direction of the user that is being prompted. It will then return the boolean value*/
        do { /*user will be prompted for response until user enter 'y', 'n', 'N' or 'Y'*/
            System.out.print(question + " (y/n): ");
            char response = input.next().charAt(0);/*receive letter only*/
            input.nextLine();/*receive newline character*/
            if (response == 'y' || response == 'Y') {/*returns true if user response is == yes */
                return true;
            } else if (response == 'n' || response == 'N') {/*returns false if user response is == no */
                return false;
            } else {
                System.out.println("\033[91;1mInvalid response. Please enter y or n.\n\033[0m"); /*error message printed in red colour and the sentence is bold. Then skip a line.*/
            }/*end nested if-else if-else statement for checking user response*/
        }while (true);/*end while loop*/
    }/*end of enquiry method */

    private static double distance(Scanner input, String direction, String question, boolean personExists){
        /*this method is to check if there is a person exist in the direction. If no, returns 1.0 (to disregard this direction) and print the line.
         * If yes, then prompt user for distance and check if distance is > 0. If yes then return the input distance, if not, return 1.0*/
        if (!personExists) {
            System.out.println("No person detected to the " + direction + ".");
            return 1.0;
        }/*end if statement for checking if a person is in the direction*/
    
        double distance; /*initialise distance as double*/
        while (true) { /*infinite loop until user enters number-only input*/
            System.out.print(question + " (m) eg, 1.0 = ");
            String checkdistance = input.nextLine(); /*reads the String entered by user*/
            try { /*If input is double, the try block sets the check distance variable and exits the loop using the break keyword*/
                distance = Double.parseDouble(checkdistance);
                break; /*Exit the loop if the input is valid*/
            } catch (NumberFormatException e) { /*If the input is not double, the NumberFormatException is thrown and caught by the catch block.*/
                System.out.println("\033[91;1mPlease enter number only\n\033[0m");  /*error message printed in red colour and the sentence is bold*/
                /*The loop will continue to the next iteration if the input is invalid*/
            } /*end of try-catch statement*/
        }/*end of while loop*/
        return distance >= 0.0 ? distance : 1.0; /*conditional operator to check the distance*/
    }/*end of distance method */

    public DynamicDistancing.ContactStatus socialdistancing(){
        /*this method is to ask user for whether there is someone in the particular direction. After that, it will call class DynamicDistancing
         * to check the distance and then check the contact status*/
        Scanner input = new Scanner(System.in);/*Creates a new instance of Scanner class from java.util library, and then assigned to a 
        variable named input which is then used to prompt user input*/

        System.out.println("\n\nPlease make sure the distance of you from another person is always \033[1m1m\033[0m apart.");/*bold the distance part*/
        System.out.println("----------------------------------------------------------------------------");

        /*all the below code from line 49 to line 59 shows the answer and question being asked by user is used as arguments to call enquiry and is 
         * stored in the variable. The variable, including the question and user input will then be the argument to call distance and store in 
         * a variable*/
        boolean hasFront = enquiry(input, "Is there a person in front of you?");
        double front = distance(input, "front", "What is the distance between you and the person in front", hasFront);

        boolean hasBack = enquiry(input, "\nIs there a person at the back of you?");
        double back = distance(input, "back", "What is the distance between you and the person at the back", hasBack);

        boolean hasLeft = enquiry(input, "\nIs there a person to the left of you?");
        double left = distance(input, "left", "What is the distance between you and the person at the left", hasLeft);

        boolean hasRight = enquiry(input, "\nIs there a person to the right of you?");
        double right = distance(input, "right", "What is the distance between you and the person at the right", hasRight);

        /*Creates a new instance of the DynamicDistancing class, which is then assigned to a variable named distance of type DynamicDistancing,
         * which has four arguments which are the distance obtained from user input*/
        DynamicDistancing distance = new DynamicDistancing(front, back, left, right);
        distance.checkDistance(); /*check for whether user is in safe distance*/
        /*function call to check for contact status from other class and store it in variable contactStatus which is from DynamicDistancing class with datatype enum ContactStatus*/
        DynamicDistancing.ContactStatus contactStatus = distance.getContactStatus();
        return contactStatus; /*return contact status*/
    }/*end of socialdistancing method*/


    public void time(int id){ /*printing out time and date*/
        Calendar calendar = Calendar.getInstance(); /*Creates a new instance of the Calendar class and initializes it to the current date and time*/
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss"); /*Creates a new instance of the SimpleDateFormat class for formatting time*/
        Date current_time = new Date(); /*Gets the current time using the Date class*/
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy"); /*Creates a new instance of the SimpleDateFormat class for formatting date*/
        Date current_date = new Date(); /*Gets the current date using the Date class*/

        switch(id){
            case 1: {
                RestrictedSpots place1 = new icu(); /*Creates a new instance of the icu class, which is then assigned to a variable named place1 of type RestrictedSpots*/
                calendar.add(Calendar.MINUTE, place1.gettime());/*Adds the value of the "gettime" method of the "place1" object to the "calendar" object*/
                Date due_time = calendar.getTime(); /*Gets the due time by calling the "getTime" method of the "calendar" object*/
                /*Prints the allowed time range and current date to the console*/
                System.out.println("Allowed Time: " + time.format(current_time) + " to " + time.format(due_time)); 
                System.out.println("Date: " + date.format(current_date)); break; /*Breaks out of the switch statement*/
            }/*end case 1*/
            case 2: {
                RestrictedSpots place1 = new out_mainwaiting();/*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                calendar.add(Calendar.MINUTE, place1.gettime());
                Date due_time = calendar.getTime();
                System.out.println("Allowed Time: " + time.format(current_time) + " to " + time.format(due_time)); 
                System.out.println("Date: " + date.format(current_date)); break;
            }/*end case 2*/
            case 3: {
                RestrictedSpots place1 = new out_subwaiting(); /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                calendar.add(Calendar.MINUTE, place1.gettime());
                Date due_time = calendar.getTime();
                System.out.println("Allowed Time: " + time.format(current_time) + " to " + time.format(due_time)); 
                System.out.println("Date: " + date.format(current_date)); break;
            }/*end case 3*/
            case 4: {
                RestrictedSpots place1 = new in_mainwaiting();/*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                calendar.add(Calendar.MINUTE, place1.gettime());
                Date due_time = calendar.getTime();
                System.out.println("Allowed Time: " + time.format(current_time) + " to " + time.format(due_time)); 
                System.out.println("Date: " + date.format(current_date)); break;
            }/*end case 4*/
        }/*end of switch statement for place*/
    }/*end of time method*/

    public void waitingTime(int id){ /*waiting time */
        Calendar calendar = Calendar.getInstance(); /*Creates a new instance of the Calendar class and initializes it to the current date and time*/
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss"); /*Creates a new instance of the SimpleDateFormat class for formatting time*/
        calendar.add(Calendar.MINUTE, 30);/*add 30 minute to the current time in minute*/
        Date due_time = calendar.getTime();/*Gets the due time by calling the "getTime" method of the "calendar" object*/
        switch(id){
            case 1: {
                RestrictedSpots place1 = new icu();/*Creates a new instance of the icu class, which is then assigned to a variable named place1 of type RestrictedSpots*/
                calendar.add(Calendar.MINUTE, place1.gettime()); /*Adds the value of the "gettime" method of the "place1" object to the "calendar" object*/
                /*Prints the average waiting time and user estimated time to the console*/
                System.out.println("Average waiting time (minutes): " + place1.gettime());
                System.out.println("Your turn (estimated): " + time.format(due_time)); break;
            }/*end case 1*/
            case 2: {
                RestrictedSpots place1 = new out_mainwaiting();
                calendar.add(Calendar.MINUTE, place1.gettime());
                System.out.println("Average waiting time (minutes): " + place1.gettime());
                System.out.println("Your turn (estimated): " + time.format(due_time)); break;
            }/*end case 2*/
            case 3: {
                RestrictedSpots place1 = new out_subwaiting();
                calendar.add(Calendar.MINUTE, place1.gettime());
                System.out.println("Average waiting time (minutes): " + place1.gettime());
                System.out.println("Your turn (estimated): " + time.format(due_time)); break;
            }/*end case 3*/
            case 4: {
                RestrictedSpots place1 = new in_mainwaiting();
                calendar.add(Calendar.MINUTE, place1.gettime());
                System.out.println("Average waiting time (minutes): " + place1.gettime());
                System.out.println("Your turn (estimated): " + time.format(due_time)); break;
            }/*end case 4*/
        }/*end of switch statement for place*/
    }/*end of waitingTime method*/

    public void estimatedtime(int id){ /*if user okay with waiting, and waiting time reached */
        Calendar calendar = Calendar.getInstance();/*Creates a new instance of the Calendar class and initializes it to the current date and time*/
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss"); /*Creates a new instance of the SimpleDateFormat class for formatting time*/
        switch(id){
            case 1: {
                // Set calendar instance to current time plus 30 minutes
                calendar.add(Calendar.MINUTE, 30);
                Date start_time = calendar.getTime();

                // Set calendar instance to current time plus 60 minutes
                calendar.add(Calendar.MINUTE, 30);
                Date due_time = calendar.getTime();
                System.out.println("Allowed Time: " + time.format(start_time) + " to " + time.format(due_time));break;
            }/*end case 1*/
            case 2: {
                calendar.add(Calendar.MINUTE, 30);
                Date start_time = calendar.getTime();

                calendar.add(Calendar.MINUTE, 30);
                Date due_time = calendar.getTime();
                System.out.println("Allowed Time: " + time.format(start_time) + " to " + time.format(due_time));break;
            }/*end case 2*/
            case 3: {
               calendar.add(Calendar.MINUTE, 30);
               Date start_time = calendar.getTime();

               calendar.add(Calendar.MINUTE, 30);
               Date due_time = calendar.getTime();
               System.out.println("Allowed Time: " + time.format(start_time) + " to " + time.format(due_time));break;
            }/*end case 3*/
            case 4: {
                calendar.add(Calendar.MINUTE, 30);
                Date start_time = calendar.getTime();

                calendar.add(Calendar.MINUTE, 30);
                Date due_time = calendar.getTime();
                System.out.println("Allowed Time: " + time.format(start_time) + " to " + time.format(due_time));break;
            }/*end case 4*/
        }/*end of switch statement */
    } /*end of estimatedTime method*/

    public Boolean capacity(int id){
        Random rand = new Random(); /*creates a new instance of the Random class and assigns it to the variable rand*/
        Boolean permission = true; /*set default value to be true and store in permission */
        switch (id){
            case 1:{
                RestrictedSpots place = new icu();/*Creates a new instance of the icu class, which is then assigned to a variable named place of type RestrictedSpots*/
                int currentcapacity = rand.nextInt(place.getcapacity()); /*get a random int between 0 and the max capacity set, which in this case is 4.*/
                /*print the max capacity set and number generated by random class */
                System.out.println("Maximum number of visitor allowed: " + place.getcapacity()); 
                System.out.println("Current number of visitor: " + currentcapacity);
                if (currentcapacity >= place.getcapacity()){ /*if random value generated is more than or equal tomaximum capacity*/
                    System.out.println("\n\033[4;41mMaximum visitor capacity has reached\033[0m"); /*print in red highlight and underlined */
                    permission = false; /*set permission to false */
                }else{ /*if random value generated is less than maximum capacity */
                    int spaceleft = currentcapacity + 1;/*add current user to the current capacity and store in spaceleft*/
                    System.out.println("\n\033[44;4mYou may enter\033[0m"); /*print in light blue highlight and underlined */
                    System.out.println("Current number of visitor (including you): " + spaceleft); /*print out current visitor including user */
                } break; /*end if-else to check if maximum capacity is reached*/
            }/*end case 1*/
            case 2:{
                RestrictedSpots place = new out_mainwaiting();
                int currentcapacity = rand.nextInt(place.getcapacity());
                System.out.println("Maximum number of visitor allowed: " + place.getcapacity());
                System.out.println("Current number of visitor: " + currentcapacity);
                if (currentcapacity >= place.getcapacity()){
                    System.out.println("\n\033[4;41mMaximum visitor capacity has reached\033[0m"); /*print in red highlight and underlined */
                    permission = false;
                }else{
                    int spaceleft = currentcapacity + 1;
                    System.out.println("\n\033[44;4mYou may enter\033[0m"); /*print in light blue highlight and underlined */
                    System.out.println("Current number of visitor (including you): " + spaceleft);
                } break;/*end if-else to check if maximum capacity is reached*/
            }/*end case 2*/
            case 3:{
                RestrictedSpots place = new out_subwaiting();
                int currentcapacity = rand.nextInt(place.getcapacity());
                System.out.println("Maximum number of visitor allowed: " + place.getcapacity());
                System.out.println("Current number of visitor: " + currentcapacity);
                if (currentcapacity >= place.getcapacity()){
                    System.out.println("\n\033[4;41mMaximum visitor capacity has reached\033[0m"); /*print in red highlight and underlined */
                    permission = false;
                }else{
                    int spaceleft = currentcapacity + 1;
                    System.out.println("\n\033[44;4mYou may enter\033[0m"); /*print in light blue highlight and underlined */
                    System.out.println("Current number of visitor (including you): " + spaceleft);
                } break;/*end if-else to check if maximum capacity is reached*/
            }/*end case 3*/
            case 4:{
                RestrictedSpots place = new in_mainwaiting();
                int currentcapacity = rand.nextInt(place.getcapacity());
                System.out.println("Maximum number of visitor allowed: " + place.getcapacity());
                System.out.println("Current number of visitor: " + currentcapacity);
                if (currentcapacity >= place.getcapacity()){
                    System.out.println("\n\033[4;41mMaximum visitor capacity has reached\033[0m"); /*print in red highlight and underlined */
                    permission = false;
                }else{
                    int spaceleft = currentcapacity + 1;
                    System.out.println("\n\033[44;4mmYou may enter\033[0m"); /*print in light blue highlight and underlined */
                    System.out.println("Current number of visitor (including you): " + spaceleft);
                } break;/*end if-else to check if maximum capacity is reached*/
            }/*end case 4*/
        }/*end switch statement for placeid */
        return permission; /*return boolean value in permission */
    }/*end of capacity method*/
}/*end of StaticDistancing class*/