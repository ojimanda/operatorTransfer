package id.yozi.operatortransfer.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Integer kode = 100;

    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Amount> amounts;

    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rekening> rekening;

}
