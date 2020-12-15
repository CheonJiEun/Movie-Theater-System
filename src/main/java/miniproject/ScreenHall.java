package miniproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class ScreenHall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCREEN_HALL_ID")
	private Long id; // �󿵰� ��ȣ
	private String name; // �󿵰� �̸�
	private Integer totalSeats; // �󿵰� �� �¼���
	private Integer remainedSeats;
	
	@Lob
	private String description; // �󿵰� Ư�̻���

	@ManyToOne
	@JoinColumn(name = "THEATER_ID")
	private Theater theater;
	
	@OneToMany(mappedBy = "screenhall")
	private List<Seat> seats = new ArrayList<Seat>();
	
	// �󿵰� -- ������
	public ScreenHall() {
	}

	public ScreenHall(String name) {
		this.name = name;
	}

	// �󿵰� -- Getter, Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Integer getRemainedSeats() {
		return remainedSeats;
	}

	public void setRemainedSeats(List<Seat> seats) {
		this.remainedSeats = this.totalSeats - seats.size();
	}
	
	

}
