package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DirectedGraph {
    private final int Vertexnum;
    private final int[][] Edge;

    public DirectedGraph(int Vertexnum, int[][] Edge) {
        this.Vertexnum = Vertexnum;
        this.Edge = Edge;
    }

    public static StringBuilder FindCycle(DirectedGraph graph) {
        int[][] degree = new int[graph.Vertexnum][2];
        boolean[] v = new boolean[graph.Vertexnum];
        for (int[] a : graph.Edge) for (int i = 0; i < 2; i++) degree[a[i]][i]++;
        for (boolean flag = true; flag; ) {
            flag = false;
            for (int i = 0; i < graph.Vertexnum; i++)
                if (flag = (degree[i][0] == 0 || degree[i][1] == 0) && (!v[i])) {
                    v[i] = true;
                    for (int[] b : graph.Edge)
                        for (int j = 0; j < 2; j++) if (b[j] == i) for (int l = 0; l < 2; l++) degree[b[l]][l]--;
                }
        }
        return new StringBuilder(Arrays.stream(graph.Edge).filter(ints -> !(v[ints[0]] || v[ints[1]])).map(Arrays::toString).collect(Collectors.joining()).replace(" ", "").replace('[', '(').replace(']', ')'));
    }
}