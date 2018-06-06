package App.classes.model.POJO;

/**
 * Created by Arthur 29.11.2017 19:13.
 */
public class Data {

    private double chance;
    private String nameS;
    private String codeBinary = "";
    private double[] codeArithm;
    private double[] interval;
    private int index;

    public Data(double chance, int nameI, int index) {
        this.chance = chance;
        nameS = Integer.toString(nameI);
        this.index = index;
    }

    public Data(double chance, String nameS, int index) {
        this.chance = chance;
        this.nameS = nameS;
        this.index = index;
    }

    public Data(double chance, String nameS, double[] codeArithm, double[] interval, int index) {
        this.chance = chance;
        this.nameS = nameS;
        this.codeArithm = codeArithm;
        this.interval = interval;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public String getNameS() {
        return nameS;
    }

    public String getCodeBinary() {
        return codeBinary;
    }

    public void setCodeBinary(String codeBinary) {
        this.codeBinary = codeBinary;
    }

    public double[] getCodeArithm() {
        return codeArithm;
    }

    public void setCodeArithm(double[] codeArithm) {
        this.codeArithm = codeArithm;
    }

    public double[] getInterval() {
        return interval;
    }

    public void setInterval(double[] interval) {
        this.interval = interval;
    }
}
