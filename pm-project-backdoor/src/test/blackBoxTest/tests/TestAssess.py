import requests
import logger

formdata = {
    "UserID": 1,
    "UserPassword": "114514",
    "Assess": "afsadasd",
    "Score": 100,
    "Student": '''{
        "StudentUserID": 1,
        "StudentClass": 80,
        "StudentID": 1,
        "TeamID": 1
    }'''
}

response = requests.post(r'http://localhost:8080/studentAssess', data=formdata, json=jsondata)
# response = requests.get(r'http://localhost:8080/studentAssess')
# response = requests.put(r'http://localhost:8080/login', data=formdata)
# response = requests.delete(r'http://localhost:8080/login', data=formdata)
response.encoding = 'utf-8'

logger.log(__file__, response)
