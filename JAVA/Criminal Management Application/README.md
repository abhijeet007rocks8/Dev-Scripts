<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/Images/BannerNew.png" />

## Abstract
<p>
  Criminal record generally contains personal information about particular person
along with photograph. To identify any Criminal we need some identification
regarding person. We are developing this software to make this process easier
than the traditional storage systems. In the modern era when everything is
computerized, a Criminal Management system is very much in need so as to store
data of dangerous criminals. 
</p>

## Introduction
### Purpose of this project
<p>
  The main purpose of our project is automating the traditional way of storing criminal records.
Here, we could add, update and delete criminal records. We could also add, update and delete
FIR details which are being filed down manually traditionally. We store all the data into a
database from where we could use it further. Thus this project provides a very user friendly
interface for the officials to store and manage the criminal records. 
</p>

### Project Objective
<p>
  This project intends to provide an effective way for storing, retrieving and managing criminal
records. It also aims at providing a user friendly interface for effortless interaction with the
user. 
</p>

### Project Scope
<p>
  This project is confined to storing, retrieving and managing criminal records. In further
developments of the project, we could integrate it with AI and make features such as face
detections.
</p>

## UML Diagram
For UML Digram Click -> <a href="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/UML%20Diagram/UML.pdf">UML Diagram</a>

## ER Diagram
For ER Diagram Click -> <a href="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/ER%20Diagram/ER%20Diagram%20-%20Criminal%20Management%20System.png">ER Diagram</a>

## Technology Used
### IDE:
- ![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)
- ![VS Code](https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)
- ![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

### Language:
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

### Frame-Work:
- ![Gradle](https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)


### Database:
- ![Database](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

## Run Locally

Clone the project

```bash
  git clone https://github.com/Kumar-laxmi/Criminal-Management-System
```

Go to the project directory

```bash
  cd Criminal-Management-System/src/CriminalManagementSystem
```

Run the application

```bash
  javac LogIn.java
```

## Demo Video
For Demo Video click the link below
<a href="https://amritacampuschennai-my.sharepoint.com/:v:/g/personal/ch_en_u4cse20039_ch_students_amrita_edu/EZ4vFeSb3z9GgJun-3uPMO4Bj3CWXp8YJhfYP-EjYOE1eA">Click Here</a>

## Output Screen-Shots:
When the application is executed then LogIn Screen pops-up prompting for authentication
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/LogIn.png" />

There are two options to Log In <br/> Either as an Admin or as an Operator
If we choose Administrator Radio-Button and give:
Username:

    admin

Password: 
   
    admin123

This will lead to Administrator Page
And the Page would look like this 
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/Admin1.png" />
###  NOTE: On clicking Home button you will be redirected to default admin page above

An admin has full authority to make changes in FIR and Criminal Record as well as Operator Record
- An Admin can Add, View, Delete and Update Operator record as well as FIR & Criminal Record.
- There is only one admin and multiple operators can exist.

To add new Operator, Click **Add Operator**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/OperatorAdd.png" />

To update existing Operator, Click **Update Operator**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/OperatorUpdate.png" />

To view existing Operator, Click **View Operator**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/OperatorView.png" />

To delete existing Operator, Click **Delete Operator**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/OperatorDelete.png" />

To Enter/Register a new FIR, click **Register FIR**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/RegisterFIR.png" />

To view/retreive a FIR, click **Retrieve FIR**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/ViewFIR.png" />

To update existing FIR, click **Update FIR**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/UpdateFIR.png" />

To delete exisiting FIR, click **Delete FIR**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/DeleteFIR.png" />

#### ==> If Admin wants to access only the Criminal Data instead of the FIR Data, that is also possible

To View/Retrieve Criminal Data, click **Retrieve Criminal**
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/RetrieveCriminal.png" />

To Update existing Criminal Data, click **Update Criminal**
#### NOTE: Any change in Criminal Data also effects FIR Details pertaining to the Criminal
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/UpdateCriminal.png" />

To Delete existing Criminal Data, click **Delete Criminal**
#### NOTE: Any change in Criminal Data also effects FIR Details pertaining to the Criminal
##### CAUTION: This action will cause deletion of FIR pertaining to that particular Criminal
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/DeleteCriminal.png" />

### If we Login into the application as an Operator then the UI would appear like this:
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/OperatorPage.png" />

As an Operator, we can retrieve/view a FIR Information:
<img src="https://github.com/Kumar-laxmi/Criminal-Management-System/blob/main/SCREEN-SHOTS/RetrieveFIR_OPERATORPAGE.png" />



