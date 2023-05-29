hashtable = dict()
example = [2, 15, 7, 11]
for i, num in enumerate(example):
    if 9 - num in hashtable:
        print(hashtable)
        print([hashtable[9 - num], i])
    hashtable[example[i]] = i
