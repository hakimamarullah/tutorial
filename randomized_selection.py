def randomized_select(A,p,r,i):
    if(p==r):
        print("AHHHA")
        return A[p]
    q = randomized_partition(A,p,r)
    print(q)
    print(A)
    k = q - p + 1
    if(i == k):
        print("gotcha")
        return A[q]
    elif i<k:
        print("YESSSSSSSS "+ str(k),end="\n")
        return randomized_select(A,p, q-1,i)
    else:
        print("NOOOOOOOOOOOO "+ str(k),end="\n")
        return randomized_select(A,q+1, r,i-k)

def randomized_partition(A,p,r):
    x = A[r]
    i = p -1
    for j in range(p,r-1):
        if A[j] <= x:
            i = i+1
            A[i], A[j] = A[j], A[i]
    A[i+1], A[r] = A[r], A[i+1]
    return i+1

def main():
    A=[9,4,2,5,7,8,3,4,1,6]
    print("\nNICE" + str(randomized_select(A,0,len(A)-1,3)))

main()