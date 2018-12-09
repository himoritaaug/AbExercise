package hmorita.abexercise.factory;

import hmorita.abexercise.data.ReportElementData;
import hmorita.abexercise.entity.ReportElement;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ReportElementFactory implements EntityFactory<ReportElementData, ReportElement>{

    @Override
    public ReportElement create(ReportElementData data) throws IllegalArgumentException {
        ReportElement repElment = new ReportElement();
        repElment.setCustomerId(convertKey(data.customerId));
        repElment.setName(data.kanjiName);
        repElment.setAmount(convertAmount(data.amount));
        return repElment;
    }

    @Override
    public ReportElement create(String line) throws IllegalArgumentException {
        ReportElementData d = new ReportElementData();
        String[] els = line.split(",");
        for(int i = 0; i < els.length; i++) {
            if(skipColumnNumbers().contains(i)) continue;
            if(i == 0) d.customerId = els[i];
            else if(i == 1) d.kanjiName = els[i];
            else if(i == 2) d.amount = els[i];
        }
        return create(d);
    }

    @Override
    public List<Integer> skipColumnNumbers() {
        return Collections.emptyList();
    }

    protected BigDecimal convertAmount(String s) {
        return new BigDecimal(s);
    }

}
