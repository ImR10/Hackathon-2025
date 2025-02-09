Programmers: Rizwan Hoque and Daniel 

## Inspiration
We just wanted to create something simple for our first hackathon that allowed us to practice OOP, especially with Java. We decided to better implement a grade calculator that could also be practical for the forthcoming semesters here at UGA for determining our grades. 

## What it does
It asks you if you want to use the pre-installed grading scale or create your own (including the +/—system). Then, it asks you what grade you need to pass the class. Afterward, it'll ask you for the name of the class you're trying to calculate the grade for, the number of grading categories in the class, as well as the weight of each category. Finally, it prints out a summary, as well as your final numerical and letter grade alongside whether or not you passed the class.

## How we built it
We structured it into 3 classes: the main class that runs the grade calculator, the GradeCalculator class that holds the chunk of this project, such as initializing the different grading scales and computing the final grade, and the GradeCategory class that holds the different grade categories and assigns each of them the name, weight, and current grade for each object. 

## Challenges we ran into
The biggest one was debugging the different scanner inputs. Because many of the scanner calls nextInt(), we had to make sure that exceptions were properly handled. Even right now, there very well could be some that we missed, but we now know for later how to handle them properly.

## Accomplishments that we're proud of
The biggest accomplishment that we are proud of, of course, is having a functional calculator that will help us calculate our grades for the upcoming semester(s). Also, we're really proud of how we now have better practice with classes, objects, and methods, as these are fundamental skills of OOP that are needed.

## What we learned
The biggest thing that we learned is how to partition tasks and make a plan before just jumping headfirst into the project. Many times, we were confused as to how different methods and classes would interact with each other, but when you take a step back and draw out what's happening/what you want for the program to happen, many things begin to clear themselves up.

## What's next for Java Grade Calculator
Keep adding more features to it. We wanted to add a final grade calculator that will help you determine what you need to get for your final exam to get ___ grade. Unfortunately, we ran out of time before we could implement this part. We also wanted to make it calculate the grades for multiple courses, not just one, which would require another class to hold these course objects, similar to what we did with the grade categories. Who knows? Maybe we will even have a GPA calculator function built into it too in the future!
