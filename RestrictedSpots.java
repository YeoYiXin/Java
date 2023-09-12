public abstract class RestrictedSpots { /*superclass of icu, out_mainwaiting, out_subwaiting, in_mainwaiting */
    /*Abstract keyword indicates that RestrictedSpots cannot be instantiated directly and must be subclassed. */
    public RestrictedSpots(){ /*does not take in argument, just a constructor for RestrictedSpots */
        ;
    }

    /*non-abstract subclass of RestrictedSpots must implemented on these method because it does not have a body and is 'abstract'*/
    public abstract int getid(); 

    public abstract String getname();

    public abstract int gettime();

    public abstract int getcapacity();
  
}/*end of RestrictedSpots class */
