<%@ page import="com.project.domain.Journal" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.project.domain.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Journal Listing</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="font-sans overflow-x-clip">


    <% User user=(User) session.getAttribute("user");
      
         %>
<%@include file="./header.jsp" %>
<div class="flex flex-col justify-between h-screen px-20 py-8">
    <div class="bg-white text-center">
        <h1 class="text-3xl font-bold mb-10">Journals</h1>
        <a href="user/upsert-journal.jsp" onclick="">
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                + Create New Journal
              </button>
        </a>
        <div class="flex pb-10 flex-wrap items-center justify-center gap-4">
            <%
                List<Journal> journalEntries = (List<Journal>) request.getAttribute("journals");
                if (journalEntries != null) {
                    for (Journal entry : journalEntries) {
            %>
            <a href="/eadproject_war_exploded/user/journal-detail.jsp" class="h-full w-full block p-6 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 max-w-[30%] min-w-96 min-h-48">
                <h5 class="mb-4 text-2xl font-bold tracking-tight text-gray-900 dark:text-white"><%= entry.title %></h5>
                <p class="font-normal text-gray-700 dark:text-gray-400"><%= entry.content %></p>
            </a>
            <%
                    }
                }
            %>
        </div>
    </div>
  
</div>
</body>
</html>
