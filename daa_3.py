import random

def swap(arr, idx1, idx2):
    arr[idx1], arr[idx2] = arr[idx2], arr[idx1]

def randomized_select(A, p, r, i):
    if p==r:
        return A[p]
    q = randomized_partition(A, p , r)
    k = q - p + 1
    if i == k:
        return A[q]
    elif i < k:
        return randomized_select(A, p, q -1,i)
    else:
        return randomized_select(A, q+1, r, i-k)

def randomized_partition(A, p, r):
    i = random.randint(p,r)
    swap(A, r, i)
    return partition(A, p, r)

def partition(A, p, r):
    x = A[r]
    i = p-1
    for j in range(p, r):
        if A[j] <=x:
            i = i+1
            swap(A, i, j)
    swap(A, i+1, r)
    return i+1

def main():
    arr = [10,9,5,1,13]
    B=[3,10000000,4,7,8]
    print(randomized_select(arr,0, len(arr)-1,(len(arr)+1)/2))

if __name__ == "__main__":
    main()

