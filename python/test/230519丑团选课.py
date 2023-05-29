n, m, q = map(int, input().split())
s = list(map(int, input().split()))
f = [list(map(int, input().split())) for i in range(4)]
g = [list(map(int, input().split())) for i in range(m)]
for i in range(q):
    A, B, c = map(int, input().split())
    if g[A-1][c-1] and f[B-1][c-1]:
        print("Help yourself")
    elif s[c-1] == A:
        print("Ask for help")
    else:
        print("Impossible")
