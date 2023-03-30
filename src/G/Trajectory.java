/**
 * @author Mario_Nogueira a76947
 * @version 1.3 03/03/2023
 * @inv verifica se a trajetoria intercepta a si mesma
 */
package G;
import java.util.ArrayList;
import java.util.List;
//TODO: mudar tudo para como tinha
public class Trajectory {

    public static Line[] trajectory;


    public Trajectory(Line[] traj) {
        trajectory = traj;
    }

    public static Ponto getA(int i){
        return trajectory[i].getA();
    }
    public static Ponto getB(int i){
        return trajectory[i].getB();
    }

    public static String toPrint_S(Trajectory x){
        StringBuilder st = new StringBuilder();
        int n = trajectory.length;
        for (Line line : trajectory) {
            st.append(Ponto.toPrint(line.getA())).append(" ");
        }
        st.append(Ponto.toPrint(trajectory[n - 1].getB()));
        return st.toString();
    }

    public boolean vertraj(){
        if(trajectory.length < 2){
            return false;
        }
        for(int i = 1; i < trajectory.length; i++) {
            if (Trajectory.getA(i).getX()> Trajectory.getB(i).getX() && Trajectory.getA(i-1).getY() > Trajectory.getA(i-1).getX()){
                return false;
            }
        }
        return true;
    }

    public double distance(){
        double dist = 0;
        for(int i = 0; i < trajectory.length; i++){
            dist += Trajectory.getA(i).dist(Trajectory.getB(i));
        }
        return dist;
    }


    public int internum(List<FiguraGeometrica> figuraGeometricas){
        int num=0;
        for(FiguraGeometrica fig: figuraGeometricas){
            if(fig.intercecao(this)){
                num++;
            }
        }
        return num;
    }


    public double avaluation(List<FiguraGeometrica> figuraGeometricas){
        double dist = this.distance();
        int num = this.internum(figuraGeometricas);
        return 1/(dist + Math.exp(num));

    }

}
