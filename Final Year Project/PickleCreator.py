import pickle

def createPickle(type, data):
    if type == "link":
        output = open('UserInterfaceResources/PickleFiles/savedlink.pkl', 'wb')
        pickle.dump(data, output)
        output.close()
    if type == "write":
        output = open('UserInterfaceResources/PickleFiles/write.pkl', 'wb')
        pickle.dump(data, output)
        output.close()
