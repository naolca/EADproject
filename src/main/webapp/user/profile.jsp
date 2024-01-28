<%@ page import="com.project.domain.User" %>

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
  </head>

  <body>
    <jsp:include page="header.jsp" />

    <% User user=(User) session.getAttribute("user"); %>

      <div>
        <div class="flex flex-col justify-between gap-y-18 flex-1 ">
          <form action="<%= request.getContextPath() %>/journal" method="post">
            <div class="border-l-2 border-l-black">
              <input class="flex  p-2 m-2 text-2xl focus:border-none" type="text" name="firstName"
                value="<%= user.firstName %>" placeholder="First Name" />
            </div>

            <div class="border-l-2 border-l-black">
              <input class="flex  p-2 m-2 text-2xl focus:border-none" type="text" name="lastName"
                value="<%= user.lastName %>" placeholder="Last Name" />
            </div>

            <div class="border-l-2 border-l-black">
              <input class="flex  p-2 m-2 text-2xl focus:border-none" type="text" name="email" value="<%= user.email %>"
                placeholder="Email" />
            </div>

            <div class="border-l-2 border-l-black">
              <input class="flex  p-2 m-2 text-2xl focus:border-none" type="password" name="password"
                value="<%= user.password %>" placeholder="Password" />
            </div>

            <div class="flex justify-center gap-x-4 bg-black text-white w-16 text-center p-1">
              <input type="submit" value="Submit">
            </div>
          </form>
        </div>
      </div>

      <jsp:include page="footer.jsp" />
  </body>
