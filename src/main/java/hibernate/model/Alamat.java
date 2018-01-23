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
@Table(name = "Alamat", schema = "public")
public class Alamat{

    private static final long serialVersionUID = -4187975013443944769L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_alamat", updatable = false, nullable = false)
    private int id;
    
    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "Kecamatan", length = 50)
    private String kecamatan;
    
     @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "id_kecamatan")

    private Kecamatan kecamata;

    
            
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    /**
     * @return the kecamata
     */
    public Kecamatan getKecamata() {
        return kecamata;
    }

    /**
     * @param kecamata the kecamata to set
     */
    public void setKecamata(Kecamatan kecamata) {
        this.kecamata = kecamata;
    }


    
    

}
