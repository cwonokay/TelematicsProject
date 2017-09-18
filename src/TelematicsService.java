import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TelematicsService {

    void report(VehicleInfo vehicleInfo) {
//        JSON
       try {
           String file = vehicleInfo.VIN + "json";
           System.out.println(file);

           ObjectMapper mapper = new ObjectMapper();
           String json = mapper.writeValueAsString(vehicleInfo);

       } catch (IOException e){
           System.out.println(e);
       }
//        JAVA
        ArrayList<VehicleInfo> info = new ArrayList<>();
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {

//                Scanner fileScanner = new Scanner(file);
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

                }catch (IOException e){
                    System.out.println(e);
                }
            }

        File files = new File(".json");

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

            try {

                FileWriter fileWriter = new FileWriter(files);
                fileWriter = new FileWriter(files);
                fileWriter.write(dashboard);
                fileWriter.close();



            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }



}





