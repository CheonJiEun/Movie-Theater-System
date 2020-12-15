package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Seat {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SEAT_ID")
	private Long id;
	
	@OneToMany(mappedBy = "seat")
	private List<ReservationSeat> rs = new ArrayList<ReservationSeat>();

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

	
	
}
