package JavaSimulator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File; 
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

class Simulator {
    private static Logger logger = Logger.getLogger(Simulator.class.getClass().getName());
    private static FileHandler fileHandler;
    private static String lineSeparator = System.getProperty("line.separator");

    public static void main(String[] args) {
        try {
            //Set Up Logger
            fileHandler = new FileHandler("./JavaSimulator/SimulatorLogs/SimulatorLog.log", true);  
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();  
            fileHandler.setFormatter(formatter);  

            String commandFile = "";
            if(args.length != 0) {
                commandFile = args[0];
            }
            
            if (commandFile.contains("ImageGallery")) {
                writeImageGallery(commandFile);
            } else if (commandFile.contains("Login")) {
                writeLogin(commandFile);
            } else if (commandFile.contains("Registration")) {
                writeRegistration(commandFile);
            } else if (commandFile.contains("SocialMediaLinks")) {
                writeSocialMediaLinks(commandFile);
            }
        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    public static void writeImageGallery(String commandFile) throws IOException {
        try {
            logger.info("Imgage Gallery simulation starting!");

            File htmlTemplateFile = new File("JavaSimulator/HTMLTemplates/ImageGalleryTemplate.html");
            String fileName = "";
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            int totalImages = 0;
            String filePath = "SimulatedFeatures/UserFeatures/";
            boolean test = false;
            if(commandFile.contains("test")) {
                test = true;
                filePath = "SimulatedFeatures/TestFeatures/";
            }

            propertiesReader imageGalleryProperties = new propertiesReader("JavaSimulator/Resources/SimulatorProperties/imageGallery.properties");
            Map<String,String> values = makeMapFromFile(commandFile, test);
            imageGalleryProperties.readValues(values, "imageGallery");
            Map<String,String> attributes = imageGalleryProperties.getAttributes();
            String[] colWidth = new String[]{"100%","50%","33.33%","25%","20%","16.66%"};

            //As maps are unordered by nature, in order to ensure that the slides for images have been written into the file these if statements must be called now
            for (int i = 0; i < 6; i++) {
                String img = "$img" + Integer.toString(i + 1);
                String des = "$des" + Integer.toString(i + 1);
                String slide = "$slide" + Integer.toString(i + 1);
                String column = "$column" + Integer.toString(i + 1);
                String imgNum = "$imgNum" + Integer.toString(i + 1);
                if (attributes.get(img).equals("null")) { 
                    htmlString = htmlString.replace(slide, "");
                    htmlString = htmlString.replace(column, "");
                    attributes.remove(img); 
                    attributes.remove(des);
                } else {
                    totalImages++;
                    htmlString = htmlString.replace(slide, attributes.get(slide));
                    htmlString = htmlString.replace(column, attributes.get(column));
                    htmlString = htmlString.replace(imgNum, Integer.toString(totalImages));
                }
                attributes.remove(slide);
                attributes.remove(column);
            }

            htmlString = htmlString.replace("$totalImages", Integer.toString(totalImages));
            htmlString = htmlString.replace("$colWidth", colWidth[totalImages-1]);

            for (Map.Entry<String,String> entry : attributes.entrySet()) {
                if (entry.getKey().equals("fileName")) {
                    fileName = entry.getValue();
                } else {
                    htmlString = htmlString.replace(entry.getKey(), entry.getValue());
                }
            }

            File newHtmlFile = new File(filePath + fileName + ".html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } finally {
            logger.info("Imgage Gallery simulation complete!" + lineSeparator);
            System.exit(0);
        }
    }

    public static void writeLogin(String commandFile) throws IOException {
        try {
            logger.info("Login form simulation starting!");

            File htmlTemplateFile = new File("JavaSimulator/HTMLTemplates/LoginTemplate.html");
            String fileName = "";
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            String filePath = "SimulatedFeatures/UserFeatures/";
            boolean test = false;
            if(commandFile.contains("test")) {
                test = true;
                filePath = "SimulatedFeatures/TestFeatures/";
            }

            propertiesReader loginProperties = new propertiesReader("JavaSimulator/Resources/SimulatorProperties/login.properties");
            Map<String,String> values = makeMapFromFile(commandFile, test);
            loginProperties.readValues(values, "login");
            Map<String,String> attributes = loginProperties.getAttributes();

            for(Map.Entry<String,String> entry : attributes.entrySet()) {
                if (entry.getKey().equals("fileName")) {
                    fileName = entry.getValue();
                } else {
                    htmlString = htmlString.replace(entry.getKey(), entry.getValue());
                }
            }

            File newHtmlFile = new File(filePath + fileName + ".html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } finally {
            logger.info("Login form simulation complete!" + lineSeparator);
            System.exit(0);
        }
    }

    public static void writeRegistration(String commandFile) throws IOException {
        try {
            logger.info("Registration form simulation starting!");

            File htmlTemplateFile = new File("JavaSimulator/HTMLTemplates/RegistrationTemplate.html");
            String fileName = "";
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            String filePath = "SimulatedFeatures/UserFeatures/";
            boolean test = false;
            if(commandFile.contains("test")) {
                test = true;
                filePath = "SimulatedFeatures/TestFeatures/";
            }

            propertiesReader registrationProperties = new propertiesReader("JavaSimulator/Resources/SimulatorProperties/registration.properties");
            Map<String,String> values = makeMapFromFile(commandFile, test);
            registrationProperties.readValues(values, "registration");
            Map<String,String> attributes = registrationProperties.getAttributes();

            for(Map.Entry<String,String> entry : attributes.entrySet()) {
                if (entry.getKey().equals("fileName")) {
                    fileName = entry.getValue();
                } else {
                    htmlString = htmlString.replace(entry.getKey(), entry.getValue());
                }
            }

            File newHtmlFile = new File(filePath + fileName + ".html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } finally {
            logger.info("Registration form simulation complete!" + lineSeparator);
            System.exit(0);
        }
    }

    public static void writeSocialMediaLinks(String commandFile) throws IOException {
        try {
            logger.info("Social Media Sharing form simulation starting!");

            File htmlTemplateFile = new File("JavaSimulator/HTMLTemplates/SocialMediaLinksTemplate.html");
            String fileName = "";
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);
            String filePath = "SimulatedFeatures/UserFeatures/";
            boolean test = false;
            if(commandFile.contains("test")) {
                test = true;
                filePath = "SimulatedFeatures/TestFeatures/";
            }

            propertiesReader socialMediaLinksProperties = new propertiesReader("JavaSimulator/Resources/SimulatorProperties/socialMediaLinks.properties");
            Map<String,String> values = makeMapFromFile(commandFile, test);
            socialMediaLinksProperties.readValues(values, "socialMediaLinks");
            Map<String,String> attributes = socialMediaLinksProperties.getAttributes();

            //As maps are unordered by nature, in order to ensure that $siteName has been written into the file these if statements must be called now
            for (int i = 0; i < 5; i++) {
                String link = "$link" + Integer.toString(i + 1);
                String site = "$site" + Integer.toString(i + 1);
                String fa = "$fa" + Integer.toString(i + 1);
                if (attributes.get(link).equals("null")) { 
                    htmlString = htmlString.replace(site, "");
                    htmlString = htmlString.replace(fa, "");
                } else {
                    htmlString = htmlString.replace(site, attributes.get(site));
                    htmlString = htmlString.replace(fa, attributes.get(fa));
                    htmlString = htmlString.replace(link, attributes.get(link));
                }
                attributes.remove(site);
                attributes.remove(fa);
                attributes.remove(link);
            }

            for(Map.Entry<String,String> entry : attributes.entrySet()) {
                if (entry.getKey().equals("fileName")) {
                    fileName = entry.getValue();
                } else {
                    htmlString = htmlString.replace(entry.getKey(), entry.getValue());
                }
            }

            File newHtmlFile = new File(filePath + fileName + ".html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } finally {
            logger.info("Social Media Sharing form simulation complete!" + lineSeparator);
            System.exit(0);
        }
    }

    public static Map<String,String> makeMapFromFile(String commandFile, Boolean test) throws IOException {
        logger.info("Reading file " + commandFile + " into Map!");
        Map<String,String> values = new HashMap<>();
        String filePath = "JavaSimulator/Resources/SimulatorTextFiles/";
        if (test) {
            filePath = "JavaSimulator/Resources/TestTextFiles/";
        }
        File file = new File(filePath + commandFile);
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] keyValuePair = line.split("=", 2);
                values.put(keyValuePair[0],keyValuePair[1]);
            }
        } finally {
            it.close();
        }
        return values;
    }

    public static Logger getLogger() {
        return logger;
    }
}

class propertiesReader {
    private HashMap<String,String> attributes = new HashMap<>();
    private static String lineSeparator = System.getProperty("line.separator");

    public propertiesReader() {}


    //gets a properties file from the file path and read the properties into a Map
    public propertiesReader(String filepath) {
        attributes.clear();
        try (InputStream input = new FileInputStream(filepath)) {
            Simulator.getLogger().info("Filling Properties into Map");  

            Properties prop = new Properties();
            prop.load(input);

            Set<String> keys = prop.stringPropertyNames();
            for (String key : keys) {
                attributes.put(key, prop.getProperty(key));
            }
        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    //Loops through a Map of values taken from the text file supplied to the simulator and changes the values in attributes to match them
    public void readValues(Map<String,String> values, String feature) {
        Simulator.getLogger().info("Filling Properties into Map");  

        List<String> attributeKeys = new ArrayList<String>(attributes.keySet());
        for(Map.Entry<String,String> entry : values.entrySet()) {
            for(String key : attributeKeys) {
                if (entry.getKey().equals(key)) {
                    if (verifyAttribute(entry, feature)) {
                        if (entry.getValue().equals("")) {
                            attributes.put(key, "null");
                        } else {
                            attributes.put(key, entry.getValue());
                        }
                    } 
                }
            }
        }
    }

    public boolean verifyAttribute(Entry<String,String> entry, String feature) {
        boolean valid = true;
        valid = checkForNullValues(entry, feature);
        if (!valid) { return valid; }

        if (entry.getKey().contains("Colour")) {
            valid = checkHexcode(entry);
            if (!valid) { return valid; }
        }

        if (feature.equals("socialMediaLinks") && entry.getKey().contains("$link")) {
            valid = checkLink(entry);
            if (!valid) { return valid; }
        }

        if (feature.equals("imageGallery") && entry.getKey().contains("$img")) {
            valid = checkImg(entry);
            if (!valid) { return valid; }
        }
        
        return valid;
    }

    //Checks to see if the entry contains null values
    public boolean checkForNullValues(Entry<String,String> entry, String feature) {
        if (feature.equals("imageGallery") || feature.equals("socialMediaLinks") && entry.getValue().equals("null") || entry.getValue().equals("")) {
            if (entry.getKey().contains("$img") || entry.getKey().contains("$link")) {
                return true;
            }
        } else if (entry.getKey().equals("fileName") && entry.getValue().equals("null") || entry.getValue().equals("")) {
            return true;
        } else if (entry.getValue().equals("null") || entry.getValue().equals("")) {
            Simulator.getLogger().warning(entry.getKey() +" cannot be a null value");
            Simulator.getLogger().info("As such, the simulator shall use the default value for " + entry.getKey() + " in the simulation");
            return false;
        }
        return true;
    }

    //Checks to see if a hexcode is valid
    private boolean checkHexcode(Entry<String, String> entry) {
        if (entry.getValue().matches("^#(?:[0-9a-fA-F]{3}){1,2}$")) {
            return true;
        }
        Simulator.getLogger().warning("The value for " + entry.getKey() + " is not a valid Hexadecimal Colour");
        Simulator.getLogger().info("As such, the simulator shall use the default value for " + entry.getKey() + " in the simulation");
        return false;
    }
    
    //Checks to see if a link is valid
    private boolean checkLink(Entry<String, String> entry) {
        if (entry.getValue().equals("null") || entry.getValue().equals("")) {
            return true;
        }

        String regex = "(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?(\\/[a-z0-9])*(\\/?|(\\?[a-z0-9]=[a-z0-9](&[a-z0-9]=[a-z0-9]*)?))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entry.getValue());

        if (matcher.matches()) {
            return true;
        }

        Simulator.getLogger().severe("The value for " + entry.getKey() + " is not a valid URL");
        Simulator.getLogger().info("As such, the simulator will not be able to simulate the Social Media Sharing Form" + lineSeparator);
        System.exit(0);
        return false;
    }

    //Checks to see if image url is valid
    private boolean checkImg(Entry<String, String> entry) {
        if (entry.getValue().equals("null") || entry.getValue().equals("")) {
            return true;
        }

        try {  
            BufferedImage image = ImageIO.read(new URL(entry.getValue()));  
            if(image != null){  
                return true;
            } else{
                Simulator.getLogger().severe("The value for " + entry.getKey() + " is not a valid image URL");
                Simulator.getLogger().info("As such, the simulator will not be able to simulate the image gallery" + lineSeparator);
                System.exit(0);
                return false;
            }
        } catch (MalformedURLException e) {  
            Simulator.getLogger().severe("URL error with image" + lineSeparator + e);  
            Simulator.getLogger().info("As image is invalid, the simulator will not be able to simulate the image gallery" + lineSeparator);
            System.exit(0);
            return false;
        } catch (IOException e) {  
            Simulator.getLogger().severe("IO error with image" + lineSeparator + e);
            Simulator.getLogger().info("As image is invalid, the simulator will not be able to simulate the image gallery" + lineSeparator);
            System.exit(0);
            return false;  
        }  
    }

    //Returns the Map of Attributes
    public Map<String,String> getAttributes() {
        return attributes;
    }
}