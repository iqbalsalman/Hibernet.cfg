/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name= "tugas", schema="public")
public class Task extends BaseClass {

        @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_tugas", updatable = false, nullable = false)
        private int id;
        
        @Column(name = "nama_tugas", length= 50)
        private String namaTugas;
        
        @ManyToOne
        @JoinColumn(name = "id")
        private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
        
        
        
        
}
