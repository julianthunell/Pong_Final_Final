import java.io.*;
import java.util.ArrayList;


public class score {
    public static int matchesplayed =0;
    public static ArrayList<String> match_data = new ArrayList<String>();
    public static int[] leaderboard_official = new int[10];
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

        // lägger till differens i slutet av stringen vilkt sedan används för att sortera
        int[][] leaderboard_data = new int[matchesplayed][4];
        for (int i = 0; i < matchesplayed; i++) {
            String element = match_data.get(i);
            int[] numbers = parseIntArray(element.split("-"));
            int diff;
            if (numbers[1]>numbers[2]){
                diff = numbers[1]-numbers[2];
            }
            else{
                diff = numbers[2]-numbers[1];
            }
            leaderboard_data[i][0]=numbers[0];
            leaderboard_data[i][1]=numbers[1];
            leaderboard_data[i][2]=numbers[2];
            leaderboard_data[i][3]=diff;
        }
        boolean swap=true;
        int temp_array []= new int[4];
        while (swap){
            swap=false;
            for (int i = 0; i < matchesplayed-1; i++) {
                if (leaderboard_data[i][3] < leaderboard_data[i+1][3]){
                    swap=true;
                    for (int j = 0; j < 4; j++) {
                        temp_array[j] = leaderboard_data[i][j];
                    }
                    for (int j = 0; j < 4; j++) {
                        leaderboard_data[i][j]=leaderboard_data[i+1][j];
                    }
                    for (int j = 0; j < 4; j++) {
                        leaderboard_data[i+1][j]=temp_array[j];
                    }
                }
            }
        }
        System.out.println("Top 5 matcher");
        for (int i = 0; i < 5; i++) {
            System.out.println("Match "+leaderboard_data[i][0]+": "+leaderboard_data[i][1]+" - "+leaderboard_data[i][2]);
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

