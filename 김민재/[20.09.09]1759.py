L, C = map(int, input().split())
alphabetList = list(map(str, input().split()))
alphabetList.sort()
passwordList = []

def checkPW(password):
    vowel = 0
    consonant = 0

    for char in password:
        if char in 'aeiou':
            vowel += 1
        else:
            consonant += 1

    return consonant >= 2 and vowel >= 1

def makePW(alpha_index, password_incomplete):
    if L > len(password_incomplete) and C > alpha_index:
        makePW(alpha_index + 1, password_incomplete + alphabetList[alpha_index])
        makePW(alpha_index + 1, password_incomplete)
    elif L == len(password_incomplete):
        passwordList.append(password_incomplete)
    else:
        return

makePW(0, '')

for password_candidate in passwordList:
    if checkPW(password_candidate):
        print(password_candidate)
