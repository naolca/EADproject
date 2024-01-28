<%@ page import="java.util.List" %>
  <%@ page import="com.project.domain.User" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

      <!doctype html>
      <html lang="en">

      <head>
        <title></title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <script src="https://cdn.tailwindcss.com"></script>
      </head>

      <body>
        <main class="w-full h-screen flex z-999">
          <div class="block h-full top-0 left-0 z-40 w-1/5">
            <jsp:include page="./components/sidebar.jsp" />
          </div>
          <div class="w-4/5 gap-5 p-5 flex flex-col">
            <jsp:include page="./components/header.jsp" />
            <div class="w-full">
              <form action="/admin/admins" method="get" class="w-full flex gap-5">
                <input type="text" name="searchKey" id="searchKey"
                  class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
                  placeholder="Search users by First Name, Last Name or Email..." />
                <button type="submit"
                  class="rounded-xl bg-indigo-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Search</button>
              </form>
            </div>

            <div class="rounded-xl">
              <% List<User> userList = (List<User>) request.getAttribute("userList");
                  if (userList != null && !userList.isEmpty()) { %>
                  <table class="w-full border-collapse border border-gray-300/50 rounded-xl table-fixed">
                    <thead>
                      <tr class="bg-gray-200">
                        <th scope="col" class="border border-gray-300/50 p-2 text-left">Name</th>
                        <th scope="col" class="border border-gray-300/50 p-2 text-left">Email</th>
                        <th scope="col" class="border border-gray-300/50 p-2 text-left">Role</th>
                        <th scope="col" class="border border-gray-300/50 p-2 text-left">Status</th>
                      </tr>
                    </thead>
                    <tbody>
                      <% for (User user : userList) { %>
                        <tr class="border border-gray-300">
                          <td class="border border-gray-300 p-2">
                            <%= user.firstName + " " + user.lastName %>
                          </td>
                          <td class="border border-gray-300 p-2">
                            <%= user.email %>
                          </td>
                          <td class="border border-gray-300 p-2">
                            <%= user.role.equals("NORMAL_USER") ? "User" : "Admin" %>
                          </td>
                          <td class="border border-gray-300 p-2">
                            <form action=<%="/admin/delete-user/" + user.id %> method="post">
                              <button>Delete</button>
                            </form>
                          </td>
                          </td>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
                  <% } else { %>
                    <p>No users available.</p>
                    <% } %>
            </div>

            <div class="text-right">
              <a href="/admin/add-admin"
                class="rounded-xl bg-indigo-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Add
                new Admin</a>
            </div>
          </div>
        </main>
      </body>

      </html>
