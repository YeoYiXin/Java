public class out_subwaiting extends RestrictedSpots{/*out_subwaiting is a subclass of RestrictedSpots */
    /*Declare private variables to hold the information of the spot*/
    private int id;
    private String name;
    private int time;
    private int capacity;

    public out_subwaiting(){
        id = 3; /*location id */
        name = "Out-patient visitors sub-waiting area"; /*Spot name */
        time = 30; /*allowed visiting duration*/
        capacity = 10; /*assume the place is 80m^2 big */
    }

    /*getid(), getname(), gettime(), and getcapacity(), are required because out_subwaiting extends abstract class RestrictedSpots.
    Each method returns the corresponding instance variable. For example, getid() returns the value of id*/
    public int getid(){
        return id;
    }

    public String getname(){
        return name;
    }

    public int gettime(){
        return time;
    }

    public int getcapacity(){
        return capacity;
    }
}
