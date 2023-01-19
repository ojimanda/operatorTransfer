package id.yozi.operatortransfer.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Amount;
import id.yozi.operatortransfer.entity.Provider;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.AmountRepository;
import id.yozi.operatortransfer.repository.ProviderRepository;
import id.yozi.operatortransfer.repository.RekeningRepository;

@Service
public class AmountService {

    @Autowired
    AmountRepository amountRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    RekeningRepository rekeningRepository;

    public Amount addAmount(Amount amount, Rekening rekPengirim, Rekening rekPenerima) {

        Provider provider = rekPengirim.getProvider();
        if (rekPengirim.getProvider() == rekPenerima.getProvider()) {
            amount.setFee(0);
            rekPengirim.setSaldo(rekPengirim.getSaldo() - amount.getJumlah());
        } else {
            amount.setFee(6500);
            rekPengirim.setSaldo(rekPengirim.getSaldo() - amount.getJumlah() - 6500);
        }
        rekPenerima.setSaldo(rekPenerima.getSaldo() + amount.getJumlah());

        rekeningRepository.saveAndFlush(rekPengirim);
        rekeningRepository.saveAndFlush(rekPenerima);
        amount.setPengirim(rekPengirim);
        amount.setPenerima(rekPenerima);
        Date gDate = new Date();
        amount.setTanggalKirim(gDate);
        amount.setProvider(provider);
        amount.setBankTujuan(rekPenerima.getProvider().getName());
        amountRepository.save(amount);

        return amount;
    }
}
