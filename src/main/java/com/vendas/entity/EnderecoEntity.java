package com.vendas.entity;

import java.io.Serializable;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="endereco")
public class EnderecoEntity implements Serializable  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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
    private  Date  createdAt;

    @Column(name="modified")
    @JsonIgnore
    @UpdateTimestamp
    private Date  updatedAt;

	void setId(Long id) {
	}
}