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

    public int getStep() {
        return step;
    }

    public int getXLine() {
        return xLine;
    }

    public int getYLine() {
        return yLine;
    }
}
