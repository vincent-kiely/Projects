import subprocess
import DisplayFeature
import PickleCreator
import logging
import logging.handlers
import os
from os import path

def runImageGalleryTests():
    #The initial running of the simulator is done to check if the simulator is functioning properlly
    #If the file is created then the test passes
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testImageGalleryWorks.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testImageGalleryWorks.html"):
        logging.info("Imgae Gallery Test 1: PASSED")
    else:
        logging.warning("Imgae Gallery Test 1: Failed")
    #The second run of the simulator checks if it will catch an error in the text file
    #If the file is created then the test fails as the error it causes cannot be resolved by the simulator
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testImageGalleryError.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testImageGalleryError.html"):
        logging.warning("Imgae Gallery Test 2: FAILED")
    else:
        logging.info("Imgae Gallery Test 2: PASSED")

def runLoginTests():
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testLoginWorks.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testLoginWorks.html"):
        logging.info("Login Test 1: PASSED")
    else:
        logging.warning("Login Test 1: FAILED")
    
def runRegistrationTests():
    #The initial run of the simulator is done to check if the simulator is functioning properlly
    #If the file is created then the test passes
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testRegistrationWorks.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testRegistrationWorks.html"):
        logging.info("Registration Test 1: PASSED")
    else:
        logging.warning("Registration Test 1: FAILED")
    #The second run of the simulator checks if it will catch an error in the text file
    #If the file is created then the test passes as the simulator will be able to handle the error within this file
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testRegistrationError.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testRegistrationError.html"):
        logging.info("Registration Test 2: PASSED")
    else:
        logging.warning("Registration Test 2: FAILED")
    
def runSocialMediaLinksTests():
    #The initial running of the simulator is done to check if the simulator is functioning properlly
    #If the file is created then the test passes
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testSocialMediaLinksWorks.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testSocialMediaLinksWorks.html"):
        logging.info("Social Media Links Test 1: PASSED")
    else:
        logging.warning("Social Media Links Test 1: FAILED")
    #The second run of the simulator checks if it will catch an error in the text file
    #If the file is created then the test fails as the error it causes cannot be resolved by the simulator
    subprocess.check_output("java -cp JavaSimulator/org.apache.commons.io.jar JavaSimulator/Simulator.java testSocialMediaLinksError.txt", stderr=subprocess.PIPE)
    if path.isfile("SimulatedFeatures/TestFeatures/testSocialMediaLinksError.html"):
        logging.warning("Social Media Links Test 2: FAILED")
    else:
        logging.info("Social Media Links Test 2: PASSED")

if __name__== "__main__":
    dir = 'SimulatedFeatures/TestFeatures'
    for f in os.listdir(dir):
        os.remove(os.path.join(dir, f))
    logging.basicConfig(filename="TestLogs/TestResults.log",
                        filemode='a',
                        format='%(asctime)s,%(msecs)d %(name)s %(levelname)s %(message)s',
                        datefmt='%H:%M:%S',
                        level=logging.DEBUG)

    runImageGalleryTests()
    runLoginTests()
    runRegistrationTests()
    runSocialMediaLinksTests()

    logging.info("Tests have finished running\n")