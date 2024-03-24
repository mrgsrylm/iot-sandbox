# labeled_format.py

text = "The result of {calc} is {res}"
print(text.format(res = 3*8, calc = "3 x 8"))

text = "The result of {calc} is {res:5.3f}"
print(text.format(res = 22 / 3, calc = "22 / 3"))

