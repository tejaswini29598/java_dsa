//Zero argument constructor program
public class Flight2 extends Object {
	//declarative statements
	private int id;
	private String airline ;
	private String source ;
	private String destination ;
	private float fare ;
	private float duration ;
	
//zero argument constructor
	public Flight2(){

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
		Flight2 flight2 = new Flight2();
		//created 4 reference variables -flight2,airline,source,destination
        //1 object-flight2
		System.out.println("Flight details initialized by the User");
		System.out.println(flight2.id);
		System.out.println(flight2.airline);
		System.out.println(flight2.source);
		System.out.println(flight2.destination);
		System.out.println(flight2.fare);
		System.out.println(flight2.duration);
	}
}

