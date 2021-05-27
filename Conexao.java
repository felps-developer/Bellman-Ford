public class Conexao {
    public No inicio;
    public No destino;
    public int custo;

    public Conexao(No no1, No no2, int custo) {
        this.inicio = no1;
        this.destino = no2;
        this.custo = custo;
    }

    public static Conexao novo(No no1, No no2, int custo) {
        return new Conexao(no1, no2, custo);
    }
}