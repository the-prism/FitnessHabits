package com.strudelauxpommes.androidcomponents.demo.data_team.record;


import com.strudelauxpommes.androidcomponents.demo.data_team.model.BaseField;
import com.strudelauxpommes.androidcomponents.demo.data_team.model.BaseRecord;


public class WeightFieldFat extends BaseField<Float> {

    public void setRecordValue(BaseRecord record, Float value) {
        ((WeightRecord)record).fat = value;
    }

    public Float getRecordValue(BaseRecord record) {
        return ((WeightRecord)record).fat;
    }

}
