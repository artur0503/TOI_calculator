package App.core.classes.model.models;

public class DataDraw {

    private double chance;
    private boolean isRes;

    private String code;
    private int index;
    private int pos;

    public DataDraw(String code, int index, int pos) {
        this.code = code;
        this.index = index;
        this.pos = pos;
    }

    public DataDraw(double chance, boolean isRes) {
        this.chance = chance;
        this.isRes = isRes;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public boolean isRes() {
        return isRes;
    }

    public void setRes(boolean res) {
        isRes = res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
