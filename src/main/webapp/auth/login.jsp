<!doctype html>
<html lang="en">

<head>
  <title></title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="w-full h-100vh text-gray-900">
  <jsp:include page="../bg.jsp" />
  <main class="w-full h-full lg:flex z-999">
    <div class=" w-full h-full flex flex-col">
      <div class="w-full flex flex-col justify-center items-center">
        <h2 class="text-4xl font-bold text-gray-900">Welcome back!</h2>
        <p class="font-bold text-gray-600">Please log in!</p>
      </div>
      <div class="w-full flex flex-col justify-center items-center">
        <form action="/auth/login" method="POST" class="w-full">
          <div class="input-row py-2 w-full">
            <label class="block text-gray-600 text-md">Email Address</label>
            <input type="email" name="email" id="email"
              class="w-full font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none"
              placeholder="e.g. john.doe@example.com" />
          </div>
          <div class="input-row py-2 w-full">
            <label class="block text-gray-700 text-md">Password</label>
            <input type="password" name="password" id="password"
              class="w-full  font-bold rounded-xl px-3 py-2 text-lg relative rounded-full px-3 py-1 text-sm leading-6 text-gray-600 ring-1 ring-gray-900/20 hover:ring-gray-900/30 focus:ring-gray-900/40 outline-none" />
          </div>
          <button type="submit"
            class="rounded-xl bg-indigo-600 px-5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Log
            In</button>
          <% String error=(String) request.getAttribute("error"); if (error !="" && error !=null) { %>
            <p class="text-red-600 font-bold">
              <%=error%>
            </p>
            <% } %>
        </form>
        <p> Don't have an account? <a href="/auth/register"
            class="underline decoration-indigo-700 text-indigo-600">Register!</a> </p>
      </div>
    </div>
  </main>
</body>

</html>
