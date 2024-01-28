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
        <main>
          <div>
            <input type="email" name="email" id="email"
              class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
              placeholder="e.g. Search users by First Name, Last Name or Email..." />
            <button type="submit"
              class="rounded-xl bg-indigo-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Search</button>
          </div>
          <div>
            <% List<User> userList = (List<User>) request.getAttribute("userList");
                if (userList != null && !userList.isEmpty()) {
                %>
                <table>
                  <thead>
                    <tr>
                      <th scope="col">Name</th>
                      <th scope="col">Email</th>
                      <th scope="col">Role</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% for (User user : userList) { %>
                      <tr>
                        <th scope="row">
                          <%= user.firstName + " " + user.lastName %>
                        </th>
                        <td>
                          <%= user.email %>
                        </td>
                        <td>user.role</td>
                      </tr>
                      <% } %>
                  </tbody>
                </table>
                <% } else { %>
                  <p>No users available.</p>
                  <% } %>
          </div>
        </main>
      </body>

      </html>
