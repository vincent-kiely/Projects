import tkinter as tk
from tkinter import messagebox
import WriteSimulatorTextFiles
import pickle
import time
import PickleCreator as pc
import subprocess
import re
import validators
import os
from os import path

imageGalleryFields = 'Name of HTML file:', 'Title of Gallery:', 'Image Description Colour:', 'Link to first image:', 'Description of first image:', 'Link to second image:', 'Description of second image:', 'Link to third image:', 'Description of third image:', 'Link to fourth image:', 'Description of fourth image:', 'Link to fifth image:', 'Description of fifth image:', 'Link to sixth image:', 'Description of sixth image:', 
loginFields = 'Name of HTML file:', 'Colour of Container:', 'Colour of Button Text:', 'Colour of Login Button:', 'Colour of Cancel Button:', 'Page Title:', 'Description of Page:', 'Email example text:', 'Password example text:'
registrationFields = 'Name of HTML file:', 'Colour of Container:', 'Colour of Button Text:',  'Colour of SignUp Button:', 'Colour of Cancel Button:', 'Page Title:', 'Description of Page:', 'Email example text', 'Password example text:', 'Repeat example text:'
socialMediaLinksFields = 'Name of HTML file:', 'Colour of Container:', 'Description of Page:', 'Facebook Link:', 'Twitter Link:', 'Linkedin Link:', 'Instagram Link:', 'Youtube Link:'

def simulate(entries, name):
    writeList = []
    valid = True
    for entry in entries:
        text  = entry[1].get()
        if text == "":
            text = "null"
        if "Colour" in entry[0] and not text == "null":
            valid = checkHexCode(text) 
            if not valid:
                break
        if "Link" in entry[0] and not text == "null":
            valid = checkLink(text) 
            if not valid:
                break
        writeList.append(text)
    if (valid):
        if name == "imageGallery":
            simulateImageGallery(writeList)
        elif name == "login":
            simulateLogin(writeList)
        elif name == "registration":
            simulateRegistration(writeList)
        elif name == "socialMediaLinks":
            simulateSocialMediaLinks(writeList)

def simulateImageGallery(writeList):
    WriteSimulatorTextFiles.writeImageGallery(writeList)
    fullLink = 'SimulatedFeatures/UserFeatures/' + writeList[0] + ".html"
    if path.isfile(fullLink):
        pc.createPickle("link", fullLink)
        subprocess.call(['python', 'DisplayFeature.py'])
        root.quit()
    else:
        messagebox.showerror("Error during simulation process","An error occured during the simulation\n File was not created!\nPlease check your input to ensure that all input is correct")

def simulateLogin(writeList):
    WriteSimulatorTextFiles.writeLogin(writeList)
    fullLink = 'SimulatedFeatures/UserFeatures/' + writeList[0] + ".html"
    if path.isfile(fullLink):
        pc.createPickle("link", fullLink)
        subprocess.call(['python', 'DisplayFeature.py'])
        root.quit()
    else:
        messagebox.showerror("Error during simulation process","An error occured during the simulation\n File was not created!\nPlease check your input to ensure that all input is correct")

def simulateRegistration(writeList):
    WriteSimulatorTextFiles.writeRegistration(writeList)
    fullLink = 'SimulatedFeatures/UserFeatures/' + writeList[0] + ".html"
    if path.isfile(fullLink):
        pc.createPickle("link", fullLink)
        subprocess.call(['python', 'DisplayFeature.py'])
        root.quit()
    else:
        messagebox.showerror("Error during simulation process","An error occured during the simulation\n File was not created!\nPlease check your input to ensure that all input is correct")

def simulateSocialMediaLinks(writeList):
    WriteSimulatorTextFiles.writeSocialMediaLinks(writeList)
    fullLink = 'SimulatedFeatures/UserFeatures/' + writeList[0] + ".html"
    if path.isfile(fullLink):
        pc.createPickle("link", fullLink)
        subprocess.call(['python', 'DisplayFeature.py'])
        root.quit()
    else:
        messagebox.showerror("Error during simulation process","An error occured during the simulation\n File was not created!\nPlease check your input to ensure that all input is correct")

def checkHexCode(code):
    match = re.search(r'^#(?:[0-9a-fA-F]{3}){1,2}$', code)
    if match:                   
        return True
    else:
        messagebox.showerror("Invlaid Hex Code","Please enter a valid Hex Code!\nA valid Hex Code starts with a '#' and is 3 or 6 digits long.\nFor Example: '#85C1E9'")
        return False

def checkLink(link):
    valid = validators.url(link)
    if valid:                       
        return True
    else:  
        messagebox.showerror("Invlaid URL","Please enter a valid URL!\nA valid URL starts with 'https://'.\nFor Example: 'https://www.google.com'")
        return False

def makeform(root, fields, title):
    entries = []
    title = tk.Label(root, text='Enter values for simulating a{}'.format(title))
    title.config(font=('helvetica', 14))
    title.pack()
    container = tk.Canvas(root, width = 500, height = 1,  relief = 'raised')
    container.pack()
    for field in fields:
        row = tk.Frame(root)
        lab = tk.Label(row, width=23, text=field, anchor='w')
        lab.config(font=('Helvetica', 12))
        ent = tk.Entry(row, width=30)
        row.pack(side=tk.TOP, fill=tk.X, padx=5, pady=5)
        lab.pack(side=tk.LEFT)
        ent.pack(side=tk.RIGHT, expand=tk.YES, fill=tk.X)
        entries.append((field, ent))
    return entries

if __name__ == '__main__':
    root = tk.Tk()
    root.title("Entering Details")
    root.resizable(0, 0)
    pkl_file = open('UserInterfaceResources/PickleFiles/write.pkl', 'rb')
    name = pickle.load(pkl_file)
    pkl_file.close()
    if name == "imageGallery":
        ents = makeform(root, imageGalleryFields, "n Image Gallery")
    elif name == "login":
        ents = makeform(root, loginFields, " Login Form")
    elif name == "registration":
        ents = makeform(root, registrationFields, " Registration Form")
    elif name == "socialMediaLinks":
        ents = makeform(root, socialMediaLinksFields, " Social Media Sharing Form")

    root.bind('<Return>', (lambda event, e=ents: simulate(e,name)))   

    bttnFrame = tk.Frame(root)
    bttnFrame.pack(fill=tk.X, side=tk.BOTTOM, padx=8, pady=8)

    bttnFrame.columnconfigure(0, weight=1)
    bttnFrame.columnconfigure(1, weight=1)

    simulateBttn = tk.Button(bttnFrame, text='Simulate Feature',
                  command=(lambda e=ents: simulate(e,name)), bg='#3DED97', fg='#333333', font=('helvetica', 9, 'bold'))
    cancelBttn = tk.Button(bttnFrame, text='Cancel Simulation', command=root.quit, bg='#f55676', fg='#333333', font=('helvetica', 9, 'bold'))

    simulateBttn.grid(row=0, column=1, sticky=tk.W+tk.E, padx=2)
    cancelBttn.grid(row=0, column=0, sticky=tk.W+tk.E, padx=2)

    root.mainloop()
