package com.pathfinder.visualizer.algorithm;


import com.pathfinder.visualizer.model.*;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AStar implements PathfindingAlgorithm {


    public void execute( Maze maze, Cell start, Cell target ) {

        Map< Cell, Integer > distance = new HashMap<>();
        Map< Cell, Cell > parent = new HashMap<>();
        Set<Cell> visited = new HashSet<>();

        Queue< Cell > pq = new PriorityQueue<>( ( x, y ) -> ( distance.get( x ) + heuristic( x, target ) ) - ( distance.get( y ) + heuristic( y, target ) ) );

        pq.add( start );
        parent.put( start, null );

        initDistance( maze, distance );
        distance.put( start, 0 );

        while( ! pq.isEmpty() ) {

            Cell current = pq.poll();

            if( current == target ) {

                rebuildPath( parent, start, target );

            } else {

                if( ! visited.contains( current ) ) {

                    if( current != start && current != target ) {
                        current.setState( CellState.VISITED );
                    }
                    
                    visited.add( current );

                    List<Cell> neighbors = maze.getNeighbors( current );

                    for( Cell neighbor : neighbors ) {

                        int newDist = distance.get( current ) + neighbor.getWeight();

                        if( newDist < distance.get( neighbor ) ) {
                            distance.put( neighbor, newDist );
                            parent.put( neighbor, current );
                            pq.add( neighbor );
                        }

                    }

                } else { continue; }

            }
            
        }

    }


    private int heuristic( Cell cell, Cell target ) {
        return Math.abs( cell.getRow() - target.getRow() ) + Math.abs( cell.getColumn() - target.getColumn() );
    }


    private void initDistance( Maze maze, Map< Cell, Integer > distance ) {
        for( int i = 0; i < maze.getRows(); i++ ) {
            for( int j = 0; j < maze.getColumns(); j++ ) {
                distance.put( maze.getCell( i, j ), Integer.MAX_VALUE );
            }
        }
    }


    private void rebuildPath( Map< Cell, Cell > parent, Cell start, Cell target ) {

        List<Cell> path = new ArrayList<>();
        Cell current = target;

        while( current != start ) {
            path.add( current );
            current = parent.get( current );
        }

        path.add( start );

        for( Cell cell : path ) {
            
            if( cell != start && cell != target ) {
                cell.setState( CellState.INPATH );
            }
        
        }

    }


    public void stop() {}
    
}
