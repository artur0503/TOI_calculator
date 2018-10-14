package App.core.classes.model.models;

public class DataDraw {

    private double chance;
    private boolean isRes;

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
}
