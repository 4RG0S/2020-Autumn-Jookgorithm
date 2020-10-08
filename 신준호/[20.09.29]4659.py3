import re

def first(str):
    return ('a' in str) or ('e' in str) or ('i' in str) or ('o' in str) or ('u' in str)

def second(str):
    tmp = str
    tmp = re.sub('[aeiou]', '1', tmp)
    tmp = re.sub('[b-df-hj-np-tv-z]', '0', tmp)
    return not (('111' in tmp) or ('000' in tmp))

def third(str):
    for i in range(len(str) - 1):
        if str[i] == str[i+1]:
            if str[i] == 'o' or str[i] == 'e':
                continue
            return False
    return True

while True:
    str = input()
    if str == 'end':
        break

    if first(str) and second(str) and third(str):
        print('<{}> is acceptable.'.format(str))
    else:
        print('<{}> is not acceptable.'.format(str))
