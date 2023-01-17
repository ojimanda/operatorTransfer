package id.yozi.operatortransfer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.yozi.operatortransfer.entity.Provider;

@Service
public interface ProviderService {

    public List<Provider> getAllProvider();

    public Provider getProviderByName(String name);

    public Provider addProvider(Provider provider);

    public Provider updateProvider(Long id, Provider provider);

    public void deleteProvider(Long id);

}
