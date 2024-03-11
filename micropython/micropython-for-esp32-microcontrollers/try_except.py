# try_ecxept.py

while True:
  n = int(input("Please enter a number: "))
  print("Number was: ", n)
  try:
    print("Reciprocal is: ", 1/n)
  except:
    print("error")