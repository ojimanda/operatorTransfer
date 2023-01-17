package id.yozi.operatortransfer.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "nasabah")
public class Nasabah implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Date dob;
    private Integer noIdentity;
    private String tipeIdentity;
    private String email;
    private String contact;

    @OneToMany(mappedBy = "nasabah", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rekening> rekening;

}
