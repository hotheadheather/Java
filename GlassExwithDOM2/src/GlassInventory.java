/*This is the instantiable class for glassblowing color inventory
Author: Heather Whittlesey
11/23/2020 */
public class GlassInventory {
    // Instance Variables
    private String inventoryID, colorName, adVenturine , colorTrans, reducingProp, strikingProp;
    private int supplyKg, physicalForm;
    private double costPerKg;

    // getters-accessors

    public String getInventoryID() {
        return inventoryID;
    }

    public String getColorName() {
        return colorName;
    }

    public int getSupplyKg() {
        return supplyKg;
    }

    public int getPhysicalForm() {
        return physicalForm;
    }

    public String getReducingProp() { return reducingProp; }

    public String getStrikingProp() { return strikingProp; }

    public String getColorTrans() { return colorTrans; }

    public String getAdVenturine() { return adVenturine; }

    public double getCostPerKg() {
        return costPerKg;
    }


    //setters-mutators

    public void setInventoryID(String inventoryID) {
        this.inventoryID = inventoryID;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void setSupplyKg(int supplyKg) {
        if(supplyKg <= 0){
            this.supplyKg = 56;}
        else{
            this.supplyKg = supplyKg;}
    }

    public void setPhysicalForm(int physicalForm) {
        if(physicalForm <= 0 || physicalForm >4){
            this.physicalForm = 1;}
        else{
            this.physicalForm = physicalForm;}
    }

    public void setReducingProp(String reducingProp) {

        String colorReduce = "T";
        boolean bool;
        if (colorReduce  == "true"){
            bool = true;
        }
        else{
            bool = false;
        }


        this.reducingProp = reducingProp;
    }


    public void setStrikingProp(String strikingProp) {

        String colorStrike = "T";
        boolean bool;
        if (colorStrike  == "true"){
            bool = true;
        }
        else{
            bool = false;
        }
        this.strikingProp = strikingProp;

    }

    public void setColorTrans(String colorTrans) {

        String colorTran = "T";
        boolean bool;
        if (colorTran == "true"){
            bool = true;
        }
        else{
            bool = false;
        }
        this.colorTrans = colorTrans;
    }


    public void setAdVenturine(String adVenturine) {
        String adVent = "T";
        boolean bool;
        if (adVent == "true"){
            bool = true;
        }
        else{
            bool = false;
        }
        this.adVenturine = adVenturine;
    }
    public void setCostPerKg(double costPerKg) {
        if (costPerKg > 0){
            this.costPerKg = costPerKg;
        }
        else{
            this.costPerKg = 55.00;
        }
    }
    public GlassInventory() {
        inventoryID = "R00630R";
        colorName = "Flamingo";
        supplyKg = 52;
        physicalForm = 1;
        reducingProp = "false";
        strikingProp = "true";
        colorTrans = "false";
        adVenturine = "false";
        costPerKg= 56.00;
    }

    /**
     * Overloaded Constructor
     * @param inventoryID glass sku
     * @param colorName glass name
     * @param supplyKg SupplyKg
     * @param physicalForm bar/frit/powder/shard
     * @param reducingProp ReducingProp
     * @param strikingProp StrikingProp
     * @param colorTrans Transparency
     * @param adVenturine AdVenturine
     * @param costPerKg CostPerKg
     */

    public GlassInventory(String inventoryID, String colorName,int supplyKg,int physicalForm, String reducingProp,
                          String strikingProp, String colorTrans, String adVenturine, double costPerKg){
        setInventoryID(inventoryID);
        setColorName(colorName);
        setSupplyKg(supplyKg);
        setPhysicalForm(physicalForm);
        setReducingProp(reducingProp);
        setStrikingProp(strikingProp);
        setColorTrans(colorTrans);
        setAdVenturine(adVenturine);
        setCostPerKg(costPerKg);
    }
    @Override
    public String toString() {

        return "GlassInventory{" +
                "inventoryID='" + inventoryID + '\'' +
                ", colorName='" + colorName + '\'' +
                ", supplyKg=" + supplyKg +
                ", physicalForm=" + physicalForm +
                ", reducingProp=" + reducingProp +
                ", strikingProp=" + strikingProp +
                ", colorTrans=" + colorTrans +
                ", adVenturine=" + adVenturine +
                ", costPerKg=" + costPerKg +
                '}';
    }
}







