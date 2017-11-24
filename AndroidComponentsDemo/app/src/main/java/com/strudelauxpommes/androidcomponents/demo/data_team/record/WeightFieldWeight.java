package com.strudelauxpommes.androidcomponents.demo.data_team.record;

import com.strudelauxpommes.androidcomponents.demo.data_team.*;

public class WeightFieldWeight extends BaseField<Float> {

    public void setRecordValue(BaseRecord record, Float value) {
        ((WeightRecord)record).weight = value;
    }

    public Float getRecordValue(BaseRecord record) {
        return ((WeightRecord)record).weight;
    }

}
