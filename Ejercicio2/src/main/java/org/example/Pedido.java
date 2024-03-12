package org.example;
import java.util.List;
import java.util.ArrayList;

class Pedido {
    private ClienteECommerce cliente;
    private List<Obra> obrasCompradas;

    public Pedido(ClienteECommerce cliente) {
        this.cliente = cliente;
        this.obrasCompradas = new ArrayList<>();
    }

    public void agregarObra(Obra obra) {
        obrasCompradas.add(obra);
        cliente.agregarCompra(obra);
    }

    public void mostrarPedido() {
        System.out.println("Pedido para cliente: " + cliente.nombre);
        for (Obra obra : obrasCompradas) {
            obra.mostrarDetalles();
        }
    }
}
