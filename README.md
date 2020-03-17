# SimpleCalculator
A simple calculator that i made in SLU during my freshman year 2019 to 2020
3/11/2020

FAQ:

Algorithm used?
 - Shunting Yard Algorithm by Dijkstra

Why Shunting Yard?
 - Shunting yard is used for getting the Reverse Polish Notation of a given series.
 
What is RPN (Reverse Polish Notation)?
 - It is a re-arranged series of the user's input which is arranged through proper precedence of operators.

After getting the RPN, What now?
 - The given RPN of the user's inputted series would then be computer.
 
How is the computing done?
 - A token is taken from the given series ( series is splitted into different tokens by a space ) then the algorithm checks
 if it is a number. If it is it would then be added to the stack, if it is not it is automatically understood that the token
 is an operator. There are 2 kinds of operators given. First one is an operator that needs two numbers for computing and the
 other one only needs one.
 
TLDR'd the computing process...
 <br/> IF (TOKEN IS DIGIT)
 <br/>     PUT TOKEN IN STACK
 <br/> ELSE
 <br/>     IF TOKEN NEEDS TWO NUMBERS
 <br/>        COMPUTE NUM1 && NUM 2 WITH GIVEN TOKEN
 <br/>     ELSE
 <br/>        COMPUTE NUM WITH GIVEN TOKEN
          
          
