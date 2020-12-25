import os
import threading


class doTest(threading.Thread):
    def __init__(self, fileName):
        threading.Thread.__init__(self)
        self.fileName = fileName
        self.suffix = fileName.split('.')

    def run(self):
        if self.suffix[-1] == 'py' and \
           self.fileName.startswith('Test'):
            print(f'do test \'{self.fileName}\'')
            os.system(f'python ./tests/{self.fileName}')


files = os.listdir('./tests')
threads = []
for eachFile in files:
    subThread = doTest(eachFile)
    threads.append(subThread)
    subThread.start()
