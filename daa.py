from random import randint

def function(n):
	if n <= 0:
		print(" HALO")
		return 1
	angka = randint(0,n-1)
	print(str(angka) +" HALO")
	return function(angka) + function(n-1-angka)+1

def main():
	print(function(2))

main()