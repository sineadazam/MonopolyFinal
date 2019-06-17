package my.MonopolyCityReal;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MonopolyCity extends javax.swing.JFrame {
Graphics g;
    int currentPosition = 0;
    int xCo[] = {610, 610, 610, 610, 610, 610, 460, 360, 270, 180, 20, 20, 20, 20, 20, 20, 180, 270, 360, 460};
    int yCo[] = {610, 460, 360, 270, 180, 20, 20, 20, 20, 20, 20, 180, 270, 360, 460, 610, 610, 610, 610, 610};
    String property [] = {"Start", "Kyoto", "Seoul", "Chance", "Chengdu", "Go To Jail", "San Juan", "Havana", "Community Chest", "Nassau", "Free Parking", "New York", "Banff", "Miami", "Community Chest", "Just Visiting", "Paris", "Venice", "Chance", "Athens"};
    int price [] = {0, 350, 300, 0, 400, 0, 220, 190, 0, 150, 0, 210, 270, 140, 0, 0, 320, 350, 0, 200};
    int owner[] = {10, 0, 0, 10, 0, 10, 0, 0, 10, 0, 10, 0, 0, 0, 10, 0, 0, 10, 0, 10};
    int rent [] = {0, 50, 40, 0, 60, 0, 30, 20, 0, 15, 0, 20, 25, 15, 0, 0, 35, 50, 0, 25};
    int bank [] = {1500, 1500, 1500, 1500};
    Timer t;
    
    public MonopolyCity() {
        initComponents();
        g = jLabel1.getGraphics();
        upProps(); // call method to do the drawing of your properties table
        //create the new timer object with 50 millisecond duration
        t = new Timer(50, new TimerListener()); 
        t.start();//start the timer
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Play = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/MonopolyCityReal/Finally (1).png"))); // NOI18N

        Play.setText("Start Turn");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(Play))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(Play)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        int turnP = 1;
        switch (turnP) {
            case 1:
                g.setColor(Color.white);
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10); //erase player one
                currentPosition = ((int) ((Math.random() * 6)+1)) + currentPosition;
                if (currentPosition > 19) {
                    currentPosition = currentPosition - 20;
                }
                g.setColor(Color.blue); //player one
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10);
                if (owner[currentPosition] == 0) {
                    int input = JOptionPane.showConfirmDialog(null, "Would you like to buy");
                    if (input == 0) {
                        bank[turnP-1] = bank[turnP-1] - price[currentPosition];
                        owner[currentPosition] = 1;
                    }
                } else {
                    bank[turnP-1] = bank[turnP-1] - rent[currentPosition];
                    bank[owner[currentPosition]] = bank[owner[currentPosition]] + rent[currentPosition];
                }
                turnP++;
               
            case 2:
                g.setColor(Color.white);
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10); //erase player two
                currentPosition = ((int) ((Math.random() * 6)+1)) + currentPosition;
                if (currentPosition > 19) {
                    currentPosition = currentPosition - 20;
                }
                g.setColor(Color.red); //player two
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10);
                //Get x and y coordinates for player from position pos in xC and yC
                turnP++;
                
            case 3:
                g.setColor(Color.white);
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10); //erase player three
                currentPosition = ((int) ((Math.random() * 6)+1)) + currentPosition;
                if (currentPosition > 19) {
                    currentPosition = currentPosition - 20;
                }
                g.setColor(Color.green); //player three
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10);
                //Get x and y coordinates for player from position pos in xC and yC
                turnP++;
            case 4:
                g.setColor(Color.white);
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10); //erase player four
                currentPosition = ((int) ((Math.random() * 6)+1)) + currentPosition;
                if (currentPosition > 19) {
                    currentPosition = currentPosition - 20;
                }
                g.setColor(Color.orange); //player four
                g.fillOval(xCo[currentPosition], yCo[currentPosition], 10, 10);
                //Get x and y coordinates for player from position pos in xC and yC
                turnP++;
        }
    }//GEN-LAST:event_PlayActionPerformed

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            upProps();// call your table draw method once
            t.stop(); // immediately stop the timer so it will only run once
        }
    }
    public void upProps() {
        int tableX = 700;
            int tableY = 100;
            g.setColor(Color.white);
            g.fillRect(tableX-50, tableY-50, 400, 300);
            g.setColor(Color.black);
            for (int k = 0; k < 4; k++) {
                g.drawString(property[k], tableX, tableY);
                g.drawString(String.valueOf(price[k]), tableX + 100, tableY);
                g.drawString(String.valueOf(rent[k]), tableX + 150, tableY);
                g.drawString(String.valueOf(owner[k]),tableX+200,tableY);
                tableY = tableY + 20;
            }
        tableX = 700;
        tableY = 400;
            g.drawString("Player 1      Player 2      Player 3       Player4", tableX, tableY);
            tableY= tableY + 20;
            for(int w = 0; w<4; w++){
            g.drawString(String.valueOf(bank[w]),tableX, tableY);
            tableX=tableX+64;
        }
    }
//private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        // change the color of the box in the label
//        if (colourSpot == 0){
//        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redSpot.jpg")));
//        colourSpot = 1;
//        }else{
//             jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blueSpot.jpg")));
//             colourSpot = 0;
//        }
//    }   
    
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
            java.util.logging.Logger.getLogger(MonopolyCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonopolyCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonopolyCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonopolyCity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonopolyCity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Play;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
