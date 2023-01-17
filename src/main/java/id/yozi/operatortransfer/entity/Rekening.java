package id.yozi.operatortransfer.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "rekening")
public class Rekening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noRekening;
    private double saldo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "nasabah_id", nullable = false)
    private Nasabah nasabah;
}
