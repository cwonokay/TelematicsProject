public class VehicleInfo {
    int VIN;
    double odometerMilesTraveled;
    double consumptionGallonsOfGasConsumed;
    double odometerLastOilChange;
    double engineSizeInLiters;

    public VehicleInfo() {
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdometerMilesTraveled() {
        return odometerMilesTraveled;
    }

    public void setOdometerMilesTraveled(double odometerMilesTraveled) {
        this.odometerMilesTraveled = odometerMilesTraveled;
    }

    public double getConsumptionGallonsOfGasConsumed() {
        return consumptionGallonsOfGasConsumed;
    }

    public void setConsumptionGallonsOfGasConsumed(double consumptionGallonsOfGasConsumed) {
        this.consumptionGallonsOfGasConsumed = consumptionGallonsOfGasConsumed;
    }

    public double getOdometerLastOilChange() {
        return odometerLastOilChange;
    }

    public void setOdometerLastOilChange(double odometerLastOilChange) {
        this.odometerLastOilChange = odometerLastOilChange;
    }

    public double getEngineSizeInLiters() {
        return engineSizeInLiters;
    }

    public void setEngineSizeInLiters(double engineSizeInLiters) {
        this.engineSizeInLiters = engineSizeInLiters;
    }


}
