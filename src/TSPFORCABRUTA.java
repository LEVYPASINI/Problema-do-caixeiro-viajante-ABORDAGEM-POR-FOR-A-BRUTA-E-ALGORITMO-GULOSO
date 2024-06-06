import java.util.*;

public class TSPFORCABRUTA {

    

    public double caixeiroviajante(double[][] distancias, int s) {

        int V = 14;
        List<Integer> vizinhos = new ArrayList<>();
        System.out.println("ALGORITMO BRUTA FORÇA RODANDO: ");
        System.out.println("cidade de origem: " + s);
        
        for (int i = 0; i < V; i++) {
            if (i != s) {
                vizinhos.add(i);
            }
        }

        double menorcaminho = Integer.MAX_VALUE;
        do {

            double caminhoatualtotal = 0;
            int k = s;

            for (int i = 0; i < vizinhos.size(); i++) {
                caminhoatualtotal += distancias[k][vizinhos.get(i)];
                k = vizinhos.get(i);
            }
            caminhoatualtotal += distancias[k][s];

            if(caminhoatualtotal < menorcaminho){
                menorcaminho= caminhoatualtotal;
                //System.out.println("melhor rota ate agora: " + vizinhos);
                //System.out.println("menorcaminho " + menorcaminho);
            }

        } while (nextPermutation(vizinhos));
        
        return menorcaminho;
    }

    // Função para gerar a próxima permutação
    public boolean nextPermutation(List<Integer> arr) {
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.size() - 1;
        while (arr.get(j) <= arr.get(i)) {
            j--;
        }
        Collections.swap(arr, i, j);
        Collections.reverse(arr.subList(i + 1, arr.size()));
        return true;
    }

    public double distanciaeuclidiana(int[] cidade1, int[] cidade2) {
        int x1 = cidade1[0];
        int y1 = cidade1[1];
        int x2 = cidade2[0];
        int y2 = cidade2[1];
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}