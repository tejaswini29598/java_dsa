//Argument constructor program

public class Flight3{
//declarative statements
	private int id ;
	private String airline ;
	private String source ;
	private String destination ;
	private float fare ;
	private float duration ;
	//Argument constructor 
	public Flight3(int id, String airline, String source, String destination, float fare, float duration) {
		super();
		//in eclipse we use this() instead of super() to pass control to the zero argument program
		/*System.out.println("From the All Arg Cons");
		System.out.println(id);
		System.out.println(airline);
		System.out.println(source);
		System.out.println(this.destination);
		System.out.println(this.fare);
		System.out.println(this.duration);
		System.out.println("----------------------------");
		*/
		this.id = id;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.duration = duration;

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

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", source=" + source + ", destination=" + destination
				+ ", fare=" + fare + ", duration=" + duration + "]";
	}

	
	
	
	public static void main(String[] args) {
		Flight3 flight3 = new Flight3(1001, "AirIndia", "Bengaluru", "Delhi", 6900.5f, 3.15f);
		System.out.println("Flight details initialized by the User");
		//created 4 reference variables -flight2,airline,source,destination
        //1 object-flight2
		System.out.println(flight3.id);
		System.out.println(flight3.airline);
		System.out.println(flight3.source);
		System.out.println(flight3.destination);
		System.out.println(flight3.fare);
		System.out.println(flight3.duration);
	}
}


