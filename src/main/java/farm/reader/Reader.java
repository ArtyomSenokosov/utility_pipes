package main.java.farm.reader;

import main.java.farm.component.Graph;
import main.java.farm.component.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Reader {

    public Graph readGraphFaster() throws IOException {
        Map<Integer, List<Node>> nodes = new HashMap<>();
        List<Integer> hubs = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberFarms = Integer.parseInt(stringTokenizer.nextToken());
        int numberRoads = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < numberRoads; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Integer numPoints = Integer.parseInt(stringTokenizer.nextToken());
            Integer numConveyor = Integer.parseInt(stringTokenizer.nextToken());
            int distance = Integer.parseInt(stringTokenizer.nextToken());

            if (nodes.containsKey(numPoints)) {
                nodes.get(numPoints).add(new Node(numConveyor, distance));
            } else {
                List<Node> adjacentList = new ArrayList<>();
                adjacentList.add(new Node(numConveyor, distance));
                nodes.put(numPoints, adjacentList);
            }

            if (nodes.containsKey(numConveyor)) {
                nodes.get(numConveyor).add(new Node(numPoints, distance));
            } else {
                List<Node> adjacentList = new ArrayList<>();
                adjacentList.add(new Node(numPoints, distance));
                nodes.put(numConveyor, adjacentList);
            }
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numberHubs = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numberHubs; i++) {
            hubs.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        return new Graph(numberFarms, numberRoads, numberHubs, hubs, nodes);
    }
}
