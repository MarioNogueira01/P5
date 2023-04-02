package J;
import java.lang.reflect.*;
import java.util.*;
public class Main {
    public static String capital(String s) {
        String res = s.toLowerCase();
        Character initial = Character.toUpperCase(res.charAt(0));
        StringBuilder sb = new StringBuilder(res);
        sb.setCharAt(0, initial);
        final String answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);


        int [] Starting = readLines.readLine(sc.nextLine());
        Ponto Starting_Point = new Ponto(Starting[0],Starting[1]);

        int [] finish = readLines.readLine(sc.nextLine());
        Ponto End_Point = new Ponto(finish[0],finish[1]);

        int t = sc.nextInt();
        int[] points_n = new int[t];

        for (int i = 0; i<t;i++){
            points_n[i] = sc.nextInt();
        }

        Trajectory[] result = new Trajectory[t];

        List<FiguraGeometrica> obstaculos = new ArrayList<>();
        Constructor<?> constructor;
        ArrayList[] pontos = new ArrayList[t];
        FiguraGeometrica f;
        String s;
        String [] aos;
        for (int i = 0; i<t;i++){
            pontos[i] = RandomCreation.random_Trajectory(points_n[i],Starting_Point,End_Point);
            result[i] = new Trajectory(pontos[i]);
        }
        sc.nextLine();
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            aos = s.split(" ");
            try {
                Class<?> cl = Class.forName("J." + capital(aos[0]));// da a class que vai ser usada
                constructor = cl.getConstructor (new Class<?>[] { String.class });
                f = (FiguraGeometrica) constructor.newInstance(s);
                f.check();
                obstaculos.add(f);
            }
            catch (Exception e) {
                System.out.println("Tipo de obstaculo desconhecido");
                System.exit(0);
            }
        }
        //TODO: ver resultado final o que esta a dar mal
        for (int i = 0; i<t;i++) {
            System.out.println(String.format("%f", result[i].avaluation(obstaculos)));
        }
        sc.close();
    }
}