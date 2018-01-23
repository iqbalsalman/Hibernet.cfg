package hibernate;

import hibernate.model.Alamat;
import hibernate.model.Departement;
import java.sql.Timestamp;

import org.hibernate.Session;
import hibernate.util.HibernateUtil;

import hibernate.model.Employee;
import hibernate.model.Kecamatan;
import hibernate.model.Student;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String result = getNativeQuery( session, "select version()");
		System.out.println(result);
                
//                List<Departement> listdept= getDept(session);
//		for (Departement de : listdept) {
//			System.out.println(de.getNamaDepartement()+"employee "+de.getEmployee().getNama());
//		}
		
		simpanPegawai(session);
                
               
		
//		updatePegawai(session);
//		updatePegawaiDua(session);
//		deletePegawai(session);
//		List<Employee> listPegawai= getListPegawai(session);
//		for (Employee employee : listPegawai) {
//			System.out.println(employee.getNama()+"dep "+employee.getDepartement().getNamaDepartement());
//		}
//		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
		
	}
	
//	Perintah Insert Pegawai Baru
//	private static Integer simpanPegawai(Session session) {
//                Departement dep = new Departement();
//		dep.setNamaDepartement("Department IT");
//		dep.setIdEntry("j");
//		dep.setTglEntry(new Timestamp(System.currentTimeMillis()));
//		Employee emp = new Employee();
//		emp.setNama("ABG");
//		emp.setAlamat("SEIN");
//		emp.setIdEntry("TIME");
//		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
//                emp.setDepartement(dep);
//		return (Integer) session.save(emp);
//	}
        
        private static Integer simpanPegawai(Session session) {
                Kecamatan kec = new Kecamatan();
		kec.setNama("Rengasdengklok");
//		kec.setAlamat("Desa Dukuh karya");
		//kec.setIdEntry("okes");
		//kec.setTglEntry(new Timestamp(System.currentTimeMillis()));
                
                Alamat al = new Alamat();
                al.setNama("Desa Dukuh karya");
		al.setKecamatan("Rengasdengklok");
                al.setKecamata(kec);
		//al.setIdEntry("oke");
		//al.setTglEntry(new Timestamp(System.currentTimeMillis()));
                //al.setStudent(su);
                //al.setKecamatan(kec)
                Student su = new Student();
		su.setNama("Muhamad Iqbal Salman");
                su.setAlamat("Desa Dukuh karya");
		su.setIdEntry("setId");
		su.setTglEntry(new Timestamp(System.currentTimeMillis()));
                su.setAlamats(al);
                
		return (Integer) session.save(su);
	}
	
//	Perintah Select Semua Pegawai
	private static List<Employee> getListPegawai(Session session){
		return session.createQuery("select d from Employee d ").getResultList();
		
	}
	
//	Update Pegawai Berdasarkan ID
	private static void updatePegawai(Session session){
		Employee emp = session.find(Employee.class, 2)  ;
		emp.setNama("nama abcde update");
		emp.setAlamat(" JL Tes ABCDE  update");
		emp.setIdEntry("user1");
		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
		    session.update(emp); 
		
	}

//	Update Pegawai Berdasarkan Pawarameter
	private static int updatePegawaiDua(Session session){
		 return session.createQuery("update Employee set name = :nama where id = :id ")
		 .setParameter("nama", "nama update hql ") 
		 .setParameter("id", 1).executeUpdate() ;
		
	}
	
//	Perintah Delete Berdasarkan ID = 2
	private static void deletePegawai(Session session){
		Employee emp = session.find(Employee.class, 2)  ; 
		    session.delete( emp); 
		
	}
        
        
        private static List<Employee> getListPegawaiDanDept(Session session){
            return session.createQuery("select p from Employee p JOINT FETCH p.departement").getResultList();
        }
        
         private static List<Departement> getDept(Session session){
            return session.createQuery("select p from Departement p JOIN FETCH p.employee").getResultList();
        }
	
	
	
	
	
	private static String getNativeQuery(Session session, String sql) {
		
		return (String) session.createNativeQuery(sql).getSingleResult();
	}
	
	
}