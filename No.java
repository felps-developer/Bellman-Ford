import java.util.ArrayList;

public class No {
    public String id;
    public int menorDistancia;
    private ArrayList<Conexao> conexoes;
    public boolean visitado;
    public No anterior;

    public No(String id) {
        this.id = id;
        this.menorDistancia = Integer.MAX_VALUE;
        this.conexoes = new ArrayList<>();
        this.visitado = false;
        this.anterior = null;

    }

    public ArrayList<Conexao> getConexoes() {
        return conexoes;
    }

    @Override
    public String toString() {
        return String.format("%s", id, menorDistancia);
    }

    public void adicionar(No destino, int custo) {
        for (Conexao no: conexoes) {
            if(no.destino.id.equals(destino.id))
                return;
        }

        conexoes.add(new Conexao(this, destino, custo));
    }
}