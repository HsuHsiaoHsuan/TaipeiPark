package funnybrain.hsu.idv.taipeipark.restful.model;

public class Park {
    private String _id;

    private String ParkName;

    private String Name;

    private String YearBuilt;

    private String OpenTime;

    private String Image;

    private String Introduction;

    public String get_id() {
        return _id;
    }

    public String getParkName() {
        return ParkName;
    }

    public String getPicName() {
        return Name;
    }

    public String getYear() {
        return YearBuilt;
    }

    public String getOpen() {
        return OpenTime;
    }

    public String getImage() {
        return Image;
    }

    public String getIntro() {
        return Introduction;
    }
}
