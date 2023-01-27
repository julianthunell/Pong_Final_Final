public class ball {
    // boll startposition
    static double Position_X=250;
    static double Position_Y=170;
    //boll hastighet
    static double VelMov=20;
    static double Vel_X=VelMov;
    static double Vel_Y=VelMov;
    public static void BallPos(){
        //boarders för planen
        if(Position_X>=500-10 || Position_X<=0){
            Vel_X = Vel_X*-1;
        }
        if(Position_X==500-10){
            Panel.p1score++;
            //System.out.println("vänster score="+ Panel.p1score);
            ball.Position_X=250;
            ball.Position_Y=170;
        }
        if(Position_X<=0){
            Panel.p2score++;
            //System.out.println("höger score="+ Panel.p2score);
            ball.Position_X=250;
            ball.Position_Y=170;
        }

        //Collision för SpelarSprites
        if(Position_Y>= Panel.PanelHeight-10 || Position_Y<=0){
            Vel_Y = Vel_Y*-1;
        }
        if(Position_Y>=inputs.p1_yPos && Position_Y<=inputs.p1_yPos+22.5 && Position_X==20){
            Vel_X = Vel_X*-1;
            Vel_Y = -VelMov;
        }
        if(Position_Y>=inputs.p1_yPos+22.5 && Position_Y<=inputs.p1_yPos+45 && Position_X==20){
            Vel_X = Vel_X*-1;
            Vel_Y = VelMov;
        }
        if(Position_Y>=inputs.p2_yPos && Position_Y<=inputs.p2_yPos+22.5 && Position_X==470){
            Vel_X = Vel_X*-1;
            Vel_Y = -VelMov;
        }
        if(Position_Y>=inputs.p2_yPos+22.5 && Position_Y<=inputs.p2_yPos+45 && Position_X==470){
            Vel_X = Vel_X*-1;
            Vel_Y = VelMov;
        }
        Position_X=Position_X+Vel_X;
        Position_Y=Position_Y+Vel_Y;
    }

}

