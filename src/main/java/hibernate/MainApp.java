package hibernate;

import hibernate.model.Alamat;
import hibernate.model.Departement;
import java.sql.Timestamp;

import org.hibernate.Session;
import hibernate.util.HibernateUtil;

import hibernate.model.Employee;
import hibernate.model.Kecamatan;
import hibernate.model.Student;
import hibernate.model.Task;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApp {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String result = getNativeQuery(session, "select version()");
        System.out.println(result);

//        List<Student> listdept = getStudent(session);
//        for (Student student : listdept) {
//            System.out.println(student.getIdEntry() + student.getTglEntry() + "alamat" + student.getAlamat().getNama());
//
//        }
//        List<Kecamatan> lisdtkec = getKecamatan(session);
//        for (Kecamatan kecamatan : lisdtkec) {
//            System.out.println(kecamatan.getNama() + "alamat" + kecamatan.getAlamat().getNama());
//        }
//        List<Alamat> listal = getAlamat(session);
//        for (Alamat alamat : listal) {
//            System.out.println(alamat.getNama() + "kecamatan" + alamat.getKecamatan().getNama());
//
//        }
        Set<Employee> listPegTask =  getListPegawaiDanTask( session);//
		for (Employee employee : listPegTask) {
			Set<Task> listTugas = employee.getListTugas();
			System.out.println(employee.getNama()+"  id " +employee.getId());
			for (Task task : listTugas) {
				System.out.println( "  tugas "+task.getNamaTugas());
			}
		}
        
        


          
        simpanPegawai(session);

//		updatePegawai(session);
//		updatePegawaiDua(session);
//		deletePegawai(session);
//		List<Employee> listPegawai= getListPegawai(session);
//		for (Employee employee : listPegawai) {
//			System.out.println(employee.getNama()+"dep "+employee.getDepartement().getNamaDepartement());
//		}
//		
//        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();

    }

//	Perintah Insert Pegawai Baru
	private static Integer simpanPegawai(Session session) {
                Departement dep = new Departement();
		dep.setNamaDepartement("Department IT");
		dep.setIdEntry("j");
		dep.setTglEntry(new Timestamp(System.currentTimeMillis()));
		Employee emp = new Employee();
		emp.setNama("ABG");
		emp.setAlamat("SEIN");
		emp.setIdEntry("TIME");
		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
                emp.setDepartement(dep);
		int hasil = (Integer) session.save(emp);
                
                Task task = new Task();
                task.setNamaTugas("Tugas 23");
                task.setIdEntry("entrytas23");
                task.setEmployee(emp);
                task.setTglEntry(new Timestamp(System.currentTimeMillis()));
                task = new Task();
                task.setNamaTugas("Tugas 23");
                task.setIdEntry("entrytas23");
                task.setEmployee(emp);
                task.setTglEntry(new Timestamp(System.currentTimeMillis()));
                session.save(task);
                session.getTransaction().commit();
                
                return hasil;
	}
//        private static void deletePegawaiDua(Session session){
//            return session.cr
//        }
//    private static Integer simpanPegawai(Session session) {
//        Kecamatan kec = new Kecamatan();
//        kec.setNama("Mamang");
//        Alamat al = new Alamat();
//        al.setNama("Selow");
//        al.setKecamatan(kec);
//        Student student = new Student();
//        student.setNama("janco");
//        student.setAlamat(al);
//        student.setIdEntry("okelah");
//        student.setTglEntry(new Timestamp(System.currentTimeMillis()));
//
//        return (Integer) session.save(student);
//    }
	private static Set<Employee> getListPegawaiDanTask(Session session) {
		List<Employee> listData = 
				session.createQuery(" select p from Employee p JOIN FETCH p.listTugas where p.id = :id ")
				.setParameter("id", 44)
				.getResultList();
		return new HashSet<>(listData);

	}
//	Perintah Select Semua Pegawai

    private static List<Employee> getListPegawai(Session session) {
        return session.createQuery("select d from Employee d ").getResultList();

    }

//	Update Pegawai Berdasarkan ID
    private static void updatePegawai(Session session) {
        Employee emp = session.find(Employee.class, 2);
        emp.setNama("nama abcde update");
        emp.setAlamat(" JL Tes ABCDE  update");
        emp.setIdEntry("user1");
        emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
        session.update(emp);

    }

//	Update Pegawai Berdasarkan Pawarameter
    private static int updatePegawaiDua(Session session) {
        return session.createQuery("update Employee set name = :nama where id = :id ")
                .setParameter("nama", "nama update hql ")
                .setParameter("id", 1).executeUpdate();

    }

//	Perintah Delete Berdasarkan ID = 2
    private static void deletePegawai(Session session) {
        Employee emp = session.find(Employee.class, 2);
        session.delete(emp);

    }

    private static List<Employee> getListPegawaiDanDept(Session session) {
        return session.createQuery("select p from Employee p JOIN FETCH p.departement").getResultList();
    }

    private static List<Student> getStudent(Session session) {
        return session.createQuery("select b from Student b JOIN FETCH b.alamat").getResultList();
    }

    private static List<Alamat> getAlamat(Session session) {
        return session.createQuery("select s from Alamat s JOIN FETCH s.kecamatan").getResultList();
    }

    private static List<Kecamatan> getKecamatan(Session session) {
        return session.createQuery("select a from Kecamatan a JOIN FETCH a.alamat").getResultList();
    }

    private static List<Departement> getDept(Session session) {
        return session.createQuery("select p from Departement p JOIN FETCH p.employee").getResultList();
    }

    private static String getNativeQuery(Session session, String sql) {

        return (String) session.createNativeQuery(sql).getSingleResult();
    }

}
