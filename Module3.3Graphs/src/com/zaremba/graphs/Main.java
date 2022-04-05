package com.zaremba.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    public static LinkedList<Integer> nodesToVisit = new LinkedList<>();
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        BFS();
    }

    /**
     * goes through a graph using a queue
     * each new node that has not been explored and is not in the queue gets added to it
     * continues until the queue is empty
     * @param node the current node the method is looking through
     */
    private static void BFS(Node node) {
        for(Integer linkedNodeKeys : node.getNodes()){
            Node linkedNode = getMatchingNode(linkedNodeKeys);
            if(!linkedNode.isVisited() && !nodesToVisit.contains(linkedNodeKeys)){
                nodesToVisit.add(linkedNodeKeys);
            }
        }
        node.setVisited(true);
        System.out.println("Node " + node.getKey() + " explored");
        nodesToVisit.removeFirst();
        if (nodesToVisit.size() != 0){
            BFS(getMatchingNode(nodesToVisit.getFirst()));
        }
    }

    /**
     * Given a specific node key, returns the node in the graph that matches that key if it exists
     * @param nodeKey key to search for
     * @return the matching node or null if none is found
     */
    private static Node getMatchingNode(int nodeKey){
        for(Node node : graph){
            if(node.getKey() == nodeKey){
                return node;
            }
        }
        return null;
    }

    /**
     * Initial default state of BFS in case no Node is specified
     * It will select the first node in a graph as long as the graph has at least one node
     * This won't always be the root
     */
    private static void BFS(){
        Node firstNode = graph.get(0);
        nodesToVisit.add(firstNode.getKey());
        BFS(firstNode);
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
