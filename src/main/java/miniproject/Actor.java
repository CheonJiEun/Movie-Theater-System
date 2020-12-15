package miniproject;

import javax.persistence.*;

@Entity
public class Actor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTOR_ID")
	private Long id; // 배우 아이디
	private String name; // 배우 이름
	
	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	private Movie movie;

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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
