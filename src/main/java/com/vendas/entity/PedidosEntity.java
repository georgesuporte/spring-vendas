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
public class PedidosEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idPedido;

    @NotNull
    private Date data;

    @NotNull
    private Long idCliente;

    @NotNull
    private String status;

    @NotNull
    private String sessao;

    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;

}