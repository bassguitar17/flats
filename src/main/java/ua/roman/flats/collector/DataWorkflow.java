package ua.roman.flats.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataWorkflow {

    @Autowired
    private DataCollector dataCollector;

    @Autowired
    private DataSaver dataSaver;

    public void run(){
        var advertisements = dataCollector.collectData();
        dataSaver.saveData(advertisements);
    }
}
