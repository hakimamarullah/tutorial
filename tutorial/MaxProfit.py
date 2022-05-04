def findMinIndex(A):
	buy = findMinHelper(A,0,0)
	sell = findMaxIndex(A,buy,buy)
	return A[sell] - A[buy]

def findMinHelper(A,start,init):
	if(start == len(A)):
		return init
	if(A[start] < A[init]):
		init = start
	print("CALLED")
	return findMinHelper(A,start+1,init)

def findMaxIndex(A,start,init):
	if(start == len(A)):
		return init
	if(A[start] > A[init]):
		init = start
	return findMaxIndex(A,start+1,init)
def main():
	A=[67,32,40,32,100]
	print(findMinIndex(A))
main()