package com.pathfinder.visualizer.algorithm;


import com.pathfinder.visualizer.model.*;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;



public class BFS implements PathfindingAlgorithm {
    

    public void execute( Maze maze, Cell start, Cell target ) {
        
        Queue< Cell > queue = new ArrayDeque<>();
        Map< Cell, Cell > parent = new HashMap<>();

        queue.add( start );
        parent.put( start, null );

        while( ! queue.isEmpty() ) {

            Cell current = queue.poll();

            if( current != start && current != target ) {
                current.setState( CellState.VISITED );
            }

            if( current == target ) {
                
                rebuildPath( parent, start, target );
            
            } else {

                List<Cell> neighbors = maze.getNeighbors( current );

                for( Cell neighbor : neighbors ) {

                    if( ! parent.containsKey( neighbor ) ) {
                        queue.add( neighbor );
                        parent.put( neighbor, current );
                    }
                
                }
            
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
