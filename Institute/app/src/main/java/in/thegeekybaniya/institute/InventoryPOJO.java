package in.thegeekybaniya.institute;

/**
 * Created by Kabir on 11/02/2017.
 */

public class InventoryPOJO {
    String name, unit;

    int qty;

    public InventoryPOJO(String name, String unit, int qty) {
        this.name = name;
        this.unit = unit;
        this.qty = qty;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
