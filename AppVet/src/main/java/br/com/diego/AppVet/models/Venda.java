package br.com.diego.AppVet.models;

import br.com.diego.AppVet.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Venda {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk",
            foreignKey = @ForeignKey(name = "fk_venda_cliente"),
            referencedColumnName = "id", nullable = false
    )
    @JsonIgnore
    private Cliente cliente;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    @JsonManagedReference
    private Set<ProdutoQuantidade> produtos;
    @Column(name = "VALOR_TOTAL", nullable = false)
    private BigDecimal valorTotal;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_VENDA", nullable = false)
    private Status status;

    private void validarStatus() {
        if (this.status == Status.CONCLUIDA) {
            throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
        }
    }

    public void adicionarProduto(Produto produto, Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidade> op = produtos.stream()
                .filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();

        if (op.isPresent()){
            ProdutoQuantidade produtoQuantidade = op.get();
            produtoQuantidade.adicionar(quantidade);
        }else {

            ProdutoQuantidade prodQtd = new ProdutoQuantidade();
            prodQtd.setProduto(produto);
            prodQtd.setQuantidade(quantidade);
            prodQtd.setVenda(this);
            produtos.add(prodQtd);
        }
        recalcularValorTotalVenda();
    }

    private void recalcularValorTotalVenda() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQuantidade pqtd : produtos){
                valorTotal = valorTotal.add(pqtd.getValorTotal());
        }
        this.valorTotal=valorTotal;
    }

    public void removerProduto(Produto produto, Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidade> op = produtos.stream().filter(filter-> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
        if (op.isPresent()){
            ProdutoQuantidade produtoQuantidade = op.get();
            if(produtoQuantidade.getQuantidade()>quantidade){
                produtoQuantidade.remover(quantidade);
                recalcularValorTotalVenda();
            }else {
                produtos.remove(op.get());
                recalcularValorTotalVenda();
            }
        }
    }
    public void removerTodosProdutos(){
        validarStatus();
        produtos.clear();
        this.valorTotal=BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos(){
        Integer result = produtos.stream().reduce(0, (partialCountResult,prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }

}
