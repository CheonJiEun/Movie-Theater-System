package miniproject;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class Type {
	static Integer 성인 = 9000;
	static Integer 청소년 = 8000;
	static Integer 어린이 = 6000;
}

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			Manager manager = new Manager();
			manager.setName("관리자");
			manager.setPassword("12345");
			manager.setPhoneNumber("010-1234-5678");
			manager.setWorkPeriod(new Period(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1)));
			Boolean MisWork = manager.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Manager isWork : "+ MisWork);
			em.persist(manager);
			
			Account Maccount = new Account("농협","32141235432",100000);
			Maccount.setUser(manager);
			em.persist(Maccount);
			
			
			
			Staff staff = new Staff();
			staff.setName("직원");
			staff.setPassword("54321");
			staff.setPhoneNumber("010-1111-1111");
			staff.setWorkPeriod(new Period(LocalDate.of(2020, 12, 1), LocalDate.of(2020, 12, 31)));
			Boolean SisWork = staff.getWorkPeriod().isWork(LocalDate.now());
			System.out.println("==== Staff isWork : "+ SisWork);
			em.persist(staff);
			
			Account Saccount1 = new Account("국민","454132454355",100000);
			Saccount1.setUser(staff);
			em.persist(Saccount1);
			
			
			
			//if (MisWork && SisWork)
			Client client = new Client();
			client.setRpn("991125-*******");
			client.setEmail("wldms01125@kumoh.ac.kr");
			client.setName("천지은");
			client.setPassword("5781");
			client.setPhoneNumber("010-8645-1131");
			em.persist(client);
			
			Account Caccount1 = new Account("카카오페이","78544521354",100000);
			Caccount1.setUser(client);
			em.persist(Caccount1);
			
			
			Reservation reservation1 = new Reservation(Type.성인);
			reservation1.setUser(client);
			em.persist(reservation1);
			Reservation reservation2 = new Reservation(Type.청소년);
			reservation2.setUser(client);
			em.persist(reservation2);
			
			
			System.out.println("==== reservation count : "+client.getReservation().size());
			
			System.out.println("======: "+client.pay());
			
			Billing billing = new Billing("구미영화관", client.pay());
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