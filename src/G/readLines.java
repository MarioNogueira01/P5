package G;

class readLines {
    private String inPut;
    public readLines(String inPut){
        this.inPut = inPut;
    }

    public static int[] readLine(String inPut){
        String[] tokens = inPut.split(" ",-1);
        int[] result = new int[tokens.length];
        for (int i = 0;i< tokens.length;i++){
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }

    public static Line[] Trajectory_creation(Ponto[] x){

        Line[] result_Line = new Line[x.length-1];
        for (int i = 1;i < x.length;i++){
            result_Line[i-1] = new Line(x[i-1],x[i]);
        }
        return result_Line;
    }
}
