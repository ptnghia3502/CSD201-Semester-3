/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleGraphs;
import simpleGraphs.com.OrderedList;
import simpleGraphs.vertex.*;
/**
 *
 * @author Nghia
 */
public abstract class AbstractGraph extends VertexList {
    public static int MAXTYPE = 4;
    public static int UNDIRECRED = 0;
    public static int DIRECTED = 1;
    public static int UNDIRECTED_WEIGHTED = 2;
    public static int DIRECTED_WEIGHTED = 3;
    public int graphType = 0;
    public AbstractGraph() {
        super();
    }
    public AbstractGraph (int graphType) {
        super();
        if (graphType >= 0 && graphType<MAXTYPE)
            this.graphType = graphType;
        else throw new RuntimeException("Invalid graph type!");
    }
    public abstract boolean loadGraph();
    
    public void addAdj(String srcKey, String destKey) {
        Vertex src = addVertex(srcKey);
        Vertex dest = addVertex(destKey);
        AdjInfo adj = new AdjInfo(dest,1);
        src.adjList.add(adj);
    }
    public void addAdj(String srcKey, String destKey, double weight) {
        Vertex src = addVertex(srcKey);
        Vertex dest = addVertex(destKey);
        AdjInfo adj = new AdjInfo(dest,weight);
        src.adjList.add(adj);
    }
    public AdjInfo getAdjInfo(Vertex src, Vertex dest) {
        AdjInfo adj = new AdjInfo(dest,1);
        OrderedList<AdjInfo> adjList = src.adjList;
        return adjList.search(adj);
    }
}
