from cmath import inf
from dis import dis


def closest(A,B):
    total = 0
    distances = []
    for i in range(min(A),max(A)+1):
        for j in range(len(A)):
            total += B[j]*abs(i-A[j])
        distances.append((i,total))
        total = 0
    mins = inf
    index = 0
    for dist in distances:
        if dist[1] < mins:
            mins = dist[1]
            index = dist[0]
    return index



def main():
    A = [10,9,5,1,13]
    B=[0,1000000,4,7,8]
    print(closest(A,B))

if __name__ == "__main__":
    main()