lst = []


def genWord(lst):
    n = int(input("Enter number of elements : "))
    for i in range(0, n):
        ele = input(f"Enter Word {i}\t")
        lst.append(ele)
    print(lst)


genWord(lst)
