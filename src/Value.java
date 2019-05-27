
public enum Value {
    TVÅ(2), TRE(3), FYRA(4), FEM(5), SEX(6), SJU(7), ÅTTA(8), NIO(9), TIO(10), KNEKT(10), DAM(10), KUNG(10), ESS(1);
    private final int value;

    private Value(int value) {
        this.value = value;
    }

    public int getCardValue() {
        return this.value;
    }
}
