import java.util.*;

public class TSPGULOSO {

    

    public double caixeiroviajanteguloso(double[][] distancias, int s) {

        int V = 14;
        List<Integer> vizinhos = new ArrayList<>();
        System.out.println("ALGORITMO GULOSO RODANDO: ");
        System.out.println("cidade de origem: " + s);


        for (int i = 0; i < V; i++) {
            if (i != s) {
                vizinhos.add(i);
            }
        }

        double menorcaminho = 0;
        double menorcaminholocal = Integer.MAX_VALUE;
        double caminho;
        int k = s;
        int melhorvizinho = 0;

        for (int i = 0; i < vizinhos.size(); i++) {
            for(int j = 0; j < vizinhos.size(); j++){
                
                caminho = distancias[k][vizinhos.get(j)]; //salva o caminho pois será retirado da matriz de distancias
                //System.out.println("distancia entre cidade " + k + " e " + vizinhos.get(j) + " é " + caminho);
                if(k != s){

                    distancias[k][vizinhos.get(j)] = Integer.MAX_VALUE;
                    distancias[vizinhos.get(j)][k] = Integer.MAX_VALUE;

                }

                if(caminho < menorcaminholocal){
                    menorcaminholocal = caminho;
                    melhorvizinho = j;
                }
            }
            //System.out.println("menorcaminholocal: " + menorcaminholocal);
            menorcaminho += menorcaminholocal;
            //System.out.println("cidade: " + k);
            k = vizinhos.get(melhorvizinho);
            //System.out.println("proxima cidade: " + k);
            menorcaminholocal = Integer.MAX_VALUE;
   
        }
        //System.out.println("ultima cidade: " + melhorvizinho);
        menorcaminho += distancias[k][s];

        
        return menorcaminho;
    }
}