# Sentiment-Analysis

## Description
In this project, we analyse the reviews of a women's clothing company. The data has been extracted from a CSV file. 

## Tech stack:
Python

## Packages Used:
1. pandas
2. numpy 
3. seaborn
4. nltk
5. wordcloud
among others.

## Working of Project:
#### 1. Extracting Data
I extracted the data from a CSV file that contained the reviews along with some other order details using pandas. This data got stored in the form of a DataFrame.

#### 2. Data Visualization
In this step, I used the package seaborn to plot the ratings and polarity ratings on graphs. It also included data preprocessing.

#### Screenshots:
![Data Visualization](https://github.com/deepeshaburse/Dev-Scripts/blob/main/Python/Machine%20Learning/Sentiment%20Analysis/Assets/Screenshot%201.png)

![Data Visualization](https://github.com/deepeshaburse/Dev-Scripts/blob/main/Python/Machine%20Learning/Sentiment%20Analysis/Assets/Screenshot%202.png)

![Data Visualization](https://github.com/deepeshaburse/Dev-Scripts/blob/main/Python/Machine%20Learning/Sentiment%20Analysis/Assets/Screenshot%203.png)

#### 3. Data Cleaning
This stage included:
  - Dropping unnecessary columns
  - Dropping rows containing missing values (NaN values)
  - Tokenization — convert sentences to words
  - Removing unnecessary punctuation, tags
  - Lowering text
  - Removing stop words — frequent words such as "the", "is", etc. that do not have specific semantic
  - Stemming — words are reduced to a root by removing inflection through dropping unnecessary characters, usually a suffix.
  - Lemmatization — Another approach to remove inflection by determining the part of speech and utilizing detailed database of the language.
  - Bag of Words
  - TF-IDF

#### 4. Sentiment Analysis
Taking this cleaned data, we will perform Sentiment Analysis using the Sentiment Intensity Analyzer. Then, we can extract the pos, neg, neu, compound values. Following this, I applied the doc2vec and TFIDF Vectorizer and added features such as number of words and number of characters. I, later made a wordcloud of the top words found in the reviews and listed down the top positive and negative reviews.
