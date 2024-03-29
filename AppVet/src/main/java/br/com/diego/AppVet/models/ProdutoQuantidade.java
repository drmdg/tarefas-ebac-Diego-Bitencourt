package br.com.diego.AppVet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class ProdutoQuantidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda_fk",
            foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"),
            referencedColumnName = "id", nullable = false
    )
    @JsonIgnore
    private Venda venda;

    public ProdutoQuantidade (){
        this.quantidade=0;
        this.valorTotal=BigDecimal.ZERO;
    }

    public void adicionar(Integer quantidade){
        this.quantidade += quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        BigDecimal novoTotal = this.valorTotal.add(novoValor);
        this.valorTotal=novoTotal;
    }

    public void remover(Integer quantidade){
        this.quantidade -= quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }

}
