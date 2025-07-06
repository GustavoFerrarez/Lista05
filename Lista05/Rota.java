// Representa a conexão entre duas cidades (uma aresta do grafo).
public class Rota {
    private Cidade destino;
    private double distancia;

    public Rota(Cidade destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Cidade getDestino() {
        return destino;
    }
    public double getDistancia() {
        return distancia;
    }

    @Override
    public String toString() {
        return " -> " + destino.getNome() + " (" + distancia + " km)";
    }
}
