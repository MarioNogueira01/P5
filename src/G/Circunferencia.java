package G;

import java.util.ArrayList;

public class Circunferencia extends FiguraGeometrica{
    Ponto a;
    int raio;
    public Circunferencia(String s){
        super(s);
        String[] x = s.split(" ",-1);
        this.a = new Ponto(Integer.parseInt(x[1]), Integer.parseInt(x[2]));
        this.raio = Integer.parseInt(x[3]);
    }
    public static int[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double a = (y2 - y1) / (x2 - x1);
        double b = y1 - a*x1;
        double c = -a*x1 - b*y1;
        return new int[] {(int) a, (int) b, (int) c};
    }
    public static boolean checkCollision(int a, int b, int c, int x, int y, int radius)
    {
        double dist = Math.abs(a * x + b * y + c) / Math.sqrt(a * a + b * b);

        return radius == dist || radius > dist;
    }

    /**
     * @param trajetoria
     * @return retorna true se a trajetoria intersetar com a circunferencia
     */
    @Override
    public boolean intercecao(Trajectory trajetoria) {
        ArrayList<Line> seg = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < trajetoria.getpontos().size() - 1; i++) {
            Ponto pontoA = trajetoria.getpontos().get(i);
            Ponto pontoB = trajetoria.getpontos().get(i + 1);
            int[] x = calculateLineEquation(pontoA.getX(),pontoA.getY(), pontoB.getX(), pontoB.getY());
            if (checkCollision(x[0],x[1],x[2],this.a.getX(),this.a.getY(),this.raio)) {
                count++;
            }
        }
        return count != 0;
    }



    @Override
    public void check(){
        if (this.raio < 0) {
            System.out.println("Circunferencia: vi");
            System.exit(0);
        }
    }
}