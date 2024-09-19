package com.example.picpay.repository;

import com.example.picpay.model.entity.Wallet;
import com.example.picpay.model.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
