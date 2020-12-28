import requests
import logger

formdata = {
    "UserID": "1",
    "UserPassword": "114514",
    "TeamID": "1"
}

response = requests.post(r'http://39.99.195.120:18080/login', data=formdata)
# response = requests.get(r'http://localhost:8080/login)
# response = requests.put(r'http://localhost:8080/login', data=formdata)
# response = requests.delete(r'http://localhost:8080/login', data=formdata)
response.encoding = 'utf-8'

logger.log(__file__, response)
