def search(X, arr):
	found = False
	ans = -1
	left = 0
	right = len(arr) - 1
	while (right >= left and not found):
		mid1 = left + ((right - left)//3)
		mid2 = right - ((right - left)//3)

		if (arr[mid1] == X):
			ans = mid1
			found = True
		if (arr[mid2] == X):
			ans = mid2
			found = True
		if (X < arr[mid1]):
			left = left
			right = mid1 - 1
		elif (X > arr[mid2]):
			left = mid2 + 1
			right = right
		else:
			left  = mid1 + 1
			right = mid2 -1
	return ans


def f(arr, n,x):
	index = 0
	counter =0
	a = 0
	b =0
	c =0
	while index < n:
		if index == 0:
			a = a+1
			index = index + 1
		if arr[index] >= arr[index-1]:
			b = b+1
			index = index + 1
		else:
			c= c + 1
			arr[index], arr[index-1] = arr[index-1], arr[index]
			index = index -1
		counter = counter + 1
	print("counter: {}\na: {}\nb: {}\nc: {}".format(counter,a,counter//2,((n**2) - n)//2))
	return arr

def main():
	array = []
	for i in range(10,0,-1):
		array.append(i)
	print(len(array))
	
	f(array, len(array), len(array)**2)
	print("DONE")

main()