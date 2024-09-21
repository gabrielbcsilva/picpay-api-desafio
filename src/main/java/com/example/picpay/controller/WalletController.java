package com.example.picpay.controller;

import com.example.picpay.controller.dto.CreateWalletDto;
import com.example.picpay.model.entity.Wallet;
import com.example.picpay.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody CreateWalletDto dto){
        Wallet wallet =    walletService.createWallet(dto);
        return  ResponseEntity.ok(wallet);
    }
}
