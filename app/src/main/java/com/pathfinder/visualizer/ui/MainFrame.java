package com.pathfinder.visualizer.ui;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.pathfinder.visualizer.model.*;


public class MainFrame extends JFrame {
    
    public MainFrame() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = ( int ) ( screenSize.width * 0.8 );
        int height = ( int ) ( screenSize.height * 0.8 );
        setSize( width, height );

        setTitle( "Pathfinder Visualizer" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );

        Maze maze = new Maze( 10, 20 );
        GridPanel gp = new GridPanel( maze );
        add( gp );

        setVisible( true );
        
    }

}
