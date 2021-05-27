import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

import java.util.HashSet;
//import org.graphstream.graph.Graph;

public class BellmanFord {

    public static int distancia;
//   public static Pilha arvoreGeradora;
    public static Grafo GRAFO;

    // Trabalho 10
    public static void BellmanFord(No n) {
        n.menorDistancia = 0;

        int vezes = GRAFO.getConexoes().size() - 1;

        for(int i = 0; i < vezes; i++) {
            for(No no: GRAFO.getConexoes()) {
                for(Conexao conexao: no.getConexoes()) {
                    if(conexao.inicio.menorDistancia != Integer.MAX_VALUE && conexao.destino.menorDistancia > conexao.inicio.menorDistancia + conexao.custo) {
                        conexao.destino.anterior = conexao.inicio;
                        conexao.destino.menorDistancia = conexao.inicio.menorDistancia + conexao.custo;
                    }
                }
            }
        }
    }

    public static void desenharGrafo(HashSet<No[]> conexoes, String cor) {
        // Ao invés de ter "Grafo grafo" como parâmetro, alterar para um ArrayList, onde cada elemento é adicionado por
        // fora e depois passa
        System.setProperty("org.graphstream.ui", "swing");
        MultiGraph graph = new MultiGraph("Tutorial 1");
        graph.setAttribute("ui.stylesheet",
                "node {" +
                        "fill-color: " + cor +
                        ";size: 60px, 60px;" +
                        "stroke-mode: plain;" +
                        "stroke-color: black;" +
                        "stroke-width: 1px;" +
                        "text-size: 20px;" +
                        "}"
        );


        HashSet<No> nosParaAdicionar = new HashSet<>();
        conexoes.forEach(
                (conexao) -> {

                    nosParaAdicionar.add(conexao[0]);
                    nosParaAdicionar.add(conexao[1]);
                }
        );

        for(No n: nosParaAdicionar) {
            graph.addNode(n.toString());
        }

        for(No[] n: conexoes) {
            graph.addEdge(String.format("%s-%s", n[0].toString(), n[1].toString()), n[0].toString(), n[1].toString());
        }


        graph.edges().forEach(
                (origem) -> {
                    Node node0 = origem.getNode0();
                    Node node1 = origem.getNode1();

                    node0.setAttribute("ui.label", node0.toString());
                    node1.setAttribute("ui.label", node1.toString());

                    node0.setAttribute("ui.class", "node");
                }
        );

        graph.display();
    }

    public static void ComecarBellmanFord(Grafo grafo, String nomeNo) {
        System.out.println("Trabalho 10");
        for(No no: grafo.getConexoes()) {
            if(no.id.equalsIgnoreCase(nomeNo)) {
                // BellmanFord
                GRAFO = grafo;
                GRAFO.reiniciarValores();
                BellmanFord.BellmanFord(no);
                System.out.println(GRAFO);

                // Desenhar grafo inicial
//                BellmanFord.desenharGrafo(BellmanFord.gerarGrafoDesenho(grafo), "pink");

                // Desenhar arvore geradora
//               BellmanFord.desenharGrafo(BellmanFord.gerarGrafoDesenho(arvoreGeradora), "green");
                return;
            }
        }
        System.out.println("Nome não encontrado no grafo!");
    }

 //   public static HashSet<No[]> gerarGrafoDesenho(Grafo grafo) {
//       HashSet<No[]> grafoDesenho = new HashSet<>();
//        for(No filho1: grafo.getConexoes()) {
//            for(No filho2: filho1.getConexoes()) {
//                grafoDesenho.add(new No[]{filho1, filho2});
//            }
//        }
//
//        return grafoDesenho;
//    }

//    public static HashSet<No[]> gerarGrafoDesenho(Pilha pilha) {
//        HashSet<No[]> grafoDesenho = new HashSet<>();
//        while(pilha.tamanho() > 0) {
//            No[] removidos = pilha.pop();
//            grafoDesenho.add(new No[]{removidos[0], removidos[1]});
//        }
//
//        return grafoDesenho;
//    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

//        // 9.2
     /*  int[][][] matriz = {
              {{0, 0}, {1, 5}, {1, 7}, {1, 1}, {0, 0}, {0, 0}, {0, 0}},
              {{0, 0}, {0, 0}, {1, 2}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
              {{0, 0}, {0, 0}, {0, 0}, {1, 6}, {1, 5}, {0, 0}, {0, 0}},
                {{0, 0}, {1, 3}, {0, 0}, {0, 0}, {0, 0}, {1, 5}, {1, 3}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 4}, {0, 0}},
                {{0, 0}, {0, 0}, {1, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
               {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 1}, {0, 0}, {0, 0}}
        };

        String[] nos = {"a", "b", "c", "d", "e", "f", "g"};*/

        // 9.3
        int[][][] matriz = {
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 5}, {1, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 2}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {1, 11}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 9}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {1, 3}, {0, 0}, {1, 3}, {1, 5}, {0, 0}, {0, 0}, {1, 6}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 5}},
                {{0, 0}, {1, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 8}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 6}, {0, 0}, {0, 0}, {0, 0}, {1, 4}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {1, 4}, {0, 0}, {1, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 7}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 10}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 13}, {1, 8}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 9}, {0, 0}, {0, 0}, {0, 0}},
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 6}, {0, 0}, {0, 0}, {0, 0}},
        };

        String[] nos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};

        for(int i = 0; i < nos.length; i++) {
            String no = nos[i];
            grafo.adicionar(no);
        }

        for (int i = 0 ; i < nos.length; i++){
            for(int j = 0; j < nos.length; j++) {
                if(matriz[i][j][0] == 1) grafo.conectarNo(nos[i], nos[j], matriz[i][j][1]);
            }
        }

//        System.out.println(grafo.toString());
        BellmanFord.ComecarBellmanFord(grafo, "a"); // Trabalho 10
    }
}