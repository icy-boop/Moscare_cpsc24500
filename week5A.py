#Taylor series
import math

def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

def taylor(a, h, n):
    #Calculate the Taylor series 
    if n < 0:
        return 0
    # Calculate the nth term of the Taylor series
    if n % 2 == 0:
        term = (math.cos(a) if (n // 2) % 2 == 0 else -math.sin(a)) * (h ** n) / factorial(n)
    else:           
        term = (math.sin(a) if (n // 2) % 2 == 0 else -math.cos(a)) * (h ** n) / factorial(n)
    
    return term + taylor(a, h, n - 1)

a = math.radians(45)  
h = math.radians(-1)  

approximation = taylor(a, h, 5)
print(f"This Approximates sin(44 degrees) using Taylor series: {approximation:.6f}")
