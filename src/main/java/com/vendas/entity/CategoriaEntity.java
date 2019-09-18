package com.vendas.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
// import java.sql.Timestamp;
// import java.util.List;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class CategoriaEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @NotNull
    @Column(name="categoria")
    private String categoria;

    @OneToMany(mappedBy="idCategoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<ProdutosEntity> produtos;

    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;
}