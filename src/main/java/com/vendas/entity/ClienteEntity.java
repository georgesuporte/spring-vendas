package com.vendas.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name="cliente")
public class ClienteEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3222901952642731280L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idCliente;
   
    @NotNull
    private String nome;
    
    @NotNull
    private String email;
   
    @JsonIgnore
    private String senha;

    @OneToMany(mappedBy="idCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<EnderecoEntity> idEndereco;

    @OneToMany(mappedBy="idCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<PedidosEntity> idPedidos;

    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private  Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private  Date  updatedAt;



}