
class FloydWarshall {

    final static int INF = 99999;

    public void floydWarshallAlgorithm(int graph[][], int input_number, int N) {
        int dist[][] = new int[N][N];
        int i, j, k;

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < N; k++) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist, input_number, N);
    }

    void printSolution(int dist[][], int input_number, int N) {
        System.out.println("Caso " + input_number + ": ");
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int inputs[][][] = {
            {               
                {0} // Valor esperado: 0
            },
            {
                {0, INF},// Valor esperado: mesma matriz
                {INF, 0}
            },
            {
                /*
                    Valor esperado: 
                    0   2   1   
                    1   0   2   
                    3   2   0
                 */
                {0, 2, 1},
                {1, 0, 2},
                {50, 2, 0}
            },
            {
                /*
                    Valor esperado: 
                    0   2   1   
                    1   0   2   
                    2   1   0
                 */
                {0, 500, 1},
                {1, 0, 500},
                {500, 1, 0}
            }
        };
        FloydWarshall a = new FloydWarshall();
        for (int i = 0; i < inputs.length; i++) {
            a.floydWarshallAlgorithm(inputs[i], (i + 1), inputs[i].length);
        }
    }
}
