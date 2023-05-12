# ISBN Report


The worst-case space complexity of this solution is O(n), where `n` is the `length` of the input `string isbn`. 

This means that the amount of memory used by the program grows in a linear manner with the size of the input, because the algorithm does not create any additional data structures that grow with the input size, such as arrays or lists.

We can see this in our algorithm process, where:

- The only data stored is the integer variable `sum` and a `dictionary` of character variables.
- The `sum` is the only variable that grows in size when iterating through the input string, however it has also reaches a limit (max number). 
- And, the character variables size remain constant, with the original input size.

Therefore, the amount of memory used by the algorithm is proportional to the length of the input string, and the worst-case space complexity is O(n). For example, the longer our input string is, the more space the program may need to use to store the processed reults. However, this will not be a problem given the use case of this program is to check ISBN strings which are either 10 or 13 characters long.

In conlusion, the space complexity 0(n) is considered to be the most efficient and is unlikely to cause any memory-related issues for even very large inputs.