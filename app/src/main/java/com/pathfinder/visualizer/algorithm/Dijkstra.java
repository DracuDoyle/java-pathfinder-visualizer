package com.pathfinder.visualizer.algorithm;


import com.pathfinder.visualizer.model.*;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



public class Dijkstra implements PathfindingAlgorithm {


    public void execute( Maze maze, Cell start, Cell target ) {

        Map< Cell, Integer > distance = new HashMap<>();
        Map< Cell, Cell > parent = new HashMap<>();
        Set<Cell> visited = new HashSet<>();

        Queue< Cell > pq = new PriorityQueue<>( ( x, y ) -> distance.get( x ) - distance.get( y ) );

        pq.add( start );
        parent.put( start, null );
        visited.add( start ); // despues de sacarlo de la cola segun

        initDistance( maze, distance );
        distance.put( start, 0 );

        while( ! pq.isEmpty() ) {

            // a. Sacar celda con menor distancia → current
            // b. SI current == target → reconstruir camino y terminar
            // c. SI current ya está en visited → continue
            // d. Agregar current a visited y marcarlo como VISITED

        }

    }


    private void initDistance( Maze maze, Map< Cell, Integer > distance ) {
        for( int i = 0; i < maze.getRows(); i++ ) {
            for( int j = 0; j < maze.getColumns(); j++ ) {
                distance.put( maze.getCell( i, j ), Integer.MAX_VALUE );
            }
        }
    }

    
    public void stop() {}
    
}
