package miniproject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID")
	private Long id; // ��ȭ ��ȣ

	private String name; // ��ȭ �̸�
	private String director; // ����
	private String story; // �ٰŸ�
	private Integer limitAge; // ���� ����

	@OneToMany(mappedBy = "movie")
	private List<Actor> actors = new ArrayList<Actor>();

	private LocalDate openDay; // ������
	private LocalTime runTime; // �� �ð�

	private Integer totalAudience;

	// ����, ����
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Integer getLimitAge() {
		return limitAge;
	}

	public void setLimitAge(Integer limitAge) {
		this.limitAge = limitAge;
	}

	public LocalDate getOpenDay() {
		return openDay;
	}

	public void setOpenDay(LocalDate openDay) {
		this.openDay = openDay;
	}

	public LocalTime getRunTime() {
		return runTime;
	}

	public void setRunTime(LocalTime runTime) {
		this.runTime = runTime;
	}

	public Integer getTotalAudience() {
		return totalAudience;
	}

	public void setTotalAudience(Integer totalAudience) {
		this.totalAudience = totalAudience;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
