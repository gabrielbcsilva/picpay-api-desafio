package com.example.picpay.config;

import com.example.picpay.model.entity.WalletType;
import com.example.picpay.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values()).forEach(
                walletType->{
                    Optional<WalletType> foundWallet = walletTypeRepository.findByDescription(walletType.get().getDescription()) ;
                    if(foundWallet.isEmpty()){
                        walletTypeRepository.save(walletType.get());
                    }
                }
        );
    }
}
