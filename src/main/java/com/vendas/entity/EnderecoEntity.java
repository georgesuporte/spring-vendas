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
public class EnderecoEntity {

    @Id
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

    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;
}