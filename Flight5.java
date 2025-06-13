public class Flight5 {
    //declarative statements
	private int id ;
	private String airline ;
	private String source ;
	private String destination ;
	private float fare ;
	private float duration ;
	//Argument constructor 
	public Flight5(int id, String airline, String source, String destination, float fare, float duration) {
		super();
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
		Flight5 flight5 = new Flight5(1001, "AirIndia", "Bengaluru", "Delhi", 6900.5f, 5.15f);
		System.out.println("Flight details initialized by the User");
		System.out.println(flight5.id);
		System.out.println(flight5.airline);
		System.out.println(flight5.source);
		System.out.println(flight5.destination);
		System.out.println(flight5.fare);
		System.out.println(flight5.duration);
	}
}
