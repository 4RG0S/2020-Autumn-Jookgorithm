import sys

keyboard = ['`','1','2','3','4','5','6','7','8','9','0','-','=','Q','W','E','R','T','Y',
'U','I','O','P','[',']','\\','A','S','D','F','G','H','J','K','L',';','\'',
'Z','X','C','V','B','N','M',',','.','/']

for line in sys.stdin :
    line = line.rstrip()
    plain = []
    for c in line :
        if (c != ' ') :
            plain.append(keyboard[keyboard.index(c)-1])
        else :
            plain.append(' ')
    print(''.join(plain))