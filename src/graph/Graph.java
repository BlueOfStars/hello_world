package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private char[] vertices;

    private boolean[] visited;

    private int[][] arcs;

    public Graph(){
        vertices = new char[]{'a', 'b', 'c', 'd', 'e'};
        visited = new boolean[5];
        arcs = new int[5][5];

        arcs[0][1] = 1;
        arcs[0][2] = 1;
        arcs[0][3] = 1;
        arcs[1][3] = 1;
        arcs[1][4] = 1;
        arcs[2][3] = 1;
        arcs[3][4] = 1;

        arcs[1][0] = 1;
        arcs[2][0] = 1;
        arcs[3][0] = 1;
        arcs[3][1] = 1;
        arcs[4][1] = 1;
        arcs[3][2] = 1;
        arcs[4][3] = 1;
    }

    public Graph(char[] vertices, boolean[] visited, int[][] arcs){
        this.vertices = vertices;
        this.visited = visited;
        this.arcs = arcs;
    }

    public void traverse(int i){
        visited[i] = true;
        System.out.print(vertices[i]+" ");
        for (int j = 0; j < arcs[i].length; j++) {
            if(arcs[i][j] == 1 && visited[j] == false)
                traverse(j);
        }
    }

    public void DFSTraverse(){
        System.out.print("dfs递归实现  ：");
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == false)
                traverse(i);
        }
        System.out.println();
    }

    public void DFSNotRecursion(){
        System.out.print("dfs非递归实现：");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < visited.length; i++) {
            if(false == visited[i]){
                visited[i] = true;
                System.out.print(vertices[i] + " ");
                stack.push(i);
            }
            while(!stack.isEmpty()){
                Integer node = stack.pop();
                for (int j = 0; j < arcs[node].length; j++) {
                    if(1 == arcs[node][j] && false == visited[j]){
                        visited[j] = true;
                        System.out.print(vertices[j] + " ");
                        stack.push(j);
                        break;
                    }
                }
            }
        }
        System.out.println();
    }

    public void BFSNotRecoursion(){
        System.out.print("bfs非递归实现：");
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < visited.length; i++) {
            if(false == visited[i]){
                visited[i] = true;
                System.out.print(vertices[i] + " ");
                queue.offer(i);
            }
            while(!queue.isEmpty()){
                int node = queue.poll();
                for (int j = 0; j < arcs[node].length; j++) {
                    if(1 == arcs[node][j] && false == visited[j]){
                        visited[j] = true;
                        System.out.print(vertices[j] + " ");
                        queue.offer(j);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.DFSTraverse();
        graph.DFSNotRecursion();
        graph.BFSNotRecoursion();
    }

}
