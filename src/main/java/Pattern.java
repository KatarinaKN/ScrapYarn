import java.util.ArrayList;

public class Pattern {
    private int primaryKey;
    private String name;
    private String craftType;
    private String level;
    private int yarnAmount;
    private double needleSize;
    private String gauge;
    private String yarnType;
    private String category;
    private String pathtopdf;

    public Pattern (String name, String craftType, String level, int yarnAmount, double needleSize, String gauge, String yarnType, String category, String pathtopdf) {
        this.name = name;
        this.craftType = craftType;
        this.level = level;
        this.yarnAmount = yarnAmount;
        this.needleSize = needleSize;
        this.gauge = gauge;
        this.yarnType = yarnType;
        this.category = category;
        this.pathtopdf = pathtopdf;
    }

    //Spørger brugeren, om der også må komme forslag, der indeholder ekstra materialer.
    public String ifExtraMaterials(){
        return "";
    }


    public String toString(){
        return "\n--------------------" + "\nID: " + primaryKey + "\nName: " + name + "\nCraft type: " + craftType +
                "\nLevel: " + level + "\nYarn amount: " + yarnAmount +
                "\nNeedle size: " + needleSize + "\nGauge: " + gauge + "\nYarn type: " + yarnType +
                "\nCategory: " + category + "\n--------------------";
    }

    public String getPathtopdf() {
        return pathtopdf;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public String getName(){
        return name;
    }

    public double getNeedleSize(){
        return needleSize;
    }

    public int getYarnAmount(){
        return yarnAmount;
    }

    public String getLevel(){
        return level;
    }

    public String getYarnType(){
        return yarnType;
    }

    public String getCategory(){
        return category;
    }

    public String getGauge(){
        return gauge;
    }

    public String getCraftType(){
        return craftType;
    }
}
