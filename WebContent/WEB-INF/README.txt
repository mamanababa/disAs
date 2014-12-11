Fibonacci Sequence Application
============

Link to the project on GitHub:
https://github.com/mamanababa/disAs

Step 1
------------------------
The main/first page of this application is “Request.jsp”. 

Step 2
------------------------
You can only input a number between 1 and 93 as the length of Fibonacci sequence, other wise it would pop out a alert window to ask you input a valid number. The calculable length in this application is from 1 to 93, because the data type of Fibonacci sequence that calculated in this application is long, and appended as a StringBuilder then converted to String, the MAX_VALUE of LONG is 9223372036854775807, the 92nd and 93rd number of Fibonacci sequence are 4660046610375530309 and 7540113804746346429, so the 94th number(92nd number + 93rd number) is beyond the MAX_VALUE of LONG.

Step 3
------------------------
Then click the “submit” button to jump to next page(Response.jsp) to show the job number of your request then wait 10 seconds to jump to next page(Result.jsp) get the result of Fibonacci sequence and the length that you requested on the first page. There is a “return to start” button to back to the first page. 

Step 4
------------------------
On the first page, click “History” button to show all Fibonacci sequences that you requested before and their length. Click “README” button will show what you are reading now.

Thanks for using this application.