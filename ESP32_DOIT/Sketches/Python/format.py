# format.py

text = "Standard {:10} Zahlen"
print(text.format(12345))

text = "Linksbündige {:>10} Zahlen"
print(text.format(12345))

text = "Rechtsbündige {:<10} Zahlen"
print(text.format(12345))

text = "Zentrierte {:^10} Zahlen"
print(text.format(12345))