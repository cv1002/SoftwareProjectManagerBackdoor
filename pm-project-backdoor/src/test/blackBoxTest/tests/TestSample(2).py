import requests
import logger

formdata = {

}
file = {
    "files" : open("E:/114514.txt" , "rb")
}
cookies = {
    "userID": "1",
    "userPassword": "114514"
}
#response = requests.get(r'http://localhost:8080/login', data=formdata)
response = requests.post(r'http://localhost:8080/file', data=formdata , cookies = cookies , files = file)
# response = requests.get(r'http://localhost:8080/login?param1=xxx&param2=yyy')
# response = requests.put(r'http://localhost:8080/login', data=formdata)
# response = requests.delete(r'http://localhost:8080/login', data=formdata)
response.encoding = 'utf-8'

logger.log(__file__, response)
