import java.util.Scanner;

public class Main {
    int VIN;
    double odometerMilesTraveled;
    double consumptionGallonsOfGasConsumed;
    double odometerLastOilChange;
    double engineSizeInLiters;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        VehicleInfo vehicleInfo = new VehicleInfo();
        TelematicsService telematicsService = new TelematicsService();

        System.out.println("Please enter Vehicle Identification Number");
        String vininput = scanner.nextLine();
        int VIN = Integer.parseInt(vininput);

        System.out.println("Please enter miles traveled");
        String odometerMilesTraveledinput = scanner.nextLine();
        double odometerMilesTraveled = Double.parseDouble(odometerMilesTraveledinput);


        System.out.println("Please enter gallons of gas consumed ");
        String consumptionGallonsOfGasConsumedinput = scanner.nextLine();
        double consumptionGallonsOfGasConsumed = Double.parseDouble(consumptionGallonsOfGasConsumedinput);

        System.out.println("Please enter reading for last oil change ");
        String odometerLastOilChangeinput = scanner.nextLine();
        double odometerLastOilChange = Double.parseDouble(odometerLastOilChangeinput);

        System.out.println("Please enter engine size in liters ");
        String engineSizeInLitersinput = scanner.nextLine();
        double engineSizeInLiters = Double.parseDouble(engineSizeInLitersinput);

    System.out.println(VIN);

        telematicsService.report(vehicleInfo);
    }




}
