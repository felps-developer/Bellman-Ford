import java.util.ArrayList;

public class Grafo {
    private ArrayList<No> nos;

    public ArrayList<No> getConexoes() {
        return nos;
    }

    public Grafo() {
        this.nos = new ArrayList<>();
    }

    public void adicionar(No no) {
        for(No n: nos) {
            if (no.id.equals(n.id)) return;
        }

        nos.add(no);
    }

    public boolean contains(No n) {
        for(No no: nos)
            if(no.id.equals(n.id)) return true;

        return false;
    }

    public void adicionar(String no) {
        // Infinito
        adicionar(new No(no));
    }

    public void conectarNo(String origem, String destino, int dist) {
        No ORIGEM, DESTINO;
        ORIGEM = DESTINO = null;

        // Percorrer nós existentes e, caso ambos existam com os nomes fornecidos, ele cria a conexão
        for(No no: nos) {
            if(no.id.equals(origem)) ORIGEM = no;
            if(no.id.equals(destino)) DESTINO = no;
        }

        if(ORIGEM != null && DESTINO != null) {
            DESTINO.menorDistancia = dist;
            ORIGEM.adicionar(DESTINO, dist);
        }
    }

    public void reiniciarValores() {
        for(No no: nos) {
            no.menorDistancia = Integer.MAX_VALUE;
            no.visitado = false;
            no.anterior = null;
        }
    }

    public boolean todosVisitados() {
        boolean ok = true;

        for(No no: nos) {
            ok = ok && no.visitado;
        }

        return ok;
    }

    @Override
    public String toString() {
        String resultado = "";

        for(No no: this.nos) {
            resultado += String.format("%s - %d\n", no.id, no.menorDistancia);
        }

        return resultado;
    }
}
