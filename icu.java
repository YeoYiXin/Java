public class icu extends RestrictedSpots{ /*icu is a subclass of RestrictedSpots */
    /*Declare private variables to hold the information of the spot*/
    private int id;
    private String name;
    private int time;
    private int capacity;

    public icu(){
        id = 1; /*location id */
        name = "Intensive care unit visiting area"; /*Spot name */
        time = 30; /*allowed visiting duration*/
        capacity = 4; /*assume the place is 40m^2 big */
    }
    
    /*getid(), getname(), gettime(), and getcapacity(), are required because icu extends abstract class RestrictedSpots.
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
