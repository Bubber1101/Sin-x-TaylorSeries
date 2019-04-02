import javax.swing.*;

public class Main {

    public static void main(String[] args) {
    //new Main((Math.PI/2 )* 15,5);
        int b = Integer.parseInt(JOptionPane.showInputDialog("Enter the 'level' of approximation","5"));
        String s = JOptionPane.showInputDialog("Do you want to use radians(Y) or degrees(N)?","y");
        double a = 0;
        if (s.toLowerCase().equals("y")){
            String kacper = JOptionPane.showInputDialog("Enter the value in radians");
            if (kacper.endsWith("pi")){
                kacper = kacper.replaceAll("pi","");
                System.out.println(kacper);
                a = Integer.parseInt(kacper) * Math.PI;
            }
            else a = Integer.parseInt(kacper);

        }else if(s.toLowerCase().equals("n")){
            a = Integer.parseInt(JOptionPane.showInputDialog("Enter the value in degrees"));
            a = Math.toRadians(a);
            }
        else{
            System.exit(100);
        }
         new Main(a,b);

    }
    public Main(double x,int level){
        System.out.println("Calculating for " + x);
        x = getToRange(x);
        System.out.println("Reduced to " + x);

        if (x<= Math.PI/2){
            calculate(x,level);
        }
        else if (x<= Math.PI){
            calculate(Math.PI -x,level);

        }
        else if (x<= (1.5)*Math.PI){
            calculate(x - Math.PI,level);

        }
        else if (x<= 2*Math.PI){
            calculate(2*Math.PI - x, level);
        }
    }
    public void calculate(double x, int level){
        double approximated = 0;
        for (int i = 1; i <= level; i++) {
            approximated = getApproximation(x,i);
            System.out.println("Approximation of level: " + i + " equals: " + approximated);

        }
        double refference = Math.sin(x);//'[
        System.out.println("According to Math.sin: "+ refference);
        System.out.println("Difference: " +(approximated -refference));
    }
    public double getApproximation(double x, int level) {
        double result = 0;

        for (int i = 1; i <= level; i++) {
            result += (((-1) * Math.pow(-1, i)) * Math.pow(x, (i * 2) - 1)) / factorial((i * 2) - 1);
        }
        if(x > Math.PI)return -1 * result;
        return result;
    }

    public int factorial(int i) {
        int result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }
    public double getToRange(double x){
        while (x > 2* Math.PI){
            x -= 2* Math.PI;
        }
        return x;
    }

}
