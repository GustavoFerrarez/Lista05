import java.util.Objects;

// Representa uma cidade. Implementa Comparable para ser ordenada em um TreeSet.
public class Cidade implements Comparable<Cidade> {
    private String nome;
    private String estado;
    private long populacao;

    public Cidade(String nome, String estado, long populacao) {
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
    }
    
    // Construtor para casos onde o estado não é informado, como em um dos testes[cite: 17].
    public Cidade(String nome, long populacao) {
        this.nome = nome;
        this.estado = "MG"; // Estado padrão definido para o caso de teste
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }
    public String getEstado() {
        return estado;
    }
    public long getPopulacao() {
        return populacao;
    }
    
    // Define como a cidade será ordenada (por nome).
    @Override
    public int compareTo(Cidade outra) {
        return this.nome.compareTo(outra.getNome());
    }

    // Define como o objeto será exibido em texto.
    @Override
    public String toString() {
        return nome + " (" + estado + ")";
    }

    // Métodos equals e hashCode são necessários para que a classe funcione corretamente em HashMaps.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(nome, cidade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}