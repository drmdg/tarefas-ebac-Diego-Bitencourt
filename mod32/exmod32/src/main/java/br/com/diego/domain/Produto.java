package main.java.br.com.diego.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "TB_PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prod_seq")
    @SequenceGenerator(name ="prod_seq",sequenceName = "sq_produto",initialValue = 1,allocationSize = 1)
    private Long id;
    @Column(name = "descricao",length = 100,nullable = false)
    private String descricao;
    @Column(name = "fabricante",length = 100,nullable = false)
    private String fabricante;
    @Column(name = "valor",nullable = false)
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
