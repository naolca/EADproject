<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Journal Detail</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="font-sans">
<div class="flex justify-center h-screen p-20">
    <div class="bg-white px-20 w-full">
        <h1 class="text-2xl font-bold mb-6">Journal Detail</h1>
        <div class="p-6 bg-white border border-gray-200 rounded-lg shadow">
            <h2 class="mb-2 text-2xl font-bold tracking-tight text-gray-900">Noteworthy technology acquisitions 2021</h2>
            <p class="font-normal text-gray-700">Here are the details of the selected journal entry. You can display the content, date, or any other relevant information here.</p>
            <p class="font-medium text-gray-800 mt-4 text-lg">Date Created: January 24, 2024</p>

            <!-- Add more details as needed -->

            <!-- Edit and Delete buttons -->
            <div class="mt-4 flex gap-4">
                <a href="<%= request.getContextPath() %>/edit-journal?id=1" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Edit</a>
                <a href="<%= request.getContextPath() %>/delete-journal?id=1" class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-700">Delete</a>
            </div>
        </div>
        <div class="mt-4">
            <a href="<%= request.getContextPath() %>/user/journals.jsp" class="text-blue-500 hover:underline">Back to Journal Listing</a>
        </div>
    </div>
</div>
</body>
</html>
