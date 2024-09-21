package com.example.picpay.controller.dto;

import com.example.picpay.model.entity.Wallet;
import com.example.picpay.model.entity.WalletType;

public record CreateWalletDto(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {
    public Wallet toWallet(){
        return new Wallet(
                 fullName,
                 cpfCnpj,
                 email,
                 password,
                 walletType.get()
        );
    }
}
