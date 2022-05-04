def fsexp(a,b,n):
	binary = bin(b).replace("0b","")
	c=0
	f=1
	for i in range(0,len(binary)):
		c = 2 * c
		f = (f*f) % n
		print("Before "+str(f), end=" ")
		if(binary[i] == '1'):
			c = c+1
			f = (f*a) % n
			print("AFTER "+str(f))
	return f

def main():
	print(fsexp(100,199,3869))

if __name__ == '__main__':
	main()