# ConcurrencyConundrum
CO3408 Advanced Software Modelling Assignment

Scenario 1
--
![Scenario1](https://user-images.githubusercontent.com/62650544/217455155-c8d394c7-bfc8-4d77-a195-d0561bf642cf.jpg)

Scenario 2
--
![Scenario2](https://user-images.githubusercontent.com/62650544/217455258-eb3b2691-5f98-43b5-a4c9-9d1419ac7c7b.jpg)

Scenario 3
--
![Scenario3](https://user-images.githubusercontent.com/62650544/217455301-a66bc319-bb11-4cc9-8566-f5162d5fcbda.jpg)

Scenario 4
--
![Scenario4](https://user-images.githubusercontent.com/62650544/217455375-d62c94ba-49a3-43e8-802b-abcdb63848fb.jpg)

Scenario 5
--
![Scenario5](https://user-images.githubusercontent.com/62650544/218004427-331b158a-102b-4836-a2cf-4cc91a8842f3.jpg)

Example Output for Scenario 5
--
```
Enter Scenario Number: > 5

Machine will run for 60s.
-----------------------------------------------------

/////////////////////////////////////////////////////
*** Machine Started ***
/////////////////////////////////////////////////////

::: Hopper 1 DEPOSITING :: Remaining [20]
::: Hopper 3 DEPOSITING :: Remaining [30]
::: Hopper 2 DEPOSITING :: Remaining [10]
Presents on Belt 1 :: 1
Presents on Belt 4 :: 1
Presents on Belt 2 :: 1
Turntable A Requesting Present...
Turntable B Requesting Present...
::: Hopper 2 DEPOSITING :: Remaining [9]
::: Hopper 3 DEPOSITING :: Remaining [29]
::: Hopper 1 DEPOSITING :: Remaining [19]
Presents on Belt 4 :: 1
Presents on Belt 2 :: 2
Presents on Belt 1 :: 1
-----------------------------------------
--------  BELT_2_LOCK :: LOCKED  --------
-----------------------------------------
::: Hopper 1 DEPOSITING :: Remaining [18]
Presents on Belt 1 :: 2
::: Hopper 3 DEPOSITING :: Remaining [28]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
-----------------------------------------
--------  BELT_1_LOCK :: LOCKED  --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
--> Table A Adding to Belt 3
Presents on Belt 3 :: 1
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [27]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
Turntable A Requesting Present...
-----------------------------------------
-------- BELT_2_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 2 DEPOSITING :: Remaining [8]
Presents on Belt 2 :: 2
-----------------------------------------
--------  BELT_2_LOCK :: LOCKED  --------
-----------------------------------------
--> Table B Adding to Belt 5
--> Table A Adding to Belt 3
Presents on Belt 5 :: 1
Presents on Belt 3 :: 2
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable A Requesting Present...
-----------------------------------------
-------- BELT_2_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [26]
Presents on Belt 4 :: 2
::: Hopper 2 DEPOSITING :: Remaining [7]
Presents on Belt 2 :: 2
-----------------------------------------
--------  BELT_2_LOCK :: LOCKED  --------
-----------------------------------------
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table A Adding to Belt 3
Presents on Belt 3 :: 3
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable A Requesting Present...
-----------------------------------------
-------- BELT_2_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 2 DEPOSITING :: Remaining [6]
Presents on Belt 2 :: 2
-----------------------------------------
--------  BELT_2_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [25]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table A Adding to Belt 3
Presents on Belt 3 :: 4
-----------------------------------------
--------  BELT_3_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [24]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------

=========================================================================================================
Interim Report @ 10s:
45 presents remaining in hoppers;
3 presents sorted into sacks.
=========================================================================================================

--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [23]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [22]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [21]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [20]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------

=========================================================================================================
Interim Report @ 20s:
41 presents remaining in hoppers;
7 presents sorted into sacks.
=========================================================================================================

--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [19]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [18]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [17]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [16]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------

=========================================================================================================
Interim Report @ 30s:
37 presents remaining in hoppers;
11 presents sorted into sacks.
=========================================================================================================

--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [15]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [14]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [13]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [12]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])

=========================================================================================================
Interim Report @ 40s:
33 presents remaining in hoppers;
16 presents sorted into sacks.
=========================================================================================================

Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [11]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [10]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [9]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [8]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [7]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------

=========================================================================================================
Interim Report @ 50s:
28 presents remaining in hoppers;
20 presents sorted into sacks.
=========================================================================================================

--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [6]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [5]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [4]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
::: Hopper 3 DEPOSITING :: Remaining [3]
Presents on Belt 4 :: 2
-----------------------------------------
--------  BELT_4_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])

=========================================================================================================
Interim Report @ 60s:
24 presents remaining in hoppers;
25 presents sorted into sacks.
=========================================================================================================

/////////////////////////////////////////////////////
*** Input Stopped after 60s. ***
/////////////////////////////////////////////////////
### Hopper 1 STOPPED :: [Present Remaining :: 17] ###
### Hopper 2 STOPPED :: [Present Remaining :: 5] ###
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
### Hopper 3 STOPPED :: [Present Remaining :: 2] ###

=========================================================================================================
 MACHINE CLEANUP RUNNING :: Tables will shutdown after
=========================================================================================================

Turntable B Requesting Present...
-----------------------------------------
-------- BELT_4_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_3_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable A Requesting Present...
-----------------------------------------
-------- BELT_1_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding [0-3] Present to Sack 1 (Age Range: [0-3])
--> Table A Adding to Belt 3
Presents on Belt 3 :: 4
-----------------------------------------
--------  BELT_3_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_3_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable A Requesting Present...
-----------------------------------------
-------- BELT_2_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
--> Table A Adding to Belt 3
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
Presents on Belt 3 :: 4
-----------------------------------------
--------  BELT_3_LOCK :: LOCKED  --------
-----------------------------------------
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_3_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable A Requesting Present...
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table A Adding to Belt 3
Presents on Belt 3 :: 4
-----------------------------------------
--------  BELT_3_LOCK :: LOCKED  --------
-----------------------------------------
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_3_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable A Requesting Present...
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table A Adding to Belt 3
Presents on Belt 3 :: 4
-----------------------------------------
--------  BELT_3_LOCK :: LOCKED  --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
-----------------------------------------
-------- BELT_3_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [17-21] Present to Sack 4 (Age Range: [17-21])
--> Table C Adding [4-6] Present to Sack 2 (Age Range: [4-6])
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable B Requesting Present...
--> Table B Adding to Belt 5
Presents on Belt 5 :: 1
-----------------------------------------
--------  BELT_5_LOCK :: LOCKED  --------
-----------------------------------------
--> Table D Adding [17-21] Present to Sack 4 (Age Range: [17-21])
--> Table C Adding to Belt 6
Presents on Belt 6 :: 1
-----------------------------------------
--------  BELT_6_LOCK :: LOCKED  --------
-----------------------------------------
Turntable D Requesting Present...
-----------------------------------------
-------- BELT_6_LOCK :: UNLOCKED --------
-----------------------------------------
Turntable C Requesting Present...
-----------------------------------------
-------- BELT_5_LOCK :: UNLOCKED --------
-----------------------------------------
--> Table D Adding [11-16] Present to Sack 5 (Age Range: [11-16])
--> Table C Adding [7-10] Present to Sack 3 (Age Range: [7-10])
### Turntable A STOPPED :: [Present Remaining :: 0] ###
### Turntable B STOPPED :: [Present Remaining :: 0] ###
### Turntable D STOPPED :: [Present Remaining :: 0] ###
### Turntable C STOPPED :: [Present Remaining :: 0] ###

/////////////////////////////////////////////////////
*** Machine completed shutdown after 88s. ***
/////////////////////////////////////////////////////

FINAL REPORT
-----------------------------------------

Configuration: scenario5.txt
Total Run Time: 88s.
Hopper 1 deposited 3 presents and waited 0s.
Hopper 2 deposited 5 presents and waited 0s.
Hopper 3 deposited 28 presents and waited 0s.
Sack 1(Age Range: [0-3]) is 8/20 Filled with Presents
0-3
0-3
0-3
0-3
0-3
0-3
0-3
0-3
Sack 2(Age Range: [4-6]) is 8/20 Filled with Presents
4-6
4-6
4-6
4-6
4-6
4-6
4-6
4-6
Sack 3(Age Range: [7-10]) is 8/30 Filled with Presents
7-10
7-10
7-10
7-10
7-10
7-10
7-10
7-10
Sack 4(Age Range: [17-21]) is 2/15 Filled with Presents
17-21
17-21
Sack 5(Age Range: [11-16]) is 10/20 Filled with Presents
11-16
11-16
11-16
11-16
11-16
11-16
11-16
11-16
11-16
11-16
Table A has 0 Presents on it
Table B has 0 Presents on it
Table C has 0 Presents on it
Table D has 0 Presents on it
Belt 1 has 0 Presents on it
Belt 2 has 0 Presents on it
Belt 3 has 0 Presents on it
Belt 4 has 0 Presents on it
Belt 5 has 0 Presents on it
Belt 6 has 0 Presents on it
Orphaned Presents: 0


Out of 36 gifts deposited, 0 are still on the machine, and 36 made it into the sacks
0 gifts went missing.

Process finished with exit code 0
```
