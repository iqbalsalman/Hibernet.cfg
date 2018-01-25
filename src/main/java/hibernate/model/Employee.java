package hibernate.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pegawai", schema = "public")
public class Employee extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "alamat", length = 150)
    private String alamat;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dept")
    private Departement departement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<Task> listTugas;

    public Set<Task> getListTugas() {
        return listTugas;
    }

    public void setListTugas(Set<Task> listTugas) {
        this.listTugas = listTugas;
    }

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

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the departement
     */
    public Departement getDepartement() {
        return departement;
    }

    /**
     * @param departement the departement to set
     */
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

}
