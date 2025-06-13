public class Flight extends Object{
    //Here Flight is a pojo class (Plain Old Java Object)
    //https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
    //Here flight is the real world entity
    //id, airline, source, destination, fare, duration
    //these are instance variables
    //declarative statements
    private int id;
    private String airline;
    private String source;
    private String destination;
    private float fare;
    private float duration;
    //source menu ->generate->select all (in eclipse) for constructors
    //source menu ->generate->getter and setter (in eclipse)
    //source menu ->generate->hashcode(in eclipse)
    public Flight(String airline, String destination, float duration, float fare, int id, String source) {
        this.airline = airline;
        this.destination = destination;
        this.duration = duration;
        this.fare = fare;
        this.id = id;
        this.source = source;
    }

    public Flight(String airline) {
        this.airline = airline;
    }

    public Flight(float duration) {
        this.duration = duration;
    }

    public Flight(int id) {
        this.id = id;
        
    }
    public Flight() {
        //default constructor
        super(); // it goes to object class constructor
        System.out.println("Default constructor called");
        System.out.println("id= "+id);
        this.id=101;
        System.out.println(id);
    }

//source menu ->generate->getter and setter (in eclipse)
//functions having void are setters having one arg and return one value
//all getter values have zero args 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
//source menu ->generate->hashcode(in eclipse)
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((airline == null) ? 0 : airline.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + Float.floatToIntBits(fare);
        result = prime * result + Float.floatToIntBits(duration);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        if (id != other.id)
            return false;
        if (airline == null) {
            if (other.airline != null)
                return false;
        } else if (!airline.equals(other.airline))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (Float.floatToIntBits(fare) != Float.floatToIntBits(other.fare))
            return false;
        return true;
    }
    public static void main(String[] args) {
        Flight flight = new Flight();
        //created 4 reference variables -flight,airline,source,destination
        //1 object-flight
        //Flight - class name  , flight - reference variable
        System.out.println(flight.id);
        System.out.println(flight.airline);
        System.out.println(flight.source);
        System.out.println(flight.destination);
        System.out.println(flight.fare);
        System.out.println(flight.duration); 
    }

}
