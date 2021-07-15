package JavaSimulator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class CreateProperties {
    public static void main(String[] args) {
        try {
            createImageGalleryProperties();
            createLoginProperties();
            createRegistrationProperties();
            createSocialMediaLinksProperties();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    public static void createLoginProperties() throws IOException {
        try (OutputStream output = new FileOutputStream("JavaSimulator/Resources/SimulatorProperties/login.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("fileName", "SimulatedLogin");
            prop.setProperty("$buttonColour", "#3DED97");
            prop.setProperty("$cancelColour", "#f55676");
            prop.setProperty("$containerColour", "#302e2e");
            prop.setProperty("$textColour", "#FFFFFF");
            prop.setProperty("$pageTitle", "Login");
            prop.setProperty("$pageDescription", "Please fill in this form to login to your account.");
            prop.setProperty("$emailText", "Enter Email");
            prop.setProperty("$passwordText", "Enter Password");

            // save properties to project root folder
            prop.store(output, null);
        }
    }

    public static void createRegistrationProperties() throws IOException {
        try (OutputStream output = new FileOutputStream("JavaSimulator/Resources/SimulatorProperties/registration.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("fileName", "SimulatedRegistration");
            prop.setProperty("$buttonColour", " #3DED97");
            prop.setProperty("$cancelColour", "#f55676");
            prop.setProperty("$containerColour", "#302e2e");
            prop.setProperty("$textColour", "#FFFFFF");
            prop.setProperty("$pageTitle", "Account Login");
            prop.setProperty("$pageDescription", "Please fill in this form to create an account.");
            prop.setProperty("$emailText", "Enter Email");
            prop.setProperty("$passwordText1", "Enter Password");
            prop.setProperty("$passwordText2", "Repeat Password");

            // save properties to project root folder
            prop.store(output, null);
        }
    }

    public static void createSocialMediaLinksProperties() throws IOException {
        try (OutputStream output = new FileOutputStream("JavaSimulator/Resources/SimulatorProperties/socialMediaLinks.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("fileName", "SimulatedSocialMediaLinks");
            prop.setProperty("$site1", "\n\t\t\t<a href='$link1' class='fa fa-facebook'></a>");
            prop.setProperty("$site2", "\n\t\t\t<a href='$link2' class='fa fa-twitter'></a>");
            prop.setProperty("$site3", "\n\t\t\t<a href='$link3' class='fa fa-linkedin'></a>");
            prop.setProperty("$site4", "\n\t\t\t<a href='$link4' class='fa fa-instagram'></a>");
            prop.setProperty("$site5", "\n\t\t\t<a href='$link5' class='fa fa-youtube'></a>");
            prop.setProperty("$fa1", "\n\t\t\t.fa-facebook {\n\t\t\t\tbackground: #3B5998;\n\t\t\t\tcolor: white;\n\t\t\t}\n");
            prop.setProperty("$fa2", "\n\t\t\t.fa-twitter {\n\t\t\t\tbackground: #55ACEE;\n\t\t\t\tcolor: white;\n\t\t\t}\n");
            prop.setProperty("$fa3", "\n\t\t\t.fa-linkedin {\n\t\t\t\tbackground: #007bb5;\n\t\t\t\tcolor: white;\n\t\t\t}\n");
            prop.setProperty("$fa4", "\n\t\t\t.fa-instagram {\n\t\t\t\tbackground: #125688;\n\t\t\t\tcolor: white;\n\t\t\t}\n");
            prop.setProperty("$fa5", "\n\t\t\t.fa-youtube {\n\t\t\t\tbackground: #bb0000;\n\t\t\t\tcolor: white;\n\t\t\t}\n");
            prop.setProperty("$title", "Find us here");
            prop.setProperty("$containerColour", "#302e2e");
            prop.setProperty("$link1", "https://www.facebook.com/");
            prop.setProperty("$link2", "https://www.twitter.com/");
            prop.setProperty("$link3", "https://www.linkedin.com/");
            prop.setProperty("$link4", "https://www.instagram.com/");
            prop.setProperty("$link5", "https://www.youtube.com/");

            // save properties to project root folder
            prop.store(output, null);
        }
    }

    public static void createImageGalleryProperties() throws IOException {
        try (OutputStream output = new FileOutputStream("JavaSimulator/Resources/SimulatorProperties/imageGallery.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("fileName", "SimulatedImageGallery");
            prop.setProperty("$title", "Slideshow Gallery");
            prop.setProperty("$imageDesColour", "#222");
            prop.setProperty("$slide1", "\n\t\t\t<div class='slides'>\n\t\t\t\t<div class='numbertext'>$imgNum1 / $totalImages</div>\n\t\t\t\t<img src=$img1 style='width:100%'>\n\t\t\t</div>\n");
            prop.setProperty("$slide2", "\n\t\t\t<div class='slides'>\n\t\t\t\t<div class='numbertext'>$imgNum2 / $totalImages</div>\n\t\t\t\t<img src=$img2 style='width:100%'>\n\t\t\t</div>\n");
            prop.setProperty("$slide3", "\n\t\t\t<div class='slides'>\n\t\t\t\t<div class='numbertext'>$imgNum3 / $totalImages</div>\n\t\t\t\t<img src=$img3 style='width:100%'>\n\t\t\t</div>\n");
            prop.setProperty("$slide4", "\n\t\t\t<div class='slides'>\n\t\t\t\t<div class='numbertext'>$imgNum4 / $totalImages</div>\n\t\t\t\t<img src=$img4 style='width:100%'>\n\t\t\t</div>\n");
            prop.setProperty("$slide5", "\n\t\t\t<div class='slides'>\n\t\t\t\t<div class='numbertext'>$imgNum5 / $totalImages</div>\n\t\t\t\t<img src=$img5 style='width:100%'>\n\t\t\t</div>\n");
            prop.setProperty("$slide6", "\n\t\t\t<div class='slides'>\n\t\t\t\t<div class='numbertext'>$imgNum6 / $totalImages</div>\n\t\t\t\t<img src=$img6 style='width:100%'>\n\t\t\t</div>\n");
            prop.setProperty("$column1", "\n\t\t\t\t<div class='column'>\n\t\t\t\t\t<img class='demo cursor' src=$img1 style='width:100%' onclick='setCurrentSlide($imgNum1)' alt='$des1'>\n\t\t\t\t</div>");
            prop.setProperty("$column2", "\n\t\t\t\t<div class='column'>\n\t\t\t\t\t<img class='demo cursor' src=$img2 style='width:100%' onclick='setCurrentSlide($imgNum2)' alt='$des2'>\n\t\t\t\t</div>");
            prop.setProperty("$column3", "\n\t\t\t\t<div class='column'>\n\t\t\t\t\t<img class='demo cursor' src=$img3 style='width:100%' onclick='setCurrentSlide($imgNum3)' alt='$des3'>\n\t\t\t\t</div>");
            prop.setProperty("$column4", "\n\t\t\t\t<div class='column'>\n\t\t\t\t\t<img class='demo cursor' src=$img4 style='width:100%' onclick='setCurrentSlide($imgNum4)' alt='$des4'>\n\t\t\t\t</div>");
            prop.setProperty("$column5", "\n\t\t\t\t<div class='column'>\n\t\t\t\t\t<img class='demo cursor' src=$img5 style='width:100%' onclick='setCurrentSlide($imgNum5)' alt='$des5'>\n\t\t\t\t</div>");
            prop.setProperty("$column6", "\n\t\t\t\t<div class='column'>\n\t\t\t\t\t<img class='demo cursor' src=$img6 style='width:100%' onclick='setCurrentSlide($imgNum6)' alt='$des6'>\n\t\t\t\t</div>");
            prop.setProperty("$img1", "https://i.imgur.com/RYg5QNB.jpeg");
            prop.setProperty("$des1", "The sea crashing over rocks");
            prop.setProperty("$img2", "https://i.imgur.com/LrWsMvR.jpg");
            prop.setProperty("$des2", "A bolt of lightning streaks the sky");
            prop.setProperty("$img3", "https://i.imgur.com/iJbBEyf.jpg");
            prop.setProperty("$des3", "A volcanic mountain range");
            prop.setProperty("$img4", "https://i.imgur.com/5OUSfJa.jpg");
            prop.setProperty("$des4", "Forest backed by a mountain");
            prop.setProperty("$img5", "https://i.imgur.com/SN086zQ.jpg");
            prop.setProperty("$des5", "Scenic picture of a lake");
            prop.setProperty("$img6", "https://i.imgur.com/O5D4yFg.jpg");
            prop.setProperty("$des6", "A river backed by snow capped mountains");

            // save properties to project root folder
            prop.store(output, null);
        }
    }
}
