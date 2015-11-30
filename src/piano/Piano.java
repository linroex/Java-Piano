/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Color;
/**
 *
 * @author linroex
 */
public class Piano extends javax.swing.JFrame {
    
    /**
     * Creates new form Piano
     */
    public Piano() {
        initComponents();
        
        this.setTitle("Piano");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PianoKeyPanel = new PianoKeyPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pianoResultTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PianoKeyPanel.setBackground(new java.awt.Color(255, 255, 255));
        PianoKeyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PianoKeyPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PianoKeyPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PianoKeyPanelLayout = new javax.swing.GroupLayout(PianoKeyPanel);
        PianoKeyPanel.setLayout(PianoKeyPanelLayout);
        PianoKeyPanelLayout.setHorizontalGroup(
            PianoKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        PianoKeyPanelLayout.setVerticalGroup(
            PianoKeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        pianoResultTextArea.setEditable(false);
        pianoResultTextArea.setColumns(20);
        pianoResultTextArea.setRows(5);
        jScrollPane1.setViewportView(pianoResultTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PianoKeyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PianoKeyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PianoKeyPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PianoKeyPanelMouseClicked
        int x = evt.getX();
        int y = evt.getY();
        
        int panelWidth = this.PianoKeyPanel.getWidth();
        
        int keyUnitWidth = panelWidth / 8;
        
        try {
            Robot robot = new Robot();
            Color color = robot.getPixelColor(x, y);
            
            if(color.getRGB() == -1) {  // White
                
                char[] blackKeyChar = new char[]{'C', 'D', 'E', 'F', 'G', 'A', 'B', 'C'};
                
                // detect white key click
                for(int i = 1; i < 9; i++) {
                    if(x < keyUnitWidth * i) {
                        this.pianoResultTextArea.append(blackKeyChar[i - 1] + " ");
                        break;
                    }
                }
                
            } else if(color.getRGB() == -16777216) {    // Black
                char[] whiteKeyChar = new char[]{'C', 'D', ' ', 'F', 'G', 'A'};
                
                // detect black key click
                for(int i = 6; i > 0; i--) {
                    if(i != 3) {
                        if(x > keyUnitWidth * i - 30) {
                            this.pianoResultTextArea.append("#" + whiteKeyChar[i - 1] + " ");
                            break;
                        }
                    }
                }
            }
        } catch (AWTException e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_PianoKeyPanelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Piano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Piano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Piano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Piano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Piano().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PianoKeyPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea pianoResultTextArea;
    // End of variables declaration//GEN-END:variables
}
