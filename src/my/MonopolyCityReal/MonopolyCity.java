package my.MonopolyCityReal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MonopolyCity extends javax.swing.JFrame {

    Graphics g;
    int currentPosition[] = {0, 0, 0, 0};
    int oldPosition[] = {0, 0, 0, 0};
    boolean whosPlaying[] = {false, false, false, false};
    int whosPlayingInNum[] = {0, 0, 0, 0};
    int xCo[] = {610, 610, 610, 610, 610, 610, 460, 360, 270, 180, 20, 20, 20, 20, 20, 20, 180, 270, 360, 460};
    int yCo[] = {610, 460, 360, 270, 180, 20, 20, 20, 20, 20, 20, 180, 270, 360, 460, 610, 610, 610, 610, 610};
    String property[] = {"Start", "Kyoto", "Seoul", "Chance", "Chengdu", "Go To Jail", "San Juan", "Havana", "Community Chest", "Nassau", "Free Parking", "New York", "Banff", "Miami", "Community Chest", "Just Visiting", "Paris", "Venice", "Chance", "Athens"};
    int price[] = {0, 350, 300, 0, 400, 0, 220, 190, 0, 150, 0, 210, 270, 140, 0, 0, 320, 350, 0, 200};
    int owner[] = {10, 0, 0, 10, 0, 10, 0, 0, 10, 0, 10, 0, 0, 0, 10, 10, 0, 0, 10, 0};
    int rent[] = {0, 150, 140, 0, 160, 0, 130, 120, 0, 115, 0, 120, 125, 115, 0, 0, 135, 150, 0, 125};
    int bank[] = new int[4];
    Color ColorArray[] = {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE};
    String chanceOptions[] = {"Go to Jail.", "You have won a crossword competition. Collect 250$", "Go Back Three Spaces.", "Make general repairs on all your property. Pay 25$/home", "Pay poor tax of $15."};
    String communityChestOptions[] = {"Its a Holiday! Collect 300$", "Hospital Fees. Pay 200$", "Income Tax Refund. Collect 35$", "School Fees. Pay 150$", "It's your Birthday. Collect 50$."};
    Timer t;
    int playAgain = JOptionPane.NO_OPTION;

    public MonopolyCity() {
        initComponents();
        g = jLabel1.getGraphics();
        //create the new timer object with 50 millisecond duration
        t = new Timer(50, new TimerListener());
        t.start();//start the timer
        int input = Integer.parseInt(JOptionPane.showInputDialog("Enter number of players.(2-4)"));
        for (int i = 0; i < input; i++) {
            whosPlayingInNum[i] = 1;
            whosPlaying[i] = true;
            bank[i] = 1000;
        }
        amountOfPlayers = input;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Play = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/MonopolyCityReal/Finally (1).png"))); // NOI18N

        Play.setText("Start Turn");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/MonopolyCityReal/SomeDiceSix.png"))); // NOI18N
        jLabel2.setText("    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(Play)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Play)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int turnP = 1;
    int amountOfPlayers;
    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        if (playAgain == JOptionPane.YES_OPTION) {
            //resets
            for (int e = 0; e < 1; e++) {
                int input = Integer.parseInt(JOptionPane.showInputDialog("Enter number of players.(2-4)"));
                for (int i = 0; i < input; i++) {
                    whosPlayingInNum[i] = 1;
                    erasePlayer(turnP);
                    turnP = 1;
                    whosPlaying[i] = true;
                }
                amountOfPlayers = input;
            }
            for (int i = 0; i < currentPosition.length; i++) {
                currentPosition[i] = 0;
                oldPosition[i] = 0;
                whosPlaying[i] = false;
                whosPlayingInNum[i] = 1;
                bank[i] = 1000;
            }
            int[] reset = {10, 0, 0, 10, 0, 10, 0, 0, 10, 0, 10, 0, 0, 0, 10, 10, 0, 0, 10, 0};
            owner = reset;
            playAgain = JOptionPane.NO_OPTION;
        }
        for (int i = 1; i <= 2; i++) {
            if (amountOfPlayers < 2 || amountOfPlayers > 4) {
                amountOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Sorry please enter a vaild number."));
            }
        }
        int dieNum = rollDie();
        currentPosition[turnP - 1] += dieNum;
        if (currentPosition[turnP - 1] > 19) {
            currentPosition[turnP - 1] = currentPosition[turnP - 1] - 20;
        }

        g.setColor(ColorArray[turnP - 1]);
        g.fillRect(650, 26, 90, 20); //draw table

        drawDie(dieNum);
        erasePlayer(turnP);
        drawPlayer(turnP);
        banking(turnP);
        start(turnP);
        goToJail(turnP);
        chanceCard(turnP);
        communityChestCard(turnP);
        upProps();
        if (bankrupt(turnP) == false) {
            JOptionPane.showMessageDialog(this, "BANKRUPT!");
            whosPlaying[turnP - 1] = false;
            erasePlayer(turnP);
            whosPlayingInNum[turnP - 1] = 0;

        }
        switch (turnP) {
            case 1:
                if (bank[1] > 0) {
                    turnP = 2;
                } else if (bank[2] > 0) {
                    turnP = 3;
                } else if (bank[3] > 0) {
                    turnP = 4;
                }
                break;
            case 2:
                if (bank[2] > 0) {
                    turnP = 3;
                } else if (bank[3] > 0) {
                    turnP = 4;
                } else if (bank[0] > 0) {
                    turnP = 1;
                }
                break;
            case 3:
                if (bank[3] > 0) {
                    turnP = 4;
                } else if (bank[0] > 0) {
                    turnP = 1;
                } else if (bank[1] > 0) {
                    turnP = 2;
                }
                break;
            case 4:
                if (bank[0] > 0) {
                    turnP = 1;
                } else if (bank[1] > 0) {
                    turnP = 2;
                } else if (bank[2] > 0) {
                    turnP = 3;
                }
                break;
        }
        //check if they won and show
        if (IntStream.of(whosPlayingInNum).sum() == 1) {
            for (int i = 0; i <= 3; i++) {
                if (whosPlayingInNum[i] == 1) {
                    playAgain = JOptionPane.showConfirmDialog(this, "Player " + (i + 1) + " won, Congrats! Play Again?");
                    erasePlayer(i + 1);
                }
            }
        }


    }//GEN-LAST:event_PlayActionPerformed
    public void banking(int turnP) {
        if (bankrupt(turnP) == true) {
            if (owner[currentPosition[turnP - 1]] == 0 && bank[turnP - 1] > price[currentPosition[turnP - 1]]) { //if they can afford to buy
                int input = JOptionPane.showConfirmDialog(null, "You have landed on: " + property[currentPosition[turnP - 1]] + ".  Would you like to buy?");
                if (input == 0) { //if yes
                    bank[turnP - 1] = bank[turnP - 1] - price[currentPosition[turnP - 1]]; //subtracts price from their bank
                    owner[currentPosition[turnP - 1]] = turnP; //makes player the owner
                }
            } else if (owner[currentPosition[turnP - 1]] == 0 && bank[turnP - 1] <= price[currentPosition[turnP - 1]]) { //if they cant afford to buy
                JOptionPane.showMessageDialog(null, "You cannot afford " + property[currentPosition[turnP - 1]]);
            } else if (owner[currentPosition[turnP - 1]] <= 4) { //if someone else owns it
                if (turnP != owner[currentPosition[turnP - 1]]) {
                    JOptionPane.showMessageDialog(null, "Pay $" + rent[currentPosition[turnP - 1]] + " rent to player " + owner[currentPosition[turnP - 1]]);
                    if (bank[turnP - 1] >= rent[currentPosition[turnP - 1]]) { // if they can pay rent ..pay
                        bank[turnP - 1] = bank[turnP - 1] - rent[currentPosition[turnP - 1]]; //subtract rent from players bank
                        bank[owner[currentPosition[turnP - 1]] - 1] = bank[owner[currentPosition[turnP - 1]] - 1] + rent[currentPosition[turnP - 1]]; //adds money to owners bank
                    }
                    if (bank[turnP - 1] <= rent[currentPosition[turnP - 1]]) { //if they cant
                        JOptionPane.showMessageDialog(null, "Not enough money, give property to player " + owner[currentPosition[turnP - 1]]);
                        for (int i = 1; i <= owner.length; i++) {
                            if (owner[i - 1] == turnP) {
                                owner[i - 1] = owner[currentPosition[turnP - 1]];
                                bank[turnP - 1] = 0;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= amountOfPlayers; i++) {
            if (bankrupt(turnP) == false) {
                for (int j = 0; j < owner.length; j++) {
                    if (j == (turnP)) {
                        owner[j - 1] = 0;
                    }
                }
            }
        }
    }
    
  public void erasePlayer(int turnP) {//erase the players last position
        g.setColor(Color.white);
        switch (turnP) {
            case 1:
                eraseFillOval(xCo[oldPosition[turnP - 1]]);
                break;
            case 2:
                eraseFillOval(xCo[oldPosition[turnP - 1]] + 10);
                break;
            case 3:
                eraseFillOval(xCo[oldPosition[turnP - 1]] + 20);
                break;
            case 4:
                eraseFillOval(xCo[oldPosition[turnP - 1]] - 8);
                break;
        }
    }


     public void eraseFillOval(int xPoint) { //draw white oval
        g.fillOval(xPoint, yCo[oldPosition[turnP - 1]], 10, 10);
    }


     public int rollDie() { //roll a dice 1-6
        int roll = ran.nextInt(6) + 1;
        return roll;
    }


    Random ran = new Random();

      public void drawPlayer(int turnP) { //draw new players position
        g.setColor(ColorArray[turnP - 1]);
        switch (turnP) {
            case 1:
                drawFillOval(xCo[currentPosition[turnP - 1]]);
                break;
            case 2:
                drawFillOval(xCo[currentPosition[turnP - 1]] + 10);
                break;
            case 3:
                drawFillOval(xCo[currentPosition[turnP - 1]] + 20);
                break;
            case 4:
                drawFillOval(xCo[currentPosition[turnP - 1]] - 8);
                break;
        }
    }


     public void drawFillOval(int xPoint) { //draw the player filling oval
        oldPosition[turnP - 1] = currentPosition[turnP - 1];
        g.fillOval(xPoint, yCo[currentPosition[turnP - 1]], 10, 10);
    }


        public void goToJail(int turnP) {
        if (property[currentPosition[turnP - 1]].equals("Go To Jail")) {
            JOptionPane.showMessageDialog(this, "Go To Jail"); //display go to jail
            oldPosition[turnP - 1] = currentPosition[turnP - 1]; //update oldposition
            erasePlayer(turnP); //erase old spot
            currentPosition[turnP - 1] = 15; //move to jail
            drawPlayer(turnP); //draw at jail
        }
    }


     public void start(int turnP) {
        if (property[currentPosition[turnP - 1]].equals("Start")) {
            JOptionPane.showMessageDialog(this, "You have landed on Start. Collect 50$");
            bank[turnP - 1] = bank[turnP - 1] + 50; //put 50$ in players bank
        }
    }


      public void chanceCard(int turnP) {
        if (property[currentPosition[turnP - 1]].equals("Chance")) {// chance
            int rando = (int) (ran.nextInt(5) + 1);
            switch (rando) {
                case 1:
                    JOptionPane.showMessageDialog(this, "You have landed on Chance. Go to Jail.");
                    oldPosition[turnP - 1] = currentPosition[turnP - 1]; //update oldposition
                    erasePlayer(turnP); //erase old spot
                    currentPosition[turnP - 1] = 15; //move to jail
                    drawPlayer(turnP); //draw at jail
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "You have landed on Chance. " + chanceOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] + 250; //get 250$
                    break;
                case 3:
                    JOptionPane.showMessageDialog(this, "You have landed on Chance. " + chanceOptions[rando - 1]);
                    erasePlayer(turnP);
                    currentPosition[turnP - 1] = currentPosition[turnP - 1] - 3;//move back three spaces
                    drawPlayer(turnP);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(this, "You have landed on Chance. " + chanceOptions[rando - 1]);
                    int count = 0;
                    for (int i = 0; i < owner.length; i++) {
                        if (owner[i] == turnP) {
                            count++;
                        }
                    }
                    bank[turnP - 1] = bank[turnP - 1] - (count * 25); //Pay for $25 worth of upgrades on each house
                    break;
                case 5:
                    JOptionPane.showMessageDialog(this, "You have landed on Chance. " + chanceOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] - 15; //pay 15$
                    break;
            }
            for (int i = 1; i <= amountOfPlayers; i++) {
                if (bankrupt(i) == false) {
                    bank[i - 1] = 0;
                }
            }
        }
    }



       public void communityChestCard(int turnP) {
        if (property[currentPosition[turnP - 1]].equals("Community Chest")) {// chn
            int rando = (int) (ran.nextInt(6) + 1);
            switch (rando) {
                case 1:
                    JOptionPane.showMessageDialog(this, "You have landed on Community Chest. " + communityChestOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] + 300; //get 300$
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "You have landed on Community Chest. " + communityChestOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] - 200; //lose 200$
                    break;
                case 3:
                    JOptionPane.showMessageDialog(this, "You have landed on Community Chest. " + communityChestOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] + 35; //collect 35$
                    break;
                case 4:
                    JOptionPane.showMessageDialog(this, "You have landed on Community Chest. " + communityChestOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] - 150; //lose 150$
                    break;
                case 5:
                    JOptionPane.showMessageDialog(this, "You have landed on Community Chest. " + communityChestOptions[rando - 1]);
                    bank[turnP - 1] = bank[turnP - 1] + 50; //collect 50$
                    break;
            }
            for (int i = 1; i <= amountOfPlayers; i++) {
                if (bankrupt(i) == false) {
                    bank[i - 1] = 0;
                }
            }
        }
    }


    public boolean bankrupt(int turnP) {
        return bank[turnP - 1] > 0; //if bank has money in it(true)... its is not bankrupt
    }


    public void drawDie(int dieNum) {
        switch (dieNum) { //change image for dice roll
            case 1:
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("SomeDiceOne.png")));
                break;
            case 2:
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("SomeDiceTwo.png")));
                break;
            case 3:
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("SomeDiceThree.png")));
                break;
            case 4:
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("SomeDiceFour.png")));
                break;
            case 5:
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("SomeDiceFive.png")));
                break;
            case 6:
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("SomeDiceSix.png")));
                break;
        }
    }


    public void timer() {
        t = new Timer(20, new TimerListener());
    }

    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            upProps();// call your table draw method once
            t.stop(); // immediately stop the timer so it will only run once
        }
    }

    public void upProps() {
        int tableX = 675;
        int tableY = 40;
        g.setColor(Color.white);
        g.fillRect(tableX - 25, tableY - 50, 500, 150); //draw table
        g.setColor(Color.black);

        g.drawString("Player", tableX, tableY - 20);
        for (int i = 0; i < amountOfPlayers; i++) {
            g.drawString(String.valueOf(i + 1), tableX, tableY + (i + 1) * 20);
        }
        tableX += 50;
        g.drawString("Price:", tableX, tableY - 20);
        for (int i = 0; i < amountOfPlayers; i++) {
            g.drawString(String.valueOf(price[currentPosition[i]]), tableX, tableY + (i + 1) * 20);
        }
        tableX += 50;
        g.drawString("Rent:", tableX, tableY - 20);
        for (int i = 0; i < amountOfPlayers; i++) {
            g.drawString(String.valueOf(rent[currentPosition[i]]), tableX, tableY + (i + 1) * 20);
        }
        tableX += 50;
        g.drawString("Owner:", tableX, tableY - 20);
        for (int i = 0; i < amountOfPlayers; i++) {
            if (owner[currentPosition[i]] == 10) {
                g.drawString("none", tableX, tableY + (i + 1) * 20);
            } else {
                g.drawString(String.valueOf(owner[currentPosition[i]]), tableX, tableY + (i + 1) * 20);
            }
        }
        tableX += 50;
        g.drawString("Place:", tableX, tableY - 20);
        for (int i = 0; i < amountOfPlayers; i++) {
            g.drawString(String.valueOf(property[currentPosition[i]]), tableX, tableY + (i + 1) * 20);
        }

        
       

        tableX = 675;
        tableY = 190;
        g.setColor(Color.white);
        g.fillRect(tableX - 25, tableY - 40, 500, 390); //draw table
        g.setColor(Color.black);
        g.drawString("Owner:", tableX, tableY - 15);
        for (int i = 0; i < owner.length; i++) {
            if (owner[i] == 10) {
                tableY = tableY + 17;
                g.drawString("none", tableX, tableY);
            } else {
                tableY = tableY + 17;
                g.drawString(String.valueOf(owner[i]), tableX, tableY);
            }
        }
        tableX = 745;
        tableY = 190;
        g.drawString("Place:", tableX, tableY - 15);
        for (String property1 : property) {
            tableY = tableY + 17;
            g.drawString(String.valueOf(property1), tableX, tableY);
        }

        tableX = 675;
        tableY = 600;
        g.setColor(Color.white);
        g.fillRect(tableX - 25, tableY - 50, 500, 100); //draw table
        g.setColor(Color.black);
        g.drawString("Bank:", tableX, tableY - 20);
        for (int i = 0; i < amountOfPlayers; i++) {
            g.drawString("Player " + (i + 1), tableX + i * 64, tableY);
        }
        tableY += 20;
        for (int i = 0; i < amountOfPlayers; i++) {
            g.drawString(String.valueOf(bank[i]), tableX, tableY);
            tableX += 64;
        }
    }


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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
