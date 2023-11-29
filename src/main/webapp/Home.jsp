<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ToDo Home</title>
    <link rel="icon" type="image/x-icon" href="./favicon.png">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 75vh;
            flex-direction: column;
        }

        h1 {
            color: #2c3e50;
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 2px;
            margin-bottom: 30px;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        
        #delete{
        	background-color: #FD1C03;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin-right: 5px;
            transition: background-color 0.3s ease-in-out;
        }
        
        #delete:hover{
        	 background-color: #990000;
        }
        
        #edit{
        	background-color: #B1FB17;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin-right: 5px;
            transition: background-color 0.3s ease-in-out;
        }
        
        #edit:hover{
        	 background-color: #DAEE01;
        }
        
        #addTask{
        	background-color: #3EA055;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin-right: 5px;
            transition: background-color 0.3s ease-in-out;
        }
        
        #addTask:hover{
        	 background-color: #3A5F0B;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin-right: 5px;
            transition: background-color 0.3s ease-in-out;
        }

        button:hover {
            background-color: #2980b9;
        }

        a {
            text-decoration: none;
        }

        a button {
            background-color: #3498db;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease-in-out;
        }

        a button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h1>ToDo Home</h1>
    <table border="1px">
        <tr>
            <th>Task Name</th>
            <th>Task Description</th>
            <th>Date Created</th>
            <th>Status</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <tr>
            <td>Swimming</td>
            <td>Water</td>
            <td>12/12/2023</td>
            <td>Completed</td>
            <td><button id="delete">Delete</button></td>
            <td><button id="edit">Edit</button></td>
        </tr>
    </table>
    <a href="session-add-task"><button id="addTask">Add File</button></a><br>
    <a href="logout"><button >Logout</button></a>
</body>
</html>
