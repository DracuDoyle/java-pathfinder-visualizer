package com.pathfinder.visualizer.algorithm;


import com.pathfinder.visualizer.model.*;


public interface PathfindingAlgorithm {
    
    void execute( Maze maze, Cell start, Cell target );
    void stop();

}
