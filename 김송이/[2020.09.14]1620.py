def main():
    pocketmon_num, quiz_num = map(int, input().split())
    pockedex = {}
    for i in range(1, pocketmon_num + 1):
        pockedex[i] = input()

    for _ in range(quiz_num):
        quiz = input()
        if quiz.isalpha():
            pocketmon_name = [k for k, v in pockedex.items() if v == quiz]
            print(pocketmon_name[0])

        elif quiz.isdigit():
            quiz = int(quiz)
            print(pockedex[quiz])


if __name__ == '__main__':
    main()
