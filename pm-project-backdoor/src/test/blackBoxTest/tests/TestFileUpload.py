import requests
import logger

formData = {
    "FileID" : 1,
    "UserID": "1",
    "UserPassword": "114514"
}
file = {
    "files" : open("./软件82班钟臻操作系统课内实验.pdf" , "rb")
}

response = requests.post(r'http://localhost:18080/file', data=formData, files = file)
response.encoding = 'utf-8'

logger.log(__file__, response)
