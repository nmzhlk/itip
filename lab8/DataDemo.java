package lab8;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class FilterProcessor {
    @DataProcessor
    public List<String> filterData(List<String> data) {
        return data.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
    }
}

class TransformProcessor {
    @DataProcessor
    public List<String> transformData(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

class AggregateProcessor {
    @DataProcessor
    public List<String> aggregateData(List<String> data) {
        return data.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}

public class DataDemo {
    public static void main(String[] args) throws IOException {
        DataManager manager = new DataManager();
        manager.registerDataProcessor(new TransformProcessor());
        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new AggregateProcessor());

        manager.loadData("lab8/input.txt");
        manager.processData();
        manager.saveData("lab8/output.txt");
    }
}
