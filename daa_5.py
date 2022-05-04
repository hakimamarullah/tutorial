n = 2
def lis(prev,A):
    if(n==1):
        return ""
    elif len(A[1]) <= len(prev):
        return lis(prev, A[2:])
    else:
        skip = lis(prev,A[2:])
        take = lis(A[1], A[2:])+str(1)
        return max(skip,take)
lis("",["hal","hai"])