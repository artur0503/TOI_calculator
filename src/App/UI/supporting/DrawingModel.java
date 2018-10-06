package App.UI.supporting;

public class DrawingModel {

    private int iteration;
    private int step;

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
}
