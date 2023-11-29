five refactors:
first refactor: 
links: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/5c9a9c2c0731985a5a4bad03fef3b5122a1cade1
refactor type: extract method
resaon: the original parseGraph method does read and parse, i extract the read part out of parseGraph class to be a new class: readFileContent

second refactor:
links: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/bf38663b073ccdf9854546beedfa36b666991566
Refactoring Type: Extract Variable
Reason: Improve readability by giving meaningful names to complex expressions.

third refactor: 
links: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/d5edb16f3836baabf553f40289860b9d119423e8
Refactoring Type: Rename Variable
Reason: Some variable names are too generic and do not convey the intent properly.

fourth refactor:
links: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/57832d6810b724ad4b721244e42194e396ce205c
Refactoring Type: Simplify Conditional
Reason: The conditional check for the file format in outputGraphics can be simplified.

fifth refactor: 
links: https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/4d510aa8be0a57e570d3121040c4455a5e67e440
Refactoring Type: Extract Method
Reason: There are multiple logical blocks within the toString method that could be extracted to their own methods for better clarity and maintainability

template patterns refactor:
https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/bf6aaf0c5eedb179155d71001e6371ca3bb8e030

strategy pattern refactor:
https://github.com/zxxt2002/CSE-464-2023-xzhao141/commit/b30b470aba2e825600f9c953acfe6add92287433

how to run the test cases:

for test bfs:
test class called testBFS(), input file should be named "search.dot", you could change the "A" and "D" to search for different path

for test dfs:
test class called testDFS(), input file should be named "search.dot", you could change the "A" and "D" to search for different path

for test random walk:
test class called testDFS(), input file should be named "search.dot", you could change the "A" and "G" to search for different path

screenshot of all the commit for part 3:
<img width="966" alt="Screenshot 2023-11-29 at 00 26 13" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/cf246a47-862f-4423-8ede-6709ebd0bdbe">

screenshot of continuous integration:
<img width="998" alt="Screenshot 2023-11-29 at 00 27 10" src="https://github.com/zxxt2002/CSE-464-2023-xzhao141/assets/99571021/cfa33b35-e881-48bb-971e-43ce46c5702e">
