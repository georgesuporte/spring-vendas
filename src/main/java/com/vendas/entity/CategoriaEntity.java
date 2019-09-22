package com.vendas.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categoria")
public class CategoriaEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @NotNull
    @Column(name="categoria")
    private String categoria;

    @JsonIgnore
    @OneToMany(mappedBy="idCategoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<ProdutosEntity> produtos;

    @Column(name="created")
    @JsonIgnore
    @CreationTimestamp
    private  Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private  Date  updatedAt;
}