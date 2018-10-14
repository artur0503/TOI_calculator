package App.UI.supporting;

public class DrawingModel {

    private int iteration;
    private int step;
    private int xLine;
    private int yLine;

    public DrawingModel(int iteration, int xLine, int yLine) {
        this.iteration = iteration;
        this.xLine = xLine;
        this.yLine = yLine;
    }

    public DrawingModel(int iteration, int step) {
        this.iteration = iteration;
        this.step = step;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getxLine() {
        return xLine;
    }

    public void setxLine(int xLine) {
        this.xLine = xLine;
    }

    public int getyLine() {
        return yLine;
    }

    public void setyLine(int yLine) {
        this.yLine = yLine;
    }
}
