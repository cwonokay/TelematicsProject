import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class TelematicsService {


   static void report(VehicleInfo vehicleInfo) {



//        JSON
       try {
           String file = vehicleInfo.VIN + ".json";
           System.out.println(file);

           ObjectMapper mapper = new ObjectMapper();
           mapper.writeValue(new File(file), vehicleInfo);
           String json = mapper.writeValueAsString(vehicleInfo);

       } catch (IOException e){
           e.printStackTrace();
       }
//        JAVA
       VehicleInfo information;

        ArrayList<VehicleInfo> info = new ArrayList<>();
        File newfile = new File(".");
        for (File f : newfile.listFiles()) {
            if (f.getName().endsWith(".json")) {


//
                try {

                    ObjectMapper mapper = new ObjectMapper();
                    information = mapper.readValue(f, VehicleInfo.class);
                    info.add(information);

                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            String htmlVehicleInfo = "";
            int numOfCars = 0;
            double avgOdometerMilesTraveled = 0;
            double avgConsumptionGallonsOfGasConsumed = 0;
            double avgOdometerLastOilChange = 0;
            double avgEngineSizeInLiters = 0;

            for (VehicleInfo vinInfo: info) {
                avgOdometerMilesTraveled += vinInfo.getOdometerMilesTraveled();
                avgConsumptionGallonsOfGasConsumed += vinInfo.getConsumptionGallonsOfGasConsumed();
                avgOdometerLastOilChange += vinInfo.getOdometerLastOilChange();
                avgEngineSizeInLiters += vinInfo.getEngineSizeInLiters();

                htmlVehicleInfo += "        <tr>\n" +
                        "            <td align=\"center\">" + vinInfo.getVIN() + "</td><td align=\"center\">"+ vinInfo.getOdometerMilesTraveled() +"</td><td align=\"center\">"+ vinInfo.getConsumptionGallonsOfGasConsumed() +"</td><td align=\"center\">"+ vinInfo.getOdometerLastOilChange() +"</td align=\"center\"><td align=\"center\">"+ vinInfo.getEngineSizeInLiters() +"</td>\n" +
                        "        </tr>\n";
            }
            avgOdometerMilesTraveled = avgOdometerMilesTraveled / numOfCars;
            avgConsumptionGallonsOfGasConsumed = avgConsumptionGallonsOfGasConsumed / numOfCars;
            avgOdometerLastOilChange = avgOdometerLastOilChange /numOfCars;
            avgEngineSizeInLiters = avgEngineSizeInLiters / numOfCars;





        File files = new File(".json");


            try {

                File dashboardfile = new File ("dashboard.html");
                dashboardfile.createNewFile();

                FileWriter fileWriter = new FileWriter(dashboardfile);
                String dashboard = "<html>\n" +
                        "  <title>Vehicle Telematics Dashboard</title>\n" +
                        "  <body>\n" +
                        "    <h1 align=\"center\">Averages for " + numOfCars + " vehicles</h1>\n" +
                        "    <table align=\"center\">\n" +
                        "        <tr>\n" +
                        "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">" + Math.round(avgOdometerMilesTraveled) + "</td><td align=\"center\">" + Math.round(avgConsumptionGallonsOfGasConsumed)+ "</td><td align=\"center\">"+ Math.round(avgOdometerLastOilChange) + "</td align=\"center\"><td align=\"center\">"+ Math.round(avgEngineSizeInLiters) +"</td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "    <h1 align=\"center\">History</h1>\n" +
                        "    <table align=\"center\" border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        htmlVehicleInfo +
                        "    </table>\n" +
                        "  </body>\n" +
                        "</html>\n";
                fileWriter.write(dashboard);
                fileWriter.close();



            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }



}





