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
        int ola;
        Constructor<?> constructor;
        Class<?> cl;
        FiguraGeometrica f;
        String s;
        String [] aos;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            aos = s.split(" ");
            try {
                cl = Class.forName(capital(aos[0]));
                constructor = cl.getConstructor (new Class[] {String.class});
                f = (FiguraGeometrica) constructor.newInstance(s);
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
