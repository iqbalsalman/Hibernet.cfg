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
import javax.persistence.Table;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name = "Kecamatan", schema = "public")
public class Kecamatan {

    private static final long serialVersionUID = -4187975013443944769L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kecamatan", updatable = false, nullable = false)
    private int id;

    @Column(name = "nama", length = 50)
    private String nama;
    
    


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


    
    

}
