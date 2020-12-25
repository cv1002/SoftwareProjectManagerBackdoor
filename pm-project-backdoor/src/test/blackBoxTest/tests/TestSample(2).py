import requests
import logger

formdata = {
    "UserID": 1,
    "UserPassword": "123456",
    "TeamID": 1
}

response = requests.post(r'http://localhost:8080/login', data=formdata)
# response = requests.get(r'http://localhost:8080/login?param1=xxx&param2=yyy')
# response = requests.put(r'http://localhost:8080/login', data=formdata)
# response = requests.delete(r'http://localhost:8080/login', data=formdata)
response.encoding = 'utf-8'

logger.log(__file__, response)
