package com.vendas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class PedidosItensEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idItem;

    @NotNull
    private long idProduto;

    @NotNull
    private String produto;

    @NotNull
    private int quantidade;

    @NotNull
    private double valor;

    @NotNull
    private String subtotal;

    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;


}