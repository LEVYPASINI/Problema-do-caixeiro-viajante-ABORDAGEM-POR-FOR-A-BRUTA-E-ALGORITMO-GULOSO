
public class main{
    public static void main(String[] args) {

        TSPFORCABRUTA prog1;
        
        prog1 = new TSPFORCABRUTA();
        
        TSPGULOSO prog2;
        
        prog2 = new TSPGULOSO();
        
        int[][] cities = {
            {0, 0},
            {1, 1},
            {2, 2},
            {3, 3},
            {4, 4},
            {5, 5},
            {6, 6},
            {7, 7},
            {8, 8},
            {9, 9},
            {10, 10},
            {11, 11},
            {12, 12},
            {13, 13},
        };
        
        int numCities = cities.length;
        double[][] distancias = new double[numCities][numCities];

        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                if (i != j) {
                    distancias[i][j] = prog1.distanciaeuclidiana(cities[i], cities[j]);
                    //System.out.println("distancia de " + i + " para " + j + " " + distancias[i][j] );
                } else {
                    distancias[i][j] = Integer.MAX_VALUE; 
                }
            }
        }

        int cidadeinicial = 0;

        //System.out.println("Menor caminho: " + prog1.caixeiroviajante(distancias, cidadeinicial));
        System.out.println("========================");
        System.out.println("Menor caminho: " + prog2.caixeiroviajanteguloso(distancias, cidadeinicial));
    }

}
