def count_vowels(s):
    vowels = "aeiouAEIOU"
    return sum(1 for char in s if char in vowels)

string = input("Enter a string: ")
vowel_count = count_vowels(string)
print(f"The number of vowels in the string is: {vowel_count}")
