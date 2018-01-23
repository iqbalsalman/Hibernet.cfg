/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author iqbal
 */
 @Entity
 @Table(name = "student", schema = "public")
public class Student extends BaseClass {
        private static final long serialVersionUID = -4187975013443944769L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_studens", updatable = false, nullable = false)
    
    private int id;
    
    @Column(name = "nama", length= 50)
    private String nama;
    
    @Column(name = "Alamat", length= 150)
    private String alamat;
    
     @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "id_alamat")
     
     private Alamat alamats;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String Alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the alamats
     */
    public Alamat getAlamats() {
        return alamats;
    }

    /**
     * @param alamats the alamats to set
     */
    public void setAlamats(Alamat alamats) {
        this.alamats = alamats;
    }
    
    
    
}
