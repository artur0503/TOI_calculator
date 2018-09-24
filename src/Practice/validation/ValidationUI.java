package Practice.validation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ValidationUI implements Validation {

    private ArrayList<Double> chanceList;
    private boolean valid;
    private double wrongSum;

    public ValidationUI(ArrayList<Double> chanceList) {
        this.chanceList = chanceList;
    }

    private void setValid(boolean valid) {
        this.valid = valid;
    }

    private void setWrongSum(double wrongSum) {
        this.wrongSum = wrongSum;
    }

    public double getWrongSum() {
        return wrongSum;
    }

    @Override
    public void check() {
        if (chanceList != null && !chanceList.isEmpty()){
            double sum = 0;
            for (double chance : chanceList){
                sum = sum + chance;
                sum = new BigDecimal(sum).setScale(4, RoundingMode.HALF_UP).doubleValue();
            }
            if (sum != 1) {
                setValid(false);
                setWrongSum(sum);
            }
            else
                setValid(true);
        }
    }

    @Override
    public boolean isValid() {
        check();
        return valid;
    }
}
