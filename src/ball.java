public class ball {
    // boll startposition
    static double position_x =250;
    static double position_y =170;
    //boll hastighet
    static double velMov =5;
    static double vel_X = velMov;
    static double vel_Y = velMov;
    public static void BallPos(){
        //boarders för planen
        if(position_x >=500-10 || position_x <=0){
            vel_X = vel_X *-1;
        }
        if(position_x ==500-10){
            Panel.p1score++;
            //System.out.println("vänster score="+ Panel.p1score);
            ball.position_x =250;
            ball.position_y =170;
        }
        if(position_x <=0){
            Panel.p2score++;
            //System.out.println("höger score="+ Panel.p2score);
            ball.position_x =250;
            ball.position_y =170;
        }

        //Collision för SpelarSprites
        if(position_y >= Panel.panelHeight -10 || position_y <=0){
            vel_Y = vel_Y *-1;
        }
        if(position_y >=inputs.p1_yPos && position_y <=inputs.p1_yPos+22.5 && position_x ==20){
            vel_X = vel_X *-1;
            vel_Y = -velMov;
        }
        if(position_y >=inputs.p1_yPos+22.5 && position_y <=inputs.p1_yPos+45 && position_x ==20){
            vel_X = vel_X *-1;
            vel_Y = velMov;
        }
        if(position_y >=inputs.p2_yPos && position_y <=inputs.p2_yPos+22.5 && position_x ==470){
            vel_X = vel_X *-1;
            vel_Y = -velMov;
        }
        if(position_y >=inputs.p2_yPos+22.5 && position_y <=inputs.p2_yPos+45 && position_x ==470){
            vel_X = vel_X *-1;
            vel_Y = velMov;
        }
        position_x = position_x + vel_X;
        position_y = position_y + vel_Y;
    }

}

