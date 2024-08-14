
public class Arithmetic {

    int a;
    int b;


    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int multiNumber() {
        return a * b;
    }

    public int maximalNumber() {
        if (a > b) {
            return a;
        }
        return b;
    }
    public int minimalNumber() {
        if (a > b) {
            return b;
        }
        return a;
    }


}






