/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 *
 * @author linroex
 */
class PianoKeyPanel extends JPanel {

    public PianoKeyPanel() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();
        
        int keyUnitWidth = panelWidth / 8;
        
        Graphics2D pen = (Graphics2D) g;
        
        pen.setStroke(new BasicStroke(3));
        
        // Draw white key
        for(int i = 1; i < 8; i++) {
            int x = panelWidth - keyUnitWidth * i;
            
            pen.drawLine(x, 0, x, panelHeight);
        }
        
        // Draw black key
        for(int i = 1; i < 7; i++) {
            if(i != 3) {
                int x = (keyUnitWidth * i) - 30;
                pen.fillRect(x, 0, keyUnitWidth - 30, (int) (panelHeight * 0.7));
            }
        }
    }
    
}
