from functools import cmp_to_key
n = int(input())

class Student:

    def __init__(self, name, kor, eng, math):
        self.name = name
        self.kor = kor
        self.eng = eng
        self.math = math

def compare(x, y):
    if x.kor < y.kor:
        return 1
    elif x.kor > y.kor:
        return -1
    else:
        if x.eng > y.eng:
            return 1
        elif x.eng < y.eng:
            return -1
        else:
            if x.math < y.math:
                return 1
            elif x.math > y.math:
                return -1
            else:
                if x.name > y.name:
                    return 1
                elif x.name < y.name:
                    return -1
                else:
                    return 0

students = list()
for _ in range(n):
    name, kor, eng, math = input().split()
    students.append(Student(name, int(kor), int(eng), int(math)))

students = sorted(students, key=cmp_to_key(compare))
for student in students:
    print(student.name)
    #print('{}, {}, {}, {}'.format(student.name, student.kor, student.eng, student.math))


