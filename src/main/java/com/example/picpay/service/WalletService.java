package com.example.picpay.service;

import com.example.picpay.controller.dto.CreateWalletDto;
import com.example.picpay.exceptions.WalletDataAlreadyExistsException;
import com.example.picpay.model.entity.Wallet;
import com.example.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
       var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(),dto.email());

       if(walletDb.isPresent()){
        throw new WalletDataAlreadyExistsException("CpfCnpj already exists");
       }
        return walletRepository.save(dto.toWallet());
    }
}
