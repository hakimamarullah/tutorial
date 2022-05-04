from array import array
from cmath import inf
from json.tool import main
from re import A
import re


def second(arr):
    first = second = inf
    for i in range(len(arr)):
        if(arr[i] < first):
            print("YESS" + str(arr[i]))
            first, second = arr[i], first
        
        elif(arr[i] < second and arr[i] != first):
            print(arr[i])
            second = arr[i]
        
    return second

    
def main():
    arr = [8,7,6,5,4,3,2,1]
    print(second(arr))

main()
    

