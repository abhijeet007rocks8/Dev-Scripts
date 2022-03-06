name: Create an issue
description: Create an issue to start working on your script
title: "[Project title here] "
body:
  - type: markdown
    attributes:
      value: |
        Create an issue to start working on your project

  - type: checkboxes #prerequisites
      attributes:
        label: Prerequisites
        description: Please answer the following questions for yourself before submitting an issue. 
        options:
        - label: I am a GSSoC-22 Participant
        - label: I checked to make sure that this issue has not already been filed
          required: true
 
   - type: textarea #description
       attributes:
         label: Description
         description: Please describe the project you will be working on
         placeholder: Describe here!
       validations:
         required: true
 
   - type: checkboxes #techstack
       attributes:
         label: Tech Stack
         description: Select tech stack you would be working on
         options:
         - label: C++
         - label: Go
         - label: Java
         - label: NodeJS
         - label: Python
         - label: React
         - label: Web Development
           required: true
