<%@ page import="com.project.domain.Journal" %>
<%@ page import="com.project.services.JournalService" %>
<%@ page import="com.project.persistence.repositories.JournalRepository" %>
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
<%@include file="./header.jsp" %>

<% Journal journal = (Journal) request.getAttribute("journal"); %>
<div class="flex justify-center h-screen p-20">
    <div class="bg-white px-20 w-full">
        <h1 class="text-2xl font-bold mb-6">Journal Detail</h1>
        <div class="p-6 bg-white border border-gray-200 rounded-lg shadow">
            <h2 class="mb-2 text-2xl font-bold tracking-tight text-gray-900"><%= journal.title %></h2>
            <p class="font-normal text-gray-700"><%= journal.content %></p>
            <p class="font-medium text-gray-800 mt-4 text-lg">Date Created: January 24, 2024</p>

            <div class="mt-4 flex gap-4">
                <a href="<%= request.getContextPath() %>/edit-journal?id=<%=journal.id%>" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Edit</a>
<%--                we will send a delete request--%>
                <a href="" onclick(event)=>{event.preventDefault(); deleteJournal(<%= journal.id %>)}
                 %>" class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-700">Delete</a>
            </div>
        </div>
        <div class="mt-4">
            <a href="<%= request.getContextPath() %>/user/journals.jsp" class="text-blue-500 hover:underline">Back to Journals</a>
        </div>
    </div>
</div>
</body>
<script>
    function deleteJournal(id) {
        if (!confirm("Are you sure you want to delete this journal?")) {
            return;
        }
        fetch(`/journal?id=${id}`, {
            method: 'DELETE'
        }).then(res => {
            console.log(res);
        })
    }
</script>
</html>
