def main():
    sold_num = int(input())
    books = {}

    # {책이름:팔린 숫자}
    for i in range(sold_num):
        book_name = input()
        if book_name not in books.keys():
            books[book_name] = 1
        else:
            books[book_name] += 1

    most_sold_book = []
    for key in books.keys():
        if books[key] == max(books.values()):
            most_sold_book.append(key)
    most_sold_book.sort()
    print(most_sold_book[0])


if __name__ == '__main__':
    main()
