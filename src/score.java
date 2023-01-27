import java.io.*;
import java.util.ArrayList;


public class score {
    public static int matchesplayed =0;
    public static ArrayList<String> match_data = new ArrayList<String>();
    public static String[] leaderboard_data = new String[10];
    public static String[] leaderboard_official = new String[10];

    public static void readMatchesPlayed(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./matches_played.txt"));

            //läser in matches?played
            String str_matchesplayed=reader.readLine();
            matchesplayed =Integer.parseInt(str_matchesplayed);

            //läser in alla rader lägger till en arraylist
            BufferedReader reader2 = new BufferedReader(new FileReader("./scoreboard_values.txt"));
            String row;
            while((row = reader2.readLine())!= null){
                //System.out.println(row);
                match_data.add(row);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void SaveScore(){
        //fixar antalet matcher spelade och gör till string
        matchesplayed++;
        String filematches_played = Integer.toString(matchesplayed);
        // sparar score i string
        String sparad_score=Panel.p1score +"-"+Panel.p2score;
        //System.out.println(sparad_score);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./scoreboard_values.txt",true));
            if (matchesplayed != 1){
                writer.newLine();
            }
            writer.write(matchesplayed+"-"+sparad_score);
            writer.close();
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("./matches_played.txt"));
            writer2.write(filematches_played);
            writer2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void leaderboard(){
        for (int i = 0; i < matchesplayed; i++) {
            String element = match_data.get(i);

            int[] numbers = parseIntArray(element.split("-"));

            for (int j = 0; j <= 10; j++) {

            }

        }
    }

    public static int[] parseIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            String value = strArray[i];
            intArray[i] = Integer.parseInt(value);
        }

        return intArray;
    }
}

