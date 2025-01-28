def are_numbers_distinct(numbers):
    num_list = list(map(int, numbers.split()))
    return len(num_list) == len(set(num_list))
numbers = input("Enter a sequence of numbers separated by space: ")
if are_numbers_distinct(numbers):
    print("These numbers are distinct.")
else:
    print("Same numbers! Not distinct.")
