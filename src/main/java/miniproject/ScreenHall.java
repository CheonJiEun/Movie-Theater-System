package miniproject;

import javax.persistence.*;

@Entity
public class ScreenHall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCREEN_HALL_ID")
	private Long id; // �󿵰� ��ȣ
	private String name; // �󿵰� �̸�
	private Integer totalSeats; // �󿵰� �� �¼���

	@Lob
	private String description; // �󿵰� Ư�̻���

	@ManyToOne
	@JoinColumn(name = "THEATER_ID")
	private Theater theater;

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

}