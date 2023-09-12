public class DynamicDistancing {
    public enum ContactStatus{ /*Declare an enumeration of contact statuses: CLOSE, DISTANCING, and CASUAL*/
        CLOSE,
        DISTANCING,
        CASUAL
    }
    
    /*Declare private variables to hold distances in four directions and the contact status*/
    private ContactStatus contactStatus;
    private double front;
    private double back;
    private double left;
    private double right;

    public DynamicDistancing(){ /* Constructor with default distance values and DISTANCING status*/
        front = 0.0;
        back = 0.0;
        left = 0.0;
        right = 0.0;
        contactStatus = ContactStatus.DISTANCING;
    }

    public DynamicDistancing(double front, double back, double left, double right){ /*Constructor with provided distance values and DISTANCING status*/
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        contactStatus = ContactStatus.DISTANCING;
    }
    public void setDistance (double front, double back, double left, double right){/*Method to set distance values and check distance status*/
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;
        checkDistance();
    }

    /*line 38 to 57 consist of getter methods for distance values and contact status */
    public double getFront(){
        return front;
    }

    public double getBack(){
        return back;
    }
    
    public double getLeft(){
        return left;
    }

    public double getRight(){
        return right;
    }

    public ContactStatus getContactStatus(){
        return contactStatus;
    }

    public void checkDistance() { /* Method to check distance values and set contact status accordingly*/
        int j = 0; /*Initialize a counter for the number of sides with close contact*/

        /*Check each distance value and increment the counter if it's between 0 and 1*/
        if (front >= 0 && front < 1.0){
            j += 1;
        }
        if (back >= 0 && back < 1.0){
            j += 1;
        }
        if (left >= 0 && left < 1.0){
            j += 1;
        }
        if (right >= 0 && right < 1.0){
            j += 1;
        }
        
        /*If any distance value is too close, print a message to move away from the nearby person(s)*/
        if (front >= 0 && front < 1.0){
            double move = 1.0 - front;
            System.out.printf("\n\033[43mPlease move %.2fm from the person(s) at the front of you.\033[0m\n", move);
        }
        if (back >= 0 && back < 1.0){
            double move = 1.0 - back;
            System.out.printf("\n\033[43mPlease move %.2fm from the person(s) at the back of you.\033[0m\n", move);
        }
        if (left >= 0 && left < 1.0){
            double move = 1.0 - left;
            System.out.printf("\n\033[43mPlease move %.2fm from the person(s) to the left of you.\033[0m\n", move);
        }
        if (right >= 0 && right < 1.0){
            double move = 1.0 - right;
            System.out.printf("\n\033[43mPlease move %.2fm from the person(s) to the right of you.\033[0m\n", move);
        }

        /*check if there are none, one or more than one person from the 4 sides which are close to user */
        if (j>1){ /*if more than one are close to user, set it to CLOSE for contactStatus */
            System.out.println("\nThere are people from more than one side who are close to you.");
            System.out.println("\nYou are in a restricted area with close contact risk."); 
            contactStatus = ContactStatus.CLOSE;
        }
        else if (j == 1){/*if one person is close to user, set it to CASUAL for contactStatus */
            System.out.println("One side");
            contactStatus = ContactStatus.CASUAL;
        }
        else{/*if no one is close to user, set it to DISTANCING for contactStatus */
            contactStatus = ContactStatus.DISTANCING;
        }
    }
}
