package App.interfaces.model.formulas;

import App.interfaces.model.BaseModel;

public interface ModelFormulas extends BaseModel {

    int getCountMessage();

    double getEntropy();

    double getMaxEntropy();

    double getAverageLength();

    double getRedundancy();

}
