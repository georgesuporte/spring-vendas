package com.vendas.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="pedidos")
public class PedidosEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long  idPedido;

    @NotNull
    private Date data;

    @NotNull
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="cliente_id", nullable=false)
    private ClienteEntity idCliente;

    @OneToMany(mappedBy="idPedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<PedidosItensEntity> pedidosItens;

    @NotNull
    private String status;

    @NotNull
    private String sessao;

    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private final Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private final Date  updatedAt;

}