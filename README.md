# Network Management

## Problem 1

In this exercise we will direct our attention towards a (fictous) Internet connection provider. The first priority of the company is to build an infrastructure that will allow the company to provide internet connection to every domestic and business location in the area.

Write a program that uses the data in the table below, and finds the cheapest way of connecting all locations. The output of the program shall be the connections that are needed specified with their endpoints in brackets (e.g. [A B]), and the total cost of the connections.

![image](https://user-images.githubusercontent.com/79321698/165085009-2467636a-1bcd-4d52-ba49-95833a41ac76.png)

The table shows the cost of establishing a connection between pairs of locations. Locations can be connect to themselves at no cost. The lower half of the table is ommitted, because the cost of a connection is the same in both directions.

## Problem 2: Routing tables

One of the reason for the success of the TCP/IP internet, is the robustness of the routing algorithm. The routing algorithm used in IP, is usually a variant of Dijkstra's Algorithm. The routing algorithm described below is a gross simplification of the real protocol:

- Each node on the network runs Dijktra's algorithm once, to find the fastest route from that node to all the other nodes.
- Then the nodes exchange routing tables with their neighbours.
- If a node finds that routing packets through the neigbour is faster than the best route the node has found, it will update its routing table using data from the neighbors routing table

The following data may be useful for testing (it's the same graph as the table in the distance table above. The format is one edge per line. Each line contains the name of the two endpoints, and the cost.

| START | END | COST |
|:-----:|:---:|:----:|
|   A   |  B  |  10  |
|   A   |  C  |  5   |
|   A   |  E  |  3   |
|   A   |  F  |  12  |
|   B   |  C  |  17  |
|   B   |  D  |  9   |
|   B   |  E  |  17  |
|   B   |  F  |  12  |
|   C   |  D  |  35  |
|   C   |  E  |  3   |
|   C   |  F  |  12  |
|   D   |  F  |  12  |
|   E   |  F  |  12  |

## Hand in
The link to the Github repository with the source code, the specified output from the programs, and a short note explaining why you made choices you did. Specified output from the programs and the note must be delivered in particular Canvas assignment.
