/*Individual Work for all: Java Program, Report and Sample Report*/
/* Name: Yeo Yi Xin
 * Student ID: 20414841
 */
import java.util.Scanner; /*import java.util library that contain Scanner class*/
import java.lang.NumberFormatException;/*import java.lang library that contain NumberFormatException class*/
public class display {
    private static int spotsid = 0;
    public static void repost(int id, String name, int spots, String spot_name){/*display the current output*/
        System.out.println("\n\033[1mYour current detail\033[0m"); /*skip a line and then print out the sentence in bold*/
        System.out.println("-----------"); /*decorating lines*/
        System.out.println("ID: " + id); /*print out the user id*/
        System.out.println("Name: " + name); /*print out user name*/
        System.out.println("Spot: " + spots);/*print out the location ID*/
        System.out.println("Name of spot: " + spot_name);/*Print out the name of the spot according to the location ID*/
    }/*end of repost method*/

    public static void mainmenu(int id){
        /*Header for main menu*/
        System.out.printf("\n%2s %22s %50s %19s\n", 
        "ID", "Accessible places", "Permitted waiting time (min)", "Maximum capacity");
        /*print if max capacity is reached and user do not want to wait and wants to see available location */
        if (id!=1){
        /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
        RestrictedSpots first = new icu(); 
        /*print details for Intensive care unit visiting area*/
        System.out.println(first.getid() + "\t" + first.getname() + "\t" + first.gettime() + "\t\t\t\t" + first.getcapacity());
        }
        if (id!=2){
        /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
        RestrictedSpots first = new out_mainwaiting(); 
        /*print details for out_mainwaiting visitors main area*/
        System.out.println(first.getid() + "\t" + first.getname() + "\t\t" + first.gettime() + "\t\t\t\t" + first.getcapacity());
        }
        if (id!=3){
        /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
        RestrictedSpots first= new out_subwaiting(); 
        /*print details for Out-patient visitors sub-waiting area*/
        System.out.println(first.getid() + "\t" + first.getname() + "\t" + first.gettime() + "\t\t\t\t" + first.getcapacity());
        }
        if (id!=4){
        /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
        RestrictedSpots first = new in_mainwaiting(); 
        /*print details for in_mainwaiting sub-waiting area*/
        System.out.println(first.getid() + "\t" + first.getname() + "\t" + first.gettime() + "\t\t\t\t" + first.getcapacity() + "\n");
        }
    }/*end of mainmenu method*/

