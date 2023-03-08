import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputs implements KeyListener {
    static int p1_yPos= Panel.panelHeight /2;
    static int p2_yPos= Panel.panelHeight /2;
    static boolean p1ner,p1upp,p2ner,p2upp;
    static int Move = 6;
    public static void move(){
        if (p1ner==true && p1_yPos<=350-45){
            p1_yPos=p1_yPos+Move;
        }
        if (p1upp==true && p1_yPos>=0){
            p1_yPos=p1_yPos-Move;
        }
        if (p2ner==true && p2_yPos<=350-45){
            p2_yPos=p2_yPos+Move;

        }
        if (p2upp==true&& p2_yPos>=0){
            p2_yPos=p2_yPos-Move;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int input = (e.getKeyCode());
        //System.out.println(input);
        switch (input){
            case 87:
                p1upp=true;
                break;
            case 83:
                p1ner=true;
                break;
            case 38:
                p2upp=true;
                break;
            case 40:
                p2ner=true;
                break;
            case 32:
                Panel.game=true;
                break;
            case 80:
                Panel.game=false;
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        int input = (e.getKeyCode());
        //System.out.println(input);
        switch (input) {
            case 87:
                p1upp = false;
                break;
            case 83:
                p1ner = false;
                break;
            case 38:
                p2upp = false;
                break;
            case 40:
                p2ner = false;
                break;
            case 76:
                score.leaderboard();
                break;
        }
    }
}
