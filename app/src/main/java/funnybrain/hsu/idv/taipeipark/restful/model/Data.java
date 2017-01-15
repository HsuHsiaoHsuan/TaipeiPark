package funnybrain.hsu.idv.taipeipark.restful.model;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private String offset;

    private String limit;

    private String count;

    private String sort;

    private List<Park> results = new ArrayList<>();

    public String getOffset() {
        return offset;
    }

    public String getLimit() {
        return limit;
    }

    public String getCount() {
        return count;
    }

    public String getSort() {
        return sort;
    }

    public List<Park> getPark() {
        return results;
    }
}
