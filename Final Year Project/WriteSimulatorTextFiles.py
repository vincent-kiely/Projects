import subprocess

def writeImageGallery(list):
    imageGalleryDictionary = {"fileName" : list[0], 
        "$title" : list[1],
        "$imageDesColour" : list[2],
        "$img1" : list[3],
        "$des1" : list[4],
        "$img2" : list[5],
        "$des2" : list[6],
        "$img3" : list[7],
        "$des3" : list[8],
        "$img4" : list[9],
        "$des4" : list[10],
        "$img5" : list[11],
        "$des5" : list[12],
        "$img6" : list[13],
        "$des6" : list[14]}
    file = open("JavaSimulator/Resources/SimulatorTextFiles/simulateImageGallery.txt", "w")
    for key, val in imageGalleryDictionary.items():
        file.write(key + "=" + val + "\n")
    file.close()
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java simulateImageGallery.txt", stderr=subprocess.PIPE)
            
def writeLogin(list):
    loginDictionary = {"fileName" : list[0], 
        "$containerColour" : list[1],
        "$textColour" : list[2],
        "$buttonColour" : list[3],
        "$cancelColour" : list[4],
        "$pageTitle" : list[5],
        "$pageDescription" : list[6],
        "$emailText" : list[7],
        "$passwordText" : list[8]}

    file = open("JavaSimulator/Resources/SimulatorTextFiles/simulateLogin.txt", "w")
    for key, val in loginDictionary.items():
        file.write(key + "=" + val + "\n")
    file.close()
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java simulateLogin.txt", stderr=subprocess.PIPE)

def writeRegistration(list):
    registrationDictionary = {"fileName" : list[0], 
        "$containerColour" : list[1],
        "$textColour" : list[2],
        "$buttonColour" : list[3],
        "$cancelColour" : list[4],
        "$pageTitle" : list[5],
        "$pageDescription" : list[6],
        "$emailText" : list[7],
        "$passwordText1" : list[8],
        "$passwordText2" : list[9]}
        
    file = open("JavaSimulator/Resources/SimulatorTextFiles/simulateRegistration.txt", "w")
    for key, val in registrationDictionary.items():
        file.write(key + "=" + val + "\n")
    file.close()
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java simulateRegistration.txt", stderr=subprocess.PIPE)


def writeSocialMediaLinks(list):
    socialMediaLinksDictionary = {"fileName" : list[0], 
        "$containerColour" : list[1],
        "$title" : list[2],
        "$link1" : list[3],
        "$link2" : list[4],
        "$link3" : list[5],
        "$link4" : list[6],
        "$link5" : list[7]}

    file = open("JavaSimulator/Resources/SimulatorTextFiles/simulateSocialMediaLinks.txt", "w")
    for key, val in socialMediaLinksDictionary.items():
        file.write(key + "=" + val + "\n")
    file.close()
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java simulateSocialMediaLinks.txt", stderr=subprocess.PIPE)
