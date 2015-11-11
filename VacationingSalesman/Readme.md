How to run:

Call your version of python along with vacationing-salesman.py < filename
	i.e. python3 vacationing-salesman.py < GivenTest.txt


Why Python?

I researched what Libraries I could use in the languages I was most comfortable with (Java and Python) and there was a handy library called Geopy that I picked as it seemed easy to use. Only drawback from this library is the fact we can only query once a second to retrieve infromation of a city.


Design Decisions:

To be hoenst, I didn't feel like there were many design decisions besides splitting up the gathering of the cities from the text file from getting the distances from printing the output. Couldn't find a truly OOP way to do the task, but instead follow the scripting fundamentals.


Time:

If I had more time, I would try to find a better library to use as we can only query once a second, which hinders the number of distinct cities we could do in a given time. Also, would build up more tests but the given example seemed to work (besides a few miles which I take is from where Geopy decided where to mark where the cities were).