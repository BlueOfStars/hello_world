package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Dijkstra {

    private int[][] matrix;

    private char[] vertex;

    private int edge;

    private final int MAX_PATH;

    public Dijkstra(){
        MAX_PATH = 1000;
        matrix = new int[][]{
                {0,1,5, MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH},
                {1,0,3,7,5, MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH},
                {5,3,0, MAX_PATH,1,7, MAX_PATH, MAX_PATH, MAX_PATH},
                {MAX_PATH,7, MAX_PATH,0,2, MAX_PATH,3, MAX_PATH, MAX_PATH},
                {MAX_PATH,5,1,2,0,3,6,9, MAX_PATH},
                {MAX_PATH, MAX_PATH,7, MAX_PATH,3,0, MAX_PATH,5, MAX_PATH},
                {MAX_PATH, MAX_PATH, MAX_PATH,3,6, MAX_PATH,0,2,7},
                {MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH,9,5,2,0,4},
                {MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH, MAX_PATH,7,4,0},
        };
        vertex = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        edge = 16;
    }

    public void dijkstraMinPath(int startVertex){
        int[] preVertex = new int[vertex.length];
        int[] minPath = new int[vertex.length];
        Set<Integer> vertex = new HashSet<>();
        for (int i = 0; i < minPath.length; i++) {
            minPath[i] = matrix[startVertex][i];
            if(MAX_PATH == minPath[i])
                preVertex[i] = -1;
            else
                preVertex[i] = startVertex;
        }
        vertex.add(startVertex);
        int k = 0;
        for (int i = 1; i < minPath.length; i++) {
            int min = MAX_PATH;
            for (int j = 0; j < minPath.length; j++) {
                if(!vertex.contains(j) && minPath[j] < min){
                    min = minPath[j];
                    k = j;
                }
            }
            vertex.add(k);
            for (int j = 0; j < minPath.length; j++) {
                if(!vertex.contains(j) && (min + matrix[k][j]) < minPath[j]){
                    preVertex[j] = k;
                    minPath[j] = min + matrix[k][j];
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < minPath.length; i++) {
            System.out.print(startVertex);
            int pre = i;
            while(preVertex[pre] != startVertex){
                stack.push(preVertex[pre]);
                pre = preVertex[pre];
            }
            while(!stack.isEmpty()){
                System.out.print( " --> " + stack.pop());
            }
            System.out.println( " --> " + i + " : " + minPath[i]);
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstraMinPath(1);
    }

}
