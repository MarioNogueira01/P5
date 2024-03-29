package G;
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

        int [] line = readLines.readLine(sc.nextLine());

        List<FiguraGeometrica> obstaculos = new ArrayList<>();
        Constructor<?> constructor;
        ArrayList<Ponto> pontos = new ArrayList<>();
        FiguraGeometrica f;
        String s;
        String [] aos;
        for (int i = 0; i<line.length-1;i+=2){
            Ponto cordenada = new Ponto(line[i],line[i+1]);
            pontos.add(cordenada);
        }
        Trajectory traj = new Trajectory(pontos);
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            aos = s.split(" ");
            try {
                Class<?> cl = Class.forName("G." + capital(aos[0]));// da a class que vai ser usada
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
        System.out.println(String.format("%.2f",traj.avaluation(obstaculos)));
        sc.close();
    }
}