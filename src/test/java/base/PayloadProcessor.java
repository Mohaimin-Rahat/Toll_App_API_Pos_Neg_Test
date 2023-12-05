package base;

import com.google.gson.Gson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utility.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class PayloadProcessor {

    private static Logger log = LogManager.getLogger(TestUtils.class.getName());
    public static Properties getValueFromPropertiesFile(){
        Properties properties = new Properties();
        // Use env specific properties file
        String env = System.getProperty("env", "stage");
        if (env.equalsIgnoreCase("stage")) {
            try (InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/profiles/" + "stage.properties")) {
                properties.load(inputStream);
                log.info("Env Name: " + env);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        String fieldValue = properties.getProperty(fieldKey);
            return properties;
        }
        else if (env.equalsIgnoreCase("prod")) {
            try (InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/profiles/" + "prod.properties")) {
                properties.load(inputStream);
                log.info("Env Name: " + env);

            } catch (IOException e) {
                e.printStackTrace();
            }
//        String fieldValue = properties.getProperty(fieldKey);
            return properties;
        }
        return properties;
    }


    public static Map<String, Object> getProcessedPayloadInJson(String jsonFile, Properties properties, String... params){
        Gson gson = new Gson();
        // create a reader
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir")+ "/payloads/"+jsonFile));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // convert JSON file to map
//        Map<String, Object> map = gson.fromJson(reader, Map.class);
        Map<String, Object> map = gson.fromJson(reader, Map.class);
       /* LinkedTreeMap connexPayTransaction = (LinkedTreeMap) map.get("ConnexPayTransaction");
        connexPayTransaction.put("ExpectedPayments", "10");
        System.out.println(connexPayTransaction.get("ExpectedPayments"));*/

        if (params != null) {
            for (String param:params) {
                map.put(param, properties.getProperty(param));
            }
        }
//        String payloadToJSON = gson.toJson(map);
        return map;
    }
    public static String payloadFromMapToString(Map<String, Object> payloadInMap){
        Gson gson = new Gson();
        return gson.toJson(payloadInMap);
    }

}