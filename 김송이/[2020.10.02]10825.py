import re

def main():
    n = int(input())
    p=re.compile('(\D+)(\s)(\d+)(\s)(\d+)(\s)(\d+)')

    student_list = []
    regular_list=[]
    for i in range(n):
        student_list.append(input())


    #for student in student_list:
    #    s_list=p.findall(student)
    #    regular_list.extend(s_list)
    #print(regular_list)

    student_list.sort(key=lambda x: (-int(p.match(x).group(3)),int(p.match(x).group(5)),-int(p.match(x).group(7)),p.match(x).group(1)))
    print(student_list)
    for s in student_list:
        print_name=list(s.split())
        print(print_name[0])

if __name__ == '__main__':
    main()
