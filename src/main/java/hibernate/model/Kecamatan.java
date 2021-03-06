/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template isn the editor.
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
@Table(name = "Kecamatan", schema = "public")
public class Kecamatan {

    private static final long serialVersionUID = -4187975013443944769L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kecamatan", updatable = false, nullable = false)
    private int id;

    @Column(name = "nama", length = 50)
    private String nama;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alamat")
    private Alamat alamat;

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

    /**
     * @return the alamat
     */
    public Alamat getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }

}
