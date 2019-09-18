package com.vendas.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="endereco")
public class EnderecoEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idEndereco;

    @NotNull
    private String rua;

    @NotNull
    private String bairro;

    @NotNull
    private String cep;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="cliente_id", nullable=false)
    private ClienteEntity idCliente;

    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;
}