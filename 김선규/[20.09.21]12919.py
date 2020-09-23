def func(S, T):
    if len(S) == len(T):
        if S == T:
            return 1
        else:
            return 0
    else:
        if (S not in T) & (S[::-1] not in T):
            return 0
        return func(S + "A", T) | func(''.join(reversed(S+"B")), T)

def main():
    S = input()
    T = input()
    print(func(S, T))

if __name__ == "__main__":
    main()