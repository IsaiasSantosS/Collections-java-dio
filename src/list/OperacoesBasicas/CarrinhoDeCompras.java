package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinho;

    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        if (!carrinho.isEmpty()){
            List<Item> produtoParaRemover = new ArrayList<>();
            for (Item t : carrinho){
                if (t.getNome().equalsIgnoreCase(nome)) {
                    produtoParaRemover.add(t);
                }
            }
            carrinho.removeAll(produtoParaRemover);
        } else {
            System.out.println("Lista de produtos está vazia");
        }

    }

    public Double calcularValorTotal(){
        double total = 0.0;
        for (Item t : carrinho){
            total += t.getPreco() * t.getQuantidade();
        }

        return total;
    }

    public void exibirItens(){
        System.out.println(carrinho);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Carro", 10.0, 5);
        carrinhoDeCompras.adicionarItem("Moto", 8.0, 10);
        carrinhoDeCompras.adicionarItem("Caminhão", 18.0, 2);

        System.out.println("Valor total: " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("carro");

        System.out.println("Valor total: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.exibirItens();
    }
}
