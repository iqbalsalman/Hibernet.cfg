/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author iqbal
 */

    @Entity
    @Table(name = "departement", schema = "public")
public class Departement extends BaseClass  {
   
    
    private static final long serialVersionUID = -4187975013443944769L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dept", updatable = false, nullable = false)
    private int id;
    
    @Column(name = "nama_dept", length = 150)
    private String namaDepartement;
    
//    @OneToOne(cascade  = CascadeType.ALL mappedBy = "departement", fetch = fetchType.Lazy)
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaDepartement() {
        return namaDepartement;
    }

    public void setNamaDepartement(String namaDepartement) {
        this.namaDepartement = namaDepartement;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
    
    
    
}
