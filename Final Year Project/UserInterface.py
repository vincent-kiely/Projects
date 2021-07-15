import tkinter as tk         
from tkinter import font as tkfont 
from tkinter import filedialog
from tkinter import messagebox
import os
import PickleCreator as pc
import subprocess

class Application(tk.Tk):

    def __init__(self, *args, **kwargs):
        tk.Tk.__init__(self, *args, **kwargs)
        self.title("Simulator Interface")
        self.geometry('600x300')
        self.resizable(0, 0)

        bttnFrame = tk.Frame(self)
        bttnFrame.pack(fill=tk.X, side=tk.TOP, padx=8, pady=8)

        bttnFrame.columnconfigure(0, weight=1)
        bttnFrame.columnconfigure(1, weight=1)

        simulateBttn = tk.Button(bttnFrame, text='Simulate Feature', command=lambda: self.show_frame("SimulatePage"), width=10, height=2, bg='white', fg='#333333', font=('helvetica', 9, 'bold'))
        loadBttn = tk.Button(bttnFrame, text='Load Simulation', command=lambda: self.show_frame("LoadPage"), width=10, height=2, bg='white', fg='#333333', font=('helvetica', 9, 'bold'))

        simulateBttn.grid(row=0, column=0, sticky=tk.W+tk.E, padx=2)
        loadBttn.grid(row=0, column=1, sticky=tk.W+tk.E, padx=2)

        self.titleFont = tkfont.Font(family='Helvetica', size=18, weight="bold", slant="italic")

        frameContainer = tk.Frame(self)
        frameContainer.pack(side="top", fill="both", expand=True)
        frameContainer.grid_rowconfigure(0, weight=1)
        frameContainer.grid_columnconfigure(0, weight=1)

        self.frames = {}
        for F in StartPage, SimulatePage, LoadPage:
            pageName = F.__name__
            frame = F(parent=frameContainer, controller=self)
            self.frames[pageName] = frame

            frame.grid(row=0, column=0, sticky="nsew")

        self.show_frame("StartPage")

    def show_frame(self, pageName):
        frame = self.frames[pageName]
        frame.tkraise()


class StartPage(tk.Frame):

    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        self.controller = controller
        label = tk.Label(self, text="Please select an operation!", font=controller.titleFont)
        label.pack(side="top", fill="x", pady=10)


class SimulatePage(tk.Frame):

    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        self.controller = controller

        OptionList = [
        "Image Gallery",
        "Login",
        "Registration",
        "Social Media Sharing"
        ] 

        self.variable = tk.StringVar(self)
        self.variable.set(OptionList[0]) # default value

        label = tk.Label(self, text="What feature you would like to simulate?", font=controller.titleFont)
        label.pack(side="top", fill="x", pady=10)

        container = tk.Canvas(self, width = 500, height = 35,  relief = 'raised')
        container.pack()

        menu = tk.OptionMenu(self, self.variable, *OptionList)
        menu.config(width=50, font=('Helvetica', 12), padx=10, pady=10)
        menu.pack()

        container = tk.Canvas(self, width = 500, height = 10,  relief = 'raised')
        container.pack()

        bttnFrame = tk.Frame(self)
        bttnFrame.pack(fill=tk.X, side=tk.TOP, padx=8, pady=8)
        bttn = tk.Button(bttnFrame, text="Simulate", command=self.simulate, bg='white', fg='#333333', font=('helvetica', 9, 'bold'))
        bttn.pack(in_=bttnFrame, side="right", padx=5)

    def simulate(self):
        pc.createPickle("write", self.convert_options())
        subprocess.call(['python', 'DisplaySimulatorEntries.py'])

    def convert_options(self):
        result = ""
        if self.variable.get() == "Login":
            result = "login"
        elif self.variable.get() == "Registration":
            result = "registration"
        elif self.variable.get() == "Social Media Sharing":
            result = "socialMediaLinks"
        elif self.variable.get() == "Image Gallery":
            result = "imageGallery"
        return str(result)


class LoadPage(tk.Frame):
    
    def __init__(self, parent, controller):
        tk.Frame.__init__(self, parent)
        self.controller = controller
        label = tk.Label(self, text="Please select a file to load!", font=controller.titleFont)
        label.pack(side="top", fill="x", pady=10)

        
        container = tk.Canvas(self, width = 500, height = 35,  relief = 'raised')
        container.pack()

        self.entryText = tk.StringVar()
        self.bar = tk.Entry(self, textvariable=self.entryText ).pack(side="top", ipadx=200, ipady=5, padx=10, pady=10)

        container = tk.Canvas(self, width = 500, height = 10,  relief = 'raised')
        container.pack()
        
        bttnFrame = tk.Frame(self)
        bttnFrame.pack(fill=tk.X, side=tk.TOP, padx=8, pady=8)

        searchBttn = tk.Button(bttnFrame, text='Select File', command= self.browse_files, bg='white', fg='#333333', font=('helvetica', 9, 'bold'))
        loadBttn = tk.Button(bttnFrame, text='Load File', command= self.load_file, bg='white', fg='#333333', font=('helvetica', 9, 'bold'))
        loadBttn.pack(in_=bttnFrame, side="right", padx=5)
        searchBttn.pack(in_=bttnFrame, side="right")

    def browse_files(self):
        fileTypes = [('html files', '.html')]
        answer = filedialog.askopenfilename(parent=self, initialdir=os.getcwd(), title="Please select a file:", filetypes=fileTypes)
        self.entryText.set(answer)
        

    def load_file(self):
        if self.entryText.get() == "":
            messagebox.showerror("Missing Data","No file has been selected!")
        else:
            pc.createPickle("link", self.entryText.get())
            subprocess.call(['python', 'DisplayFeature.py'])

if __name__ == "__main__":
    app = Application()
    app.mainloop()