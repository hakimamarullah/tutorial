def max_heapify(A,k):
    l = left(k)
    m = middle(k)
    r = right(k)
    largest = k
    if l < len(A) and A[l] > A[k]:
        largest = l
    else:
        largest = k
    if r < len(A) and A[r] > A[largest]:
        largest = r
    if m < len(A) and A[m] > A[largest]:
        largest = m
    if largest != k:
        A[k], A[largest] = A[largest], A[k]
        max_heapify(A, largest)

def left(i):
    return 3 * i + 3

def right(i):
    return 3 * i + 1

def middle(i):
    return 3*i + 2

def build_max_heap(A):
    n = len(A)//3
    for k in range(n, -1, -1):
        max_heapify(A,k)

A = [1,9,0,6,2,9,3,0,5,1]
build_max_heap(A)
print(A)