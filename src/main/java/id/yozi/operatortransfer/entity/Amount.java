package id.yozi.operatortransfer.entity;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import id.yozi.operatortransfer.repository.RekeningRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "amount")
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rekening_pengirim", nullable = false)
    private Rekening pengirim;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rekening_penerima", nullable = false)
    private Rekening penerima;
    private Date tanggalKirim;

    @Min(value = 10000)
    private double jumlah;
    private double fee;
    private String bankTujuan;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

}
