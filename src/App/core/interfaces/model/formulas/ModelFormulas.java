package App.core.interfaces.model.formulas;

import App.core.interfaces.model.BaseModel;

public interface ModelFormulas extends BaseModel {

    int getCountMessage();

    double getEntropy();

    double getMaxEntropy();

    double getAverageLength();

    double getRedundancy();

}