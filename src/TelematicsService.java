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

            }
            avgOdometerMilesTraveled = avgOdometerMilesTraveled / numOfCars;
            avgConsumptionGallonsOfGasConsumed = avgConsumptionGallonsOfGasConsumed / numOfCars;
            avgOdometerLastOilChange = avgOdometerLastOilChange /numOfCars;
            avgEngineSizeInLiters = avgEngineSizeInLiters / numOfCars;



            htmlVehicleInfo += "        <tr>\n" +
                    "            <td align=\"center\">" + vehicleInfo.getVIN() + "</td><td align=\"center\">"+ vehicleInfo.getOdometerMilesTraveled() +"</td><td align=\"center\">"+ vehicleInfo.getConsumptionGallonsOfGasConsumed() +"</td><td align=\"center\">"+ vehicleInfo.getOdometerLastOilChange() +"</td align=\"center\"><td align=\"center\">"+ vehicleInfo.getEngineSizeInLiters() +"</td>\n" +
                    "        </tr>\n";

        File files = new File(".json");


            try {

                File dashboardfile = new File ("dashboard.html");
                dashboardfile.createNewFile();

                FileWriter fileWriter = new FileWriter(dashboardfile);
                String dashboard = "<html>\n" +
                        "  <title>Vehicle Telematics Dashboard</title>\n" +
                        "  <body>\n" +
                        "    <h1 align=\"center\">Averages for # vehicles</h1>\n" +
                        "    <table align=\"center\">\n" +
                        "        <tr>\n" +
                        "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "    <h1 align=\"center\">History</h1>\n" +
                        "    <table align=\"center\" border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                        "        </tr>\n" +
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





