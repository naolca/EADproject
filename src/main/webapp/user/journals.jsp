<%@ page import="com.project.domain.Journal" %>
  <%@ page import="java.util.List" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
          <% User user=(User) session.getAttribute("user"); %>
            <%@include file="./header.jsp" %>
              <div class="flex flex-col gap-5 justify-between h-screen px-10 py-8">
                <div class="bg-white text-center flex flex-col gap-5">
                  <div class="w-full flex flex-row gap-5 items-center">
                    <h1 class="text-3xl font-bold">Hello, <%=user.firstName + " " + user.lastName%>.</h1>
                  </div>
                  <div class="w-full flex flex-col py-3 text-left">
                    <p class="font-bold text-gray-600 text-xl">These are the journals you have created. Enjoy reading
                      them or create a new one!</p>
                  </div>
                  <div class="w-full flex gap-5">
                    <form action="/journals" method="get" class="flex gap-5 w-full">
                      <input type="text" name="searchKey" id="searchKey"
                        class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
                        placeholder="Search journals..." />
                      <button type="submit"
                        class="rounded-xl bg-gray-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-gray-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-gray-600">Search</button>
                    </form>
                    <a href="/journals/add-journal">
                      <button
                        class="rounded-xl bg-gray-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-gray-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-gray-600 text-nowrap">
                        + New Journal
                      </button>
                    </a>
                  </div>

                  <div class="w-full flex flex-wrap items-center justify-center gap-4">
                    <% List<Journal> journalEntries = (List<Journal>) request.getAttribute("journals");
                        if (journalEntries != null) {
                        for (Journal entry : journalEntries) {
                        %>
                        <a href=<%="/journals/" + entry.id%>
                          class="h-full w-full block p-6 bg-white border border-gray-200 rounded-lg shadow
                          hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700 max-w-[30%]
                          min-w-96 min-h-48">
                          <h5 class="mb-4 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
                            <%= entry.title %>
                          </h5>
                          <p class="font-normal text-gray-700 dark:text-gray-400">
                            <%= entry.content %>
                          </p>
                        </a>
                        <% }} %>
                  </div>
                </div>

              </div>
        </body>

        </html>
