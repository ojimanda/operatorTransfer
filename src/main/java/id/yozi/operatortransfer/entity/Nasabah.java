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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "nasabah")
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private Integer noIdentity;

    private String tipeIdentity;

    @Column(unique = true)
    private String email;

    private String contact;

    @OneToMany(mappedBy = "nasabah", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Rekening> rekening;

}
