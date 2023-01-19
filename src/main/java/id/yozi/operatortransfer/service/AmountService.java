package id.yozi.operatortransfer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Amount;
import id.yozi.operatortransfer.entity.History;
import id.yozi.operatortransfer.entity.Provider;
import id.yozi.operatortransfer.entity.Rekening;
import id.yozi.operatortransfer.repository.AmountRepository;
import id.yozi.operatortransfer.repository.HistoryRepository;
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

    @Autowired
    HistoryRepository historyRepository;

    public Amount addAmount(Amount amount, Rekening rekPengirim, Rekening rekPenerima) {

        if (rekPengirim.getSaldo() - amount.getJumlah() > 50000) {
            Provider provider = rekPengirim.getProvider();
            if (rekPengirim.getProvider() == rekPenerima.getProvider()) {
                amount.setFee(0);
                rekPengirim.setSaldo(rekPengirim.getSaldo() - amount.getJumlah());
            } else {
                amount.setFee(6500);
                rekPengirim.setSaldo(rekPengirim.getSaldo() - amount.getJumlah() - 6500);
            }
            rekPenerima.setSaldo(rekPenerima.getSaldo() + amount.getJumlah());

            Date gDate = new Date();

            History history = new History();
            history.setJumlah(amount.getJumlah());
            history.setPenerima(rekPenerima.getNasabah().getFullName());
            history.setPengirim(rekPengirim.getNasabah().getFullName());
            history.setTanggalKirim(gDate);
            historyRepository.save(history);

            rekeningRepository.saveAndFlush(rekPengirim);
            rekeningRepository.saveAndFlush(rekPenerima);
            amount.setPengirim(rekPengirim);
            amount.setPenerima(rekPenerima);
            amount.setTanggalKirim(gDate);
            amount.setProvider(provider);
            amount.setBankTujuan(rekPenerima.getProvider().getName());
            amountRepository.save(amount);
        }

        return amount;
    }

}
