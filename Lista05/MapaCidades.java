import java.util.*;

// Gerencia o mapa de cidades e suas conexões.
public class MapaCidades {
    private Set<Cidade> cidades; // TreeSet para garantir a ordenação das cidades.
    private Map<Cidade, Set<Rota>> mapa; // HashMap para a estrutura do grafo.

    public MapaCidades() {
        this.cidades = new TreeSet<>();
        this.mapa = new HashMap<>();
    }

    // Adiciona uma cidade ao mapa.
    public void adicionarCidade(Cidade cidade) {
        cidades.add(cidade);
        mapa.put(cidade, new HashSet<>());
    }

    // Conecta duas cidades com uma rota de mão dupla (não direcionada).
    public void conectarCidades(Cidade origem, Cidade destino, double distancia) {
        mapa.get(origem).add(new Rota(destino, distancia));
        mapa.get(destino).add(new Rota(origem, distancia));
    }

    // Mostra as conexões de uma cidade específica[cite: 7].
    public void listarConexoes(Cidade cidade) {
        System.out.println("\nConexões de " + cidade.getNome() + ":");
        Set<Rota> rotas = mapa.get(cidade);
        if (rotas.isEmpty()) {
            System.out.println("Nenhuma conexão encontrada.");
        } else {
            for (Rota rota : rotas) {
                System.out.println(rota);
            }
        }
    }

    // Verifica se existe um caminho (direto ou indireto) entre duas cidades[cite: 21, 22].
    public boolean existeCaminho(Cidade origem, Cidade destino) {
        Set<Cidade> visitadas = new HashSet<>();
        Queue<Cidade> fila = new LinkedList<>();

        fila.add(origem);
        visitadas.add(origem);

        while (!fila.isEmpty()) {
            Cidade atual = fila.poll();
            if (atual.equals(destino)) {
                return true;
            }

            // Adiciona os vizinhos não visitados na fila.
            for (Rota rota : mapa.get(atual)) {
                Cidade vizinha = rota.getDestino();
                if (!visitadas.contains(vizinha)) {
                    visitadas.add(vizinha);
                    fila.add(vizinha);
                }
            }
        }
        return false; 
    }

    // Lista todas as cidades que não têm nenhuma rota conectada a elas[cite: 8].
    public void listarCidadesSemConexao() {
        for (Cidade cidade : cidades) { // Itera sobre o TreeSet ordenado.
            if (mapa.get(cidade).isEmpty()) {
                System.out.println(cidade);
            }
        }
    }
}