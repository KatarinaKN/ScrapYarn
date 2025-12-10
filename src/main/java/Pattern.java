import java.util.ArrayList;

public class Pattern {
    private String name;
    private double needleSize;
    private int yarnAmount;
    private String level;
    private String yarnType;
    private String category;
    private int gauge;
    private ArrayList<Pattern> beginnerCrochet = new ArrayList<>();
    private ArrayList<Pattern> intermediateCrochet = new ArrayList<>();
    private ArrayList<Pattern> advancedCrochet = new ArrayList<>();
    private ArrayList<Pattern> beginnerKnit = new ArrayList<>();
    private ArrayList<Pattern> intermediateKnit = new ArrayList<>();
    private ArrayList<Pattern> advancedKnit = new ArrayList<>();

    public Pattern (String name, double needleSize, int yarnAmount, String level, String yarnType, String category, int gauge) {
        this.name = name;
        this.needleSize = needleSize;
        this.yarnAmount = yarnAmount;
        this.level = level;
        this.yarnType = yarnType;
        this.category = category;
        this.gauge = gauge;
    }

    //Spørger brugeren, om der også må komme forslag, der indeholder ekstra materialer.
    public String ifExtraMaterials(){
        return "";
    }

   //TODO indsæt return. Kan man evt. slå alle showPatterns....-metoder sammen til én metode, for eksempel showPatterns(ArrayList<> ArrayList)?
    /*public ArrayList<Pattern> showPatternsCrochetBeginner(){
        return ;
    }*/

    //TODO indsæt return. Skal den have en parameter? For eksempel at man vil søge på strikkeopskrifter.
    /*public ArrayList<Pattern> searchPatterns(){
        return ;
    }*/

    public String toString(){
        return "";
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

    public int getGauge(){
        return gauge;
    }
}
