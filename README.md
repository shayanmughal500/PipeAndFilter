# Pipe And Filter
The program implements the Pipe and Filter pattern using Java Streams and functional programming. It takes a list of integers as input and processes it through a series of filters applied sequentially. The filters include:
 
## 1. Filtering even numbers.
## 2. Squaring the numbers.
## 3. Filtering numbers greater than 10.
## 4. Filtering prime numbers.

Each filter is represented as a function and applied in sequence, demonstrating a modular and reusable pipeline approach to data processing. The final output is printed after all transformations are applied.

# Updated Code
In addition to the existing filters (filtering even numbers, squaring numbers, and filtering numbers greater than 10), I have also added:

## Filtering prime numbers – A filter that keeps only prime numbers.

## How the Program Works
The input list is processed sequentially through each filter in the pipeline.
Each filter applies a transformation to the list and passes the modified result to the next filter.
The final result is printed after all transformations.
