def OBST(p,q):
  n = len(q)    
  
  w = [[999.0] * (n) for _ in range(n)]
  e = [[999.0] * (n) for _ in range(n)]
  r = [[999.0] * (n-1) for _ in range(n-1)]

  for i in range (n):
    w[i][i]=q[i]
    e[i][i]=q[i]
  
  for i in range (0,n):
    for j in range (i+1,n):
      w[i][j]=w[i][j-1]+p[j-1]+q[j]
  
  for x in range (1,n):
    i = 0
    j = x
    while(i < len(e) and j < len(e)):
      for r in range (i,j):
        cost=e[i][r]+e[r+1][j]+w[i][j]
        if(e[i][j]>cost):
          e[i][j]=cost
      j += 1
      i +=1
  for i in e:
    print(i)

p=[0.20,0.05,0.05,0.10,0.10]
q=[0.10,0.05,0.10,0.05,0.05,0.15]

OBST(p,q)