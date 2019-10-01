package com.vendas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="pedidositens")
public class PedidosItensEntity  {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  idItem;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pedido_id", nullable=false)
    private PedidosEntity idPedido;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produto_id", nullable=false)
    private ProdutosEntity idProduto;

    @NotNull
    private String produto;

    @NotNull
    private int quantidade;

    @NotNull
    private double valor;

    @NotNull
    private String subtotal;

    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;


}