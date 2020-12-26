import requests

formdata = {
    "UserID": 1,
    "UserPassword": "123456",
    "teamID": 1,
    "FileID": 1
}
cookies = {
    "userID": "1",
    "userPassword": "123456"
}
#response = requests.get(r'http://localhost:8080/login', data=formdata)
response = requests.put(r'http://localhost:8080/file', data=formdata , cookies = cookies)
# response = requests.get(r'http://localhost:8080/login?param1=xxx&param2=yyy')
# response = requests.put(r'http://localhost:8080/login', data=formdata)
# response = requests.delete(r'http://localhost:8080/login', data=formdata)
response.encoding = 'utf-8'
print(response.text)