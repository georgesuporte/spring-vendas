package com.vendas.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="produtos")
public class ProdutosEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  idProduto;

    @NotNull
    private String produto;

    @NotNull
    private String preco;

    @NotNull
    private String quantidade;

    @NotNull
    private String descricao;

    @NotNull
    private String foto;

    @OneToMany(mappedBy="idProduto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<PedidosItensEntity> pedidosItens;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_id", nullable=false)
    private CategoriaEntity idCategoria;
    
    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;


}