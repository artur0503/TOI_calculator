package App.classes.model.POJO;

/**
 * Created by Arthur 29.11.2017 19:13.
 */
public class Data {

    private double chance;
    private String nameS;
    private String code = "";
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public void setNameS(String nameS) {
        this.nameS = nameS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
