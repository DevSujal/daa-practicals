import sys
def mcolor(G, k, x, n, m,color_code):
    while True:
        nextValue(G, k, x, n, m)
        if x[k] == 0:
            return 
        if k == n - 1:
#             color_code.append(x[:])
            print(x)
            # sys.exit(0
            return 
        else:
            mcolor(G, k + 1, x, n, m,color_code)

def nextValue(G, k, x, n, m):
    while True:
        x[k] = (x[k] + 1) % (m + 1)
        if x[k] == 0:
            return 
        j = 0
        while j < n:
            if G[k][j] != 0 and x[k] == x[j]:
                break
            j += 1
        if j == n:
            return
        

# G = [
#     [0, 1, 1, 0, 1, 1],
#     [1, 0, 1, 0, 0, 0],
#     [1, 0, 0, 1, 0, 0],
#     [0, 0, 1, 0, 1, 0],
#     [1, 0, 0, 1, 0, 1],
#     [1, 0, 0 ,0, 1, 0]
#     ]
# n = 6
# x = [0 for _ in G[0]]
color_code = []

# m = 3
# while m != 0:
#     m = int(input("Enter No of Colors - "))
#     mcolor(G,0,x,n,m,color_code)
#     if color_code and m != 0 :
#         print(color_code)
#     else:
#         print("Insufficient Colors")

G = [
    [0, 1, 1, 1, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 0, 1, 1],
    [1, 1, 1, 0, 1],
    [1, 1, 1, 1, 0]
    ]
n = 5
x = [0 for _ in G[0]]
m = 2
mcolor(G,0,x,n,m,color_code)
while m != 0:
    color_code = []
    m = int(input("Enter No of Colors - "))
    mcolor(G,0,x,n,m,color_code)
    if color_code and m != 0 :
        print(color_code)
    else:
        print("Insufficient Colors")