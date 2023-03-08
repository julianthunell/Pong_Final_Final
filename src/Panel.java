import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener{
    static public boolean game = false;
    Timer timer;
    public static int panelHeight = 350;
    public static int p1score=0;
    public static int p2score=0;
    // tar in bilder för Start screen och alla siffror
    Image bakgrund;
    Image score0;
    Image score1;
    Image score2;
    Image score3;
    Image score4;
    Image score5;


    public Panel(){
        //timmer som bestämmer hur ofta bilden repaintas varje milliseknd
        // listener är Min actionlistener, "this" eftersom den är implementerad i classen
        timer = new Timer(1,this);
        timer.start();
        bakgrund = new ImageIcon("pixil-frame-0.png").getImage();
        score0 = new ImageIcon("0.png").getImage();
        score1 = new ImageIcon("1.png").getImage();
        score2 = new ImageIcon("2.png").getImage();
        score3 = new ImageIcon("3.png").getImage();
        score4 = new ImageIcon("4.png").getImage();
        score5 = new ImageIcon("5.png").getImage();
        this.setPreferredSize(new Dimension(500, panelHeight));
        addKeyListener(new inputs());

    }
    //paint metoden som gör själva ritandet
    public void paint (Graphics g) {
        Graphics2D G = (Graphics2D) g;
            super.paint(g);
            if(game==true){ //rita spel
                G.fillRect((int)ball.position_x,(int)ball.position_y, 10, 10);
                G.fillRect(10,inputs.p1_yPos,10,45);
                G.fillRect(480,inputs.p2_yPos,10,45);
                for (int i = 0; i < 350; i=i+10) {
                    G.fillRect(249, i, 2, 5);


                }
                //p1 score
                if (p1score==0){G.drawImage(score0, 200-32, 0, null);}
                if (p1score==1){G.drawImage(score1, 200-32, 0, null);}
                if (p1score==2){G.drawImage(score2, 200-32, 0, null);}
                if (p1score==3){G.drawImage(score3, 200-32, 0, null);}
                if (p1score==4){G.drawImage(score4, 200-32, 0, null);}
                if (p1score==5){G.drawImage(score5, 200-32, 0, null);}
                //p2 score
                if (p2score==0){G.drawImage(score0, 300, 0, null);}
                if (p2score==1){G.drawImage(score1, 300, 0, null);}
                if (p2score==2){G.drawImage(score2, 300, 0, null);}
                if (p2score==3){G.drawImage(score3, 300, 0, null);}
                if (p2score==4){G.drawImage(score4, 300, 0, null);}
                if (p2score==5){G.drawImage(score5, 300, 0, null);}

            }
            if (game==false){ //ritar
                G.fillRect(20,20,20,20);
                G.drawImage(bakgrund,0,0,null);
            }
        }
    // checkar values och peformar "repaint" metoden varje millisekund
    public void actionPerformed(ActionEvent e) {
        //stänger av spelet ifall score = 5
        if (p1score==5 || p2score==5) {
            score.SaveScore();
            score.readMatchesPlayed();
            p1score = 0;
            p2score = 0;
            inputs.p1_yPos= Panel.panelHeight /2;
            inputs.p2_yPos= Panel.panelHeight /2;
            game=false;
        }
        //checkar nya inputs från tangentbord
        inputs.move();
        //kör boll programmet ifall spelet är igång
        if (game==true){
            ball.BallPos();
        }
        repaint();

    }

}
