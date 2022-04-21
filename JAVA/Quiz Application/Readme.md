
  

<h3  align="center">Quiz Application</h3>

  

  

<p  align="center">

A simple Quiz Application built using Java

</p>

  

<br />

  

  

<details>

  

<summary><b>Table of Contents</summary>

  

<ol>

  

<li>

  

<a  href="#about-the-project">About The Project</a>

  

<ul>

  

<li><a  href="#built-with">Built With</a></li>

  

</ul>

  

</li>

  

<li>

  

<a  href="#getting-started">Getting Started</a>

  

<ul>

  

<li><a  href="#prerequisites">Prerequisites</a></li>

  

</ul>

  

</li>

  

<li><a  href="#logic-and-usage">Logic and Usage</a></li>

  

</li>

  

<li><a  href="#contact">Contact</a></li>

  

</ol>

  

</details>

  

  

## About The Project

  

  

A simple Quiz Application consisting of 5 questions. A question is presented in front of the user along with four options. On getting the answer correct, the user gains a point.

  

  

<p  align="right">(<a  href="#top">back to top</a>)</p>

  

  

<hr>

  

  

### Built With

  

  

* [Java](https://www.java.com/en/)

  

  

<p  align="right">(<a  href="#top">back to top</a>)</p>

  

  

## Getting Started

  

  

### Prerequisites

  

  

There are no prerequisites for running this program.

  

  

### Running the Program:

  
  
1. Start by cloning the repository.
```
git clone https://github.com/abhijeet007rocks8/Dev-Scripts.git
```

  

2. Navigate to the Quiz Application Java Project.

  

```
Dev-Scripts\JAVA\Quiz Application
```

  

3. Open the `Quiz_Application.java` file in your Java IDE.

  

  

<p  align="right">(<a  href="#top">back to top</a>)</p>

  

  

## Logic and Usage

  

  

<div  align="center">

  

<img  src="https://raw.githubusercontent.com/LiQuiD-404/Dev-Scripts/main/JAVA/Quiz%20Application/snips/snip2.png"  alt="screenshot" >


</div>

The program will give out all the instructions required to play the quiz game. <br>

**Note :** The questions are shuffled every round so you cannot cheat.
Select the correct option to get a point.
**Special Option :** An one time option to flip the current question. 

**Logic :**

1. The program uses a `Collections.shuffle();` Funtion to generate five unique numbers.
2. The questions, answers and options are stored in respective files.
	```
	File ques = new File("ques.txt");  
	File ans = new File("ans.txt");  
	File opt = new File("options.txt");
	```
3. The flip function allows the user to flip the current question for a new question.
4.  The program can accept user's input in either case by the help of the mentioned syntax.
	```
	Character.toString(ch).toUpperCase().equals(answers)
	```
  

  
  
  

<br><br>

  

  

Facing issues running this program? Have a look at the demo video:

  

  


  
  
  

  

<p  align="right">(<a  href="#top">back to top</a>)</p>

  

  

## Contact

  

  

Shubham Singh - [LinkedIn](https://www.linkedin.com/in/shubham-singh-519769220/)

  

  

<p  align="right">(<a  href="#top">back to top</a>)</p>