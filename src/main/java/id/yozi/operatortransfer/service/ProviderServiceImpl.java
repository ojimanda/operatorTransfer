package id.yozi.operatortransfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Provider;
import id.yozi.operatortransfer.repository.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProvider() {
        // TODO Auto-generated method stub
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderByName(String name) {
        // TODO Auto-generated method stub
        return providerRepository.findByName(name);
    }

    @Override
    public Provider addProvider(Provider provider) {
        // TODO Auto-generated method stub
        Integer code;
        if (providerRepository.findAll().size() == 0) {
            code = 100;
        } else {
            code = providerRepository.getMaxKode() + 1;
        }
        provider.setKode(code);
        providerRepository.save(provider);
        return provider;
    }

    @Override
    public Provider updateProvider(Long id, Provider provider) {
        // TODO Auto-generated method stub
        provider.setId(id);
        providerRepository.saveAndFlush(provider);
        return provider;
    }

    @Override
    public void deleteProvider(Long id) {
        // TODO Auto-generated method stub
        providerRepository.deleteById(id);
    }

    @Override
    public Provider getProviderById(Long id) {
        // TODO Auto-generated method stub
        return providerRepository.findById(id).orElse(null);
    }

}
