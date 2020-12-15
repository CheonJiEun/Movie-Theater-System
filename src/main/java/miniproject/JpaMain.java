package miniproject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class Type {
	static Integer ���� = 9000;
	static Integer û�ҳ� = 8000;
	static Integer ��� = 6000;
}

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Theater-System");
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			// ��ȭ��
			Theater theater1 = new Theater();
			theater1.setClosedDay(LocalDate.of(2020, 12, 25));
			theater1.setTotalAmounts(100000);
			
			theater1.setName("���̿�ȭ��");
			em.persist(theater1);
			
			// �󿵰�
			List<ScreenHall> screenhalls = new ArrayList<ScreenHall>();
			ScreenHall screenhall1 = new ScreenHall();
			screenhall1.setDescription("����");
			screenhall1.setName("���̿�ȭ��");
			screenhall1.setTotalSeats(100);
			screenhall1.setTheater(theater1);
//			System.out.println("��ȭ�� �̸� !!!!!!"+ screenhall1.getTheater().getName());

			screenhalls.add(screenhall1);
			em.persist(screenhall1);
			
			Movie movie1 = new Movie();
			movie1.setName("��Ʈ��");
			movie1.setLimitAge(12);
			movie1.setDirector("�� ī�纣��");
			movie1.setOpenDay(LocalDate.of(2020, 11, 04));
			movie1.setRunTime(LocalTime.of(2, 23));
			movie1.setStory("�θǽ�");
			em.persist(movie1);
			
			List<Actor> actors = new ArrayList<Actor>();
			Actor actor1 = new Actor();
			actor1.setName("���̾� ����");
			actor1.setMovie(movie1);
			Actor actor2 = new Actor();
			actor2.setName("����ÿ �ƾƴ㽺");
			actor2.setMovie(movie1);
			actors.add(actor1);
			actors.add(actor2);
			movie1.setActors(actors);
			em.persist(actor1);
			em.persist(actor2);
			
			List<MovieSchedule> mss = new ArrayList<MovieSchedule>();
			
			MovieSchedule ms1 = new MovieSchedule();
			ms1.setMovie(movie1);
			ms1.setStartTime(LocalTime.of(16, 0));
			ms1.setEndTime(LocalTime.of(18, 30));
			ms1.setScreehall(screenhall1);
			mss.add(ms1);
			em.persist(ms1);
			
			Manager manager = new Manager();
			manager.setName("������");
			manager.setPassword("12345");
			manager.setPhoneNumber("010-1234-5678");
			manager.setWorkPeriod(new Period(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1)));
			Boolean MisWork = manager.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Manager isWork : "+ MisWork);
			em.persist(manager);
			
			Account Maccount = new Account("����","32141235432",100000);
			Maccount.setUser(manager);
			em.persist(Maccount);
			
			
			List<Staff> staffs = new ArrayList<Staff>();
			Staff staff = new Staff();
			staff.setName("����");
			staff.setPassword("54321");
			staff.setPhoneNumber("010-1111-1111");
			staff.setWorkPeriod(new Period(LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 31)));
			staff.setTheater(theater1);
			staffs.add(staff);
			Boolean SisWork = staff.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Staff isWork : "+ SisWork);
			
			theater1.setTotalStaff(staffs);
			System.out.println("���ܼ� !!!!!!!!" + theater1.getTotalStaff());
			em.persist(staff);
			
			Account Saccount1 = new Account("����","454132454355",100000);
			Saccount1.setUser(staff);
			em.persist(Saccount1);
			
			
			
			//if (MisWork && SisWork)
			Client client = new Client();
			client.setRpn("991125-*******");
			client.setEmail("wldms01125@kumoh.ac.kr");
			client.setName("õ����");
			client.setPassword("5781");
			client.setPhoneNumber("010-8645-1131");
			em.persist(client);
			
			Account Caccount1 = new Account("īī������","78544521354",100000);
			Caccount1.setUser(client);
			em.persist(Caccount1);
						

			
			ReservationSeat rs1 = new ReservationSeat();
			List<Seat> seats = new ArrayList<Seat>();
			
			Seat seat1 = new Seat("C10");
			seat1.setScreenhall(screenhall1);
			seats.add(seat1);
			rs1.setSeat(seat1);
			
			ReservationSeat rs2 = new ReservationSeat();
			Seat seat2 = new Seat("C11");
			seat2.setScreenhall(screenhall1);
			seats.add(seat2);
			rs2.setSeat(seat2);
			em.persist(rs1);
			em.persist(rs2);
			em.persist(seat1);
			em.persist(seat2);
			
			System.out.println("�¼���!!!!!!!!!!!!!!!!!!!!!!!: " + seats.size());
			
			screenhall1.setRemainedSeats(seats);
			System.out.println("�����¼� !!!!!!"+ screenhall1.getRemainedSeats());

			
			System.out.println("====== seat: "+seat1.getRs().size());
			
			Reservation reservation1 = new Reservation(Type.����);
			reservation1.setUser(client);
			reservation1.setMovieshedules(mss);
			rs1.setReservation(reservation1);
			em.persist(reservation1);
			Reservation reservation2 = new Reservation(Type.û�ҳ�);
			reservation2.setUser(client);
			reservation2.setMovieshedules(mss);
			rs2.setReservation(reservation2);
			em.persist(reservation2);
			
			System.out.println("==== reservation count : "+client.getReservation().size());
			
			System.out.println("======: "+client.pay());
			
			Billing billing = new Billing("���̿�ȭ��", client.pay());
			billing.setAccount(Caccount1);
			billing.check();
			reservation1.setBilling(billing);
			reservation2.setBilling(billing);
			em.persist(billing);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}