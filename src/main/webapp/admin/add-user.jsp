<% String sidebarData="add-admin" ; request.setAttribute("sidebarData", sidebarData); %>
  <!doctype html>
  <html lang="en">

  <head>
    <title>E-Journal | Register</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>

  <body class="w-full h-screen text-gray-900">
    <main class="w-full h-screen flex z-999">
      <div class="block h-full top-0 left-0 z-40 w-1/5">
        <jsp:include page="./components/sidebar.jsp" />
      </div>
      <div class="w-4/5 gap-5 p-5">
        <div class="w-full flex flex-col justify-center items-center">
          <p class="font-bold text-gray-600">Please fill in the information of the new user!</p>
        </div>
        <div class="w-full flex flex-col justify-center items-center">
          <form action="/admin/add-user" method="POST" class="w-full">
            <div class="input-row py-2">
              <label class="block text-gray-600 text-md">First Name </label>
              <input type="text" name="firstName" id="firstName"
                class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
                placeholder="e.g. John" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-600 text-md">Last Name</label>
              <input type="text" name="lastName" id="lastName"
                class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
                placeholder="e.g. Doe" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-600 text-md">Email Address</label>
              <input type="email" name="email" id="email"
                class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
                placeholder="e.g. john.doe@example.com" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-600 text-md">Password</label>
              <input type="password" name="password" id="password"
                class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-600 text-md">Confirm Password</label>
              <input type="password" name="password" id="password"
                class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none" />
            </div>
            <button type="submit"
              class="rounded-xl bg-indigo-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Register
              User</button>
            <% String error=(String) request.getAttribute("error"); if (error !="" && error !=null) { %>
              <p class="text-red-600 font-bold">
                <%=error%>
              </p>
              <% } %>
          </form>
        </div>
      </div>
    </main>
  </body>

  </html>