def even(k):
    # A number is even if its least significant bit is 0
    return (k & 1) == 0

# Example usage:
print(even(4))  # True
print(even(7))  # False
