package G;
import java.lang.reflect.*;
import java.util.*;
import G.Circunferencia;
public class Main {
    public static String capital(String s) {
        String res = s.toLowerCase();
        Character initial = Character.toUpperCase(res.charAt(0));
        StringBuilder sb = new StringBuilder(res);
        sb.setCharAt(0, initial);
        final String answer = sb.toString();
        return answer;
    }
    /*
2 2 4 4 6 8
Circunferencia 2 2 -1
Triangulo 0 0 3 3 2 0
Retangulo 0 0 0 4 4 4 4 0
     */


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner (System.in);

        int [] line = readLines.readLine(sc.nextLine());

        Constructor<?> constructor;
        ArrayList<Ponto> pontos = new ArrayList<>();
        FiguraGeometrica f;
        String s;
        String [] aos;
        for (int i = 0; i<line.length-1;i++){
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
                System.out.println(f);
                // Your code here: guarde aqui o seu obstaculo
            }
            catch (Exception e) {
                System.out.println("Tipo de obstaculo desconhecido");
            }
        }
        sc.close();
    }
}