    public static void main(String[] args){
        /*Creates a new instance of Scanner class from java.util library, and then assigned to a 
        variable named input which is then used to prompt user input*/
        Scanner input = new Scanner(System.in);
        mainmenu(spotsid); /*print main menu*/

        while (true){ /*registration process will be in infinite while loop if user enter 'y' or 'Y' when being prompted whether they ant to register at next venue*/
            System.out.println("\033[1mPut in your details\nUser input\033[0m"); /*print in bold*/
            System.out.println("----------"); /*decorating lines*/
            int userid; /*initialize variable userid with datatype int*/
            int repeat = spotsid;
            while (true) { /*infinite loop until user enters number-only input*/
                System.out.print("Your ID: ");  /*describe what user is supposed to enter*/
                String userID = input.nextLine(); /*reads the String entered by user*/
                try { /*If input is integer, the try block sets the userid variable and exits the loop using the break statement*/
                    userid = Integer.parseInt(userID);
                    break; /*Exit the loop if the input is valid*/
                } catch (NumberFormatException e) { /*If the input is not integer, the NumberFormatException is thrown and caught by the catch block.*/
                    System.out.println("\033[91;1mPlease enter number only\n \033[0m");  /*error message printed in red colour and the sentence is bold*/
                    /*The loop will continue to the next iteration if the input is invalid*/
                } /*end of try-catch statement*/
            }/*end of nested while loop*/
            System.out.print("Full Name: "); /*describe what user is supposed to enter*/
            String name = input.nextLine(); /*reads the String entered by user*/
            while (true) { /*infinite loop until user enters number-only input*/
                System.out.print("Where do you want to enter (according to the location ID as shown above): "); /*describe what user is supposed to enter*/
                String locationID = input.nextLine(); /*reads the String entered by user*/
                try {/*If input is integer, the try block sets the spotsid variable and exits the loop using the break statement*/
                    spotsid = Integer.parseInt(locationID);
                    break; /*Exit the loop if the input is valid*/
                } catch (NumberFormatException e) {/*If the input is not integer, the NumberFormatException is thrown and caught by the catch block.*/
                    System.out.println("\033[91;1mPlease enter number only\n\033[0m"); /*error message printed in red colour and the sentence is bold. Then skip a line.*/
                    /*The loop will continue to the next iteration if the input is invalid*/
                }/*end of try-catch statement*/
            }/*end of nested while loop*/
            while ((spotsid < 1) || (spotsid > 4) || (repeat==spotsid)){ /*while loop to get user input if user enter location id other than the provided ID which is up to 4*/
                if ((spotsid < 1) || (spotsid > 4)){
                    System.out.println("\033[91;1mPlease enter only the given location id!\n\033[0m"); /*error message printed in red colour and the sentence is bold. Then skip a line.*/
                }
                else{
                    System.out.println("\033[91;1mYou have applied for this location before\n\033[0m");
                }
                while (true) { /*infinite loop until user enters number-only input*/
                    System.out.println("Location ID:");  /*describe what user is supposed to enter*/
                    String locationID = input.nextLine(); /*reads the String entered by user*/
                    try {/*If input is integer, the try block sets the spotsid variable and exits the loop using the break statement*/
                        spotsid = Integer.parseInt(locationID);
                        break; /*Exit the loop if the input is valid*/
                    } catch (NumberFormatException e) {/*If the input is not integer, the NumberFormatException is thrown and caught by the catch block.*/
                        System.out.println("\033[91;1mPlease enter number only\n\033[0m"); /*error message printed in red colour and the sentence is bold. Then skip a line.*/
                        /*The loop will continue to the next iteration if the input is invalid*/
                    }/*end of try-catch statement*/
                }/*end of nested while loop*/
            }/*end of nested while loop*/

            StaticDistancing permission = new StaticDistancing(); /*Creates a new instance of StaticDistancing class, which is then assigned to a variable named permission of type StaticDistancing*/
            boolean entrance = permission.capacity(spotsid); /*check for current capacity by calling method from another class*/

            if (entrance == true){ /*if user is allowed to enter*/
                /*function call to check for contact status from other class and store it in variable contact which is from DynamicDistancing class which has datatype enum ContactStatus*/
                DynamicDistancing.ContactStatus contact = permission.socialdistancing();
                if (spotsid == 1){/*if user enter 1*/
                    /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
                    RestrictedSpots first = new icu();
                    repost(userid, name, spotsid, first.getname());/*Function call for repost with 4 arguments to print current details*/
                }else if (spotsid == 2){/*if user enter 2*/
                    /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                    RestrictedSpots first = new out_mainwaiting();
                    repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                }else if (spotsid == 3){/*if user enter 3*/
                    /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                    RestrictedSpots first = new out_subwaiting();
                    repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                }else{/*if user enter 4*/
                    /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                    RestrictedSpots first = new in_mainwaiting();
                    repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                }/*end if-else if-else statement for selected location id*/
                permission.time(spotsid);  /*check for current time by calling method from another class*/

                /*if the contact status after calling permission.socialdistancicng returns CLOSE or CASUAL*/
                if (contact == DynamicDistancing.ContactStatus.CLOSE || contact == DynamicDistancing.ContactStatus.CASUAL){ 
                    if (contact == DynamicDistancing.ContactStatus.CLOSE){/*if contact status is CLOSE*/
                        System.out.println("\033[0;31m");
                        System.out.println("Contact Status: " + contact);/*print contact status in red*/
                        System.out.println("\033[0m");
                    }
                    else{
                        System.out.println("\u001B[38;5;208m");
                        System.out.println("Contact Status: " + contact);/*print contact status in orange*/
                        System.out.println("\033[0m");
                    }/*end if-else statement for selected location id*/
                    System.out.println("Put 'Y' or 'y' as yes and other keys as no."); /*user's choice */
                    System.out.print("\nDid you move away from the person(s) who are close to you? "); /*print the question to ask if user has moved away*/
                    char choice = input.next().charAt(0);/*receive letter only*/
                    input.nextLine();/*receive newline character*/

                    if (choice == 'Y' || choice == 'y' ){/*enter if statement if user enter 'Y' or 'y' */
                        System.out.println("\nThank you! Please fill in the distance again to finalise you contact status. "); /*skip a line and print the statement*/
                        /*function call to check for contact status from other class and store it in variable contact which is from DynamicDistancing class which has datatype enum ContactStatus*/
                        contact = permission.socialdistancing();
                        if (spotsid == 1){/*if user enter 1*/
                            /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new icu();
                            repost(userid, name, spotsid, first.getname());/*Function call for repost with 4 arguments to print current details*/
                        }else if (spotsid == 2){/*if user enter 2*/
                            /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new out_mainwaiting();
                            repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                        }else if (spotsid == 3){/*if user enter 3*/
                            /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new out_subwaiting();
                            repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                        }else{/*if user enter 4*/
                            /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new in_mainwaiting();
                            repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                        }/*end if-else if-else statement for selected location id*/
                        permission.time(spotsid);/*function call to check for current time by calling method from another class*/
                        if (contact == DynamicDistancing.ContactStatus.CLOSE){/*if contact status is CLOSE*/
                            System.out.println("\033[0;31m");
                            System.out.println("Contact Status: " + contact);/*print contact status in red*/
                            System.out.println("\033[0m");
                        } else if (contact == DynamicDistancing.ContactStatus.CASUAL){
                            System.out.println("\u001B[38;5;208m");
                            System.out.println("Contact Status: " + contact);/*print contact status in orange*/
                            System.out.println("\033[0m");
                        } else{
                            System.out.println("\033[0;32m");
                            System.out.println("Contact Status: " + contact);/*print contact status in green*/
                            System.out.println("\033[0m");
                        }/*end if-else if-else statement for contact status*/
                    }
                    else{ /*Skip a line, then print out the lines telling user that they are currently not within the safe distance, and prompt to reenter distance*/
                        System.out.println("\nDo note that you are in are not within the 1m safe distancing rule."); 
                        System.out.println("You may be asked to leave the place by the guards at the spot.");
                        System.out.println("However, can you please fill in the distance again to finalise you contact status.");
                        System.out.println("To check if the surrounding people have moved.");
                        
                        /*function call to check for contact status from other class and store it in variable contact which is from DynamicDistancing class which has datatype enum ContactStatus*/
                        contact = permission.socialdistancing();
                        if (spotsid == 1){/*if user enter 1*/
                            /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new icu();
                            repost(userid, name, spotsid, first.getname());/*Function call for repost with 4 arguments to print current details*/
                        }else if (spotsid == 2){/*if user enter 2*/
                            /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new out_mainwaiting();
                            repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                        }else if (spotsid == 3){/*if user enter 3*/
                            /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new out_subwaiting();
                            repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                        }else{/*if user enter 4*/
                            /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                            RestrictedSpots first = new in_mainwaiting();
                            repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                        }/*end if-else if-else statement for selected location id*/

                        permission.time(spotsid);/*check for current time by calling method from another class*/

                        if (contact == DynamicDistancing.ContactStatus.CLOSE){/*if contact status is CLOSE*/
                            System.out.println("\033[0;31m");
                            System.out.println("Contact Status: " + contact);/*print contact status in red*/
                            System.out.println("\033[0m");
                        } else if (contact == DynamicDistancing.ContactStatus.CASUAL){
                            System.out.println("\u001B[38;5;208m");
                            System.out.println("Contact Status: " + contact);/*print contact status in orange*/
                            System.out.println("\033[0m");
                        } else{
                            System.out.println("\033[0;32m");
                            System.out.println("Contact Status: " + contact);/*print contact status in green*/
                            System.out.println("\033[0m");
                        }/*end if-else if-else statement for contact status*/
                    }/*end if-else for whether user moved or not from their current location*/
                } else{/*safe distance */
                    System.out.println("\033[0;32m");
                    System.out.println("Contact Status: " + contact); /*print contact status in green*/
                    System.out.println("\033[0m");
                }/*end if else for whether user contact status is close, casual or distancing*/

                System.out.println("Press 'Y'or 'y' to apply next venue and other key to stop: "); /*print the question to ask if user wants to register next venue*/
                char choice = input.next().charAt(0);/*receive letter only*/
                input.nextLine();/*receive newline character*/
                if (choice == 'Y' || choice == 'y' ){/*if user enter 'y' or 'Y' */
                    System.out.println(""); /*go to next line*/
                    mainmenu(spotsid);/*function call to main menu and user cannot enter the same spotsid*/
                    continue;/*continue the while loop from the start which is prompting for user ID*/
                }
                else{
                    System.out.println("Thank you!"); /*print the line*/
                    break; /*break out from the while loop*/
                }/*end if-else statement for whether user wants to continue registering for next venue or not*/
            }
            else{ /*not permitted entrance*/
                /*function call to check for current time from other class*/
                permission.waitingTime(spotsid);
                System.out.println("Press 'Y' or 'y' for yes and other keys for no. Would you be willing to wait? "); /* */
                char wait = input.next().charAt(0);
                input.nextLine();

                if (wait == 'y' || wait == 'Y'){ /*yes to waiting*/
                    /*assume that time has reached*/ 
                    System.out.println("\nYour waiting time is over! Thank you for being patient. You may go in now.");
                    /*function call to check for contact status from other class and store it in variable contact which is from DynamicDistancing class which has datatype enum ContactStatus*/
                    DynamicDistancing.ContactStatus contact = permission.socialdistancing();
                    if (spotsid == 1){/*if user enter 1*/
                        /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
                        RestrictedSpots first = new icu();
                        repost(userid, name, spotsid, first.getname());/*Function call for repost with 4 arguments to print current details*/
                    }else if (spotsid == 2){/*if user enter 2*/
                        /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                        RestrictedSpots first = new out_mainwaiting();
                        repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                    }else if (spotsid == 3){/*if user enter 3*/
                        /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                        RestrictedSpots first = new out_subwaiting();
                        repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                    }else{/*if user enter 4*/
                        /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                        RestrictedSpots first = new in_mainwaiting();
                        repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                    }/*end if-else if-else statement for selected location id*/
                    permission.estimatedtime(spotsid);  /*check for current time by calling method from another class*/

                    /*if the contact status after calling permission.socialdistancicng returns CLOSE or CASUAL*/
                    if (contact == DynamicDistancing.ContactStatus.CLOSE || contact == DynamicDistancing.ContactStatus.CASUAL){ 
                        if (contact == DynamicDistancing.ContactStatus.CLOSE){/*if contact status is CLOSE*/
                            System.out.println("\033[0;31m");
                            System.out.println("Contact Status: " + contact);/*print contact status in red*/
                            System.out.println("\033[0m");
                        }
                        else{
                            System.out.println("\u001B[38;5;208m");
                            System.out.println("Contact Status: " + contact);/*print contact status in orange*/
                            System.out.println("\033[0m");
                        }/*end if-else statement for selected location id*/
                        System.out.print("\nDid you move away from the person(s) who are close to you (Y/N)?"); /*print the question to ask if user has moved away*/
                        char choice = input.next().charAt(0);/*receive letter only*/
                        input.nextLine();/*receive newline character*/

                        if (choice == 'Y' || choice == 'y' ){/*enter if statement if user enter 'Y' or 'y' */
                            System.out.println("\nThank you! Please fill in the distance again to finalise you contact status. "); /*skip a line and print the statement*/
                            /*function call to check for contact status from other class and store it in variable contact which is from DynamicDistancing class which has datatype enum ContactStatus*/
                            contact = permission.socialdistancing();
                            if (spotsid == 1){/*if user enter 1*/
                                /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new icu();
                                repost(userid, name, spotsid, first.getname());/*Function call for repost with 4 arguments to print current details*/
                            }else if (spotsid == 2){/*if user enter 2*/
                                /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new out_mainwaiting();
                                repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                            }else if (spotsid == 3){/*if user enter 3*/
                                /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new out_subwaiting();
                                repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                            }else{/*if user enter 4*/
                                /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new in_mainwaiting();
                                repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                            }/*end if-else if-else statement for selected location id*/
                            permission.estimatedtime(spotsid);/*function call to check for current time by calling method from another class*/
                            if (contact == DynamicDistancing.ContactStatus.CLOSE){/*if contact status is CLOSE*/
                                System.out.println("\033[0;31m");
                                System.out.println("Contact Status: " + contact);/*print contact status in red*/
                                System.out.println("\033[0m");
                            } else if (contact == DynamicDistancing.ContactStatus.CASUAL){
                                System.out.println("\u001B[38;5;208m");
                                System.out.println("Contact Status: " + contact);/*print contact status in orange*/
                                System.out.println("\033[0m");
                            } else{
                                System.out.println("\033[0;32m");
                                System.out.println("Contact Status: " + contact);/*print contact status in green*/
                                System.out.println("\033[0m");
                            }/*end if-else if-else statement for contact status*/
                        }
                        else{
                            /*Skip a line, then print out the lines telling user that they are currently not within the safe distance, and prompt to reenter distance*/
                            System.out.println("\nDo note that you are in are not within the 1m safe distancing rule.");
                            System.out.println("You may be asked to leave the place by the guards at the spot.");
                            System.out.println("However, can you please fill in the distance again to finalise you contact status.");
                            System.out.println("To check if the surrounding people have moved.");
                            
                            /*function call to check for contact status from other class and store it in variable contact which is from DynamicDistancing class which has datatype enum ContactStatus*/
                            contact = permission.socialdistancing();
                            if (spotsid == 1){/*if user enter 1*/
                                /*Creates a new instance of the icu class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new icu();
                                repost(userid, name, spotsid, first.getname());/*Function call for repost with 4 arguments to print current details*/
                            }else if (spotsid == 2){/*if user enter 2*/
                                /*Creates a new instance of the out_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new out_mainwaiting();
                                repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                            }else if (spotsid == 3){/*if user enter 3*/
                                /*Creates a new instance of the out_subwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new out_subwaiting();
                                repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                            }else{/*if user enter 4*/
                                /*Creates a new instance of the in_mainwaiting class, which is then assigned to a variable named first of type RestrictedSpots*/
                                RestrictedSpots first = new in_mainwaiting();
                                repost(userid, name, spotsid, first.getname()); /*Function call for repost with 4 arguments to print current details*/
                            }/*end if-else if-else statement for selected location id*/

                            permission.estimatedtime(spotsid);/*check for current time by calling method from another class*/

                            if (contact == DynamicDistancing.ContactStatus.CLOSE){/*if contact status is CLOSE*/
                                System.out.println("\033[0;31m");
                                System.out.println("Contact Status: " + contact);/*print contact status in red*/
                                System.out.println("\033[0m");
                            } else if (contact == DynamicDistancing.ContactStatus.CASUAL){
                                System.out.println("\u001B[38;5;208m");
                                System.out.println("Contact Status: " + contact);/*print contact status in orange*/
                                System.out.println("\033[0m");
                            } else{
                                System.out.println("\033[0;32m");
                                System.out.println("Contact Status: " + contact);/*print contact status in green*/
                                System.out.println("\033[0m");
                            }/*end nested if-else if-else statement for contact status*/
                        }/*end nested if-else for whether user moved or not from their current location*/
                    } else{/*safe distance */
                        System.out.println("\033[0;32m");
                        System.out.println("Contact Status: " + contact); /*print contact status in green*/
                        System.out.println("\033[0m");
                    }/*end nested if else for whether user contact status is close, casual or distancing*/
                    
                    System.out.println("Press 'Y'or 'y' to apply next venue and other key to stop: "); /*print the question to ask if user wants to register next venue*/
                    char choice = input.next().charAt(0);/*receive letter only*/
                    input.nextLine();/*receive newline character*/
                    if (choice == 'Y' || choice == 'y' ){/*if user enter 'y' or 'Y' */
                        System.out.println(""); /*go to next line*/
                        mainmenu(0);/*function call to print main menu*/
                        continue;/*continue the while loop from the start which is prompting for user ID*/
                    }
                    else{
                        System.out.println("Thank you!"); /*print the line*/
                        break; /*break out from the while loop*/
                    }/*end nested if-else statement for whether user wants to continue registering for next venue or not*/
                }/*yes to waiting*/
                else{/*no to waiting*/
                    System.out.println("\nPress 'Y'or 'y' to apply next venue and other key to stop: "); /*print the question to ask if user wants to register next venue*/
                    char choice = input.next().charAt(0);/*receive letter only*/
                    input.nextLine();/*receive newline character*/
                    if (choice == 'Y' || choice == 'y' ){/*if user enter 'y' or 'Y' */
                        System.out.printf("\n\033[4m\nDo you want to try to re-apply to the same location again?\n\033[24m\n"); /*go to next line*/
                        System.out.println("Press 'Y'or 'y' for Yes and other key as No if you do not want to apply to the same location.");
                        char choice1 = input.next().charAt(0);/*receive letter only*/
                        input.nextLine();/*receive newline character*/
                        if (choice1 == 'Y' || choice1 == 'y' ){/*if user enter 'y' or 'Y' */
                            System.out.println("Alright, thank you for the confirmation. Request will be processed.\nYou may now attempt to reapply to the same location");
                            spotsid = 0; /*set spotsid back to 0 */
                            mainmenu(spotsid);
                            continue;/*continue the while loop from the start which is prompting for user ID*/
                        }
                        else{
                            System.out.println("\nPress 'Y'or 'y' for Yes and other key as No if you want to check where is available other than the spots you applied for.");
                            char decision = input.next().charAt(0);/*receive letter only*/
                            input.nextLine();/*receive newline character*/
                            if (decision == 'Y' || decision == 'y' ){/*if user enter 'y' or 'Y' */
                                System.out.println("\n\033[1mAvailable spots:\033[0m"); /*print in bold*/
                                mainmenu(spotsid);/*function call to print main menu*/
                                continue;/*continue the while loop from the start which is prompting for user ID*/
                            }
                            else{
                                mainmenu(0);
                                continue;
                            }/*end nested if-else statement for whether user wants to continue registering for next venue or not*/
                        }/*end of nested if-else statement for whether user wants to reapply to the same location*/
                    }
                    else{
                        System.out.println("Thank you!"); /*print the line*/
                        break; /*break out from the while loop*/
                    }/*end if-else statement for whether user wants to continue registering for next venue or not*/
                }/*no to waiting*/
            }/*end if-else for permitted or non-permitted entrance*/
        }/*end if for allowed entrance */

        /*checks whether the Scanner object named input is not null and, 
        if it is not null, calls its close() method to release any system resources associated with it */
        if (input!=null){ 
            input.close();
        }
    }/*end of main method*/
}/*end of display class*/