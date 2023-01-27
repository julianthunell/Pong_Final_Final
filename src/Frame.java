import javax.swing.*;

public class Frame {
    private JFrame window;
    public Frame(Panel panel){
        window = new JFrame(); //skapar fönster
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //när fönstret stängs slutar programmet köras
        window.add(panel); //lägger till panelen vilket är allt grafik som ritas
        window.pack(); //sätter fönstret till rätt storlek
        window.setLocationRelativeTo(null); //sätter fönstret mitt i skärmen
        window.setVisible(true);

    }
}
