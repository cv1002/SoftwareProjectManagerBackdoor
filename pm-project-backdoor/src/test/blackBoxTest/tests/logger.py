import time

def formatTime():
    def expandToLength(string, length):
        if len(string) < length:
            string = '0' * (length - len(string)) + string
        return string

    localTime = time.localtime(time.time())
    year = expandToLength(str(localTime.tm_year), 4)
    month = expandToLength(str(localTime.tm_mon), 2)
    day = expandToLength(str(localTime.tm_mday), 2)
    hour = expandToLength(str(localTime.tm_hour), 2)
    min = expandToLength(str(localTime.tm_min), 2)
    return (year, month, day, hour, min)


def log(fileName, response):
    if fileName.split('\\')[-1] == fileName:
        fileName = './tests/log/' + fileName.split('/')[-1]
    else:
        fileName = './log/' + fileName.split('\\')[-1]
    with open(fileName + '.log', 'a') as log:
        (year, month, day, hour, min) = formatTime()
        log.write('request when: \n')
        log.write(' ' * 4 + year + '/' + month + '/' + day + ' ' + hour + ':' + min + '\n')
        log.write('response text: \n')
        log.write(' ' * 4 + response.text + '\n')
        log.write('\n')
