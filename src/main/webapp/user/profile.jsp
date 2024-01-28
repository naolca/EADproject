<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="font-sans">
<%@include file="./header.jsp" %>
<div class="flex justify-center h-screen p-20">
    <div class="bg-white px-20 w-full">
        <h1 class="text-2xl font-bold mb-6">Edit Profile</h1>
        <form action="<%= request.getContextPath() %>/update-profile" method="post">
            <div class="mb-4">
                <label for="name" class="block text-gray-700 text-sm font-bold mb-2">Full Name:</label>
                <input
                        type="text"
                        id="name"
                        name="username"
                        class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:border-blue-500"
                        value="John Doe" required
                />
            </div>

            <div class="mb-4">
                <label for="email" class="block text-gray-700 text-sm font-bold mb-2">Email:</label>
                <input
                        type="email"
                        id="email"
                        name="email"
                        class="w-full border border-gray-300 p-2 rounded focus:outline-none focus:border-blue-500"
                        value="user@example.com" required
                />
            </div>

            <div class="flex justify-center">
                <button
                        class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                        type="submit"
                >
                    Save Changes
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
