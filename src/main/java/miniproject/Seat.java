package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEAT_ID")
	private Long id;

	@OneToMany(mappedBy = "seat")
	private List<ReservationSeat> rs = new ArrayList<ReservationSeat>();
	
	@ManyToOne
	@JoinColumn(name = "SCREEN_HALL_ID")
	private ScreenHall screenhall;

	private String name;

	public Seat(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ReservationSeat> getRs() {
		return rs;
	}

	public void setRs(List<ReservationSeat> rs) {
		this.rs = rs;
	}

	public ScreenHall getScreenhall() {
		return screenhall;
	}

	public void setScreenhall(ScreenHall screenhall) {
		this.screenhall = screenhall;
	}
	
	

}
