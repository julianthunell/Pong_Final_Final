public class game {
    private Frame frame;
    private Panel panel;
    public game(){
        panel = new Panel();
        frame = new Frame(panel);
        score.readMatchesPlayed();
        panel.requestFocus();

    }
}