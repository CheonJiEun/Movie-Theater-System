package miniproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "THEATER_ID")
	private Long id; // ��ȭ�� ��ȣ
	private String name; // ��ȭ�� �̸�

	private LocalDate closedDay; // ��ȭ�� �޹���

	private Integer TotalStaff; // ��ȭ�� ���� ��
	private Integer TotalAmounts; // ��ȭ�� ����

	@OneToMany(mappedBy = "theater")
	private List<ScreenHall> screenhalls = new ArrayList<ScreenHall>();

	// ��ȭ�� -- ������
	public Theater() {
		super();
	}

	// ��ȭ�� -- getter, setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getClosedDay() {
		return closedDay;
	}

	public void setClosedDay(LocalDate closedDay) {
		this.closedDay = closedDay;
	}

	public Integer getTotalStaff() {
		return TotalStaff;
	}

	public void setTotalStaff(Integer totalStaff) {
		TotalStaff = totalStaff;
	}

	public Integer getTotalAmounts() {
		return TotalAmounts;
	}

	public void setTotalAmounts(Integer totalAmounts) {
		TotalAmounts = totalAmounts;
	}

	public List<ScreenHall> getScreenhalls() {
		return screenhalls;
	}

	public void setScreenhalls(List<ScreenHall> screenhalls) {
		this.screenhalls = screenhalls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
