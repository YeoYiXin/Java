public class out_mainwaiting extends RestrictedSpots{/*out_mainwaiting is a subclass of RestrictedSpots */
    /*Declare private variables to hold the information of the spot*/
    private int id;
    private String name;
    private int time;
    private int capacity;

    public out_mainwaiting(){
        id = 2; /*location id */
        name = "Out-patient visitors main area"; /*Spot name */
        time = 30; /*allowed visiting duration*/
        capacity = 10; /*assume the place is 80m^2 big*/
    }

    /*getid(), getname(), gettime(), and getcapacity(), are required because out_mainwaiting extends abstract class RestrictedSpots.
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
