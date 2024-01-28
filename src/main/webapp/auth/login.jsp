<!doctype html>
<html lang="en">

<head>
  <title></title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="w-full h-100vh text-gray-900">
  <main class="w-full h-full lg:flex lg:flex-row">
    <div class="bg-white w-full h-full flex flex-col">
      <div class="w-full flex flex-col justify-center items-center">
        <h2 class="text-4xl font-bold text-gray-900">Welcome back!</h2>
        <p class="font-bold text-gray-600">Please log in!</p>
      </div>
      <div class="w-full flex flex-col justify-center items-center">
        <form action="/auth/login" method="POST">
          <div class="input-row py-2"><label class="block text-gray-700 text-md">Email Address</label>
            <input type="email" name="email" id="email"
              class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg"
              placeholder="e.g. john.doe@example.com" />
          </div>
          <div class="input-row py-2"><label class="block text-gray-700 text-md">Password</label>
            <input type="password" name="password" id="password"
              class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg" />
          </div>
          <button type="submit"
            class="w-full bg-gray-900 px-2 py-1 text-gray-50 rounded-md shadow-md text-2xl font-bold">Log In</button>
          <% String error=(String) request.getAttribute("error"); if (error !="" && error !=null) { %>
            <p class="text-red-600 font-bold">
              <%=error%>
            </p>
            <% } %>
        </form>
        <p> Don't have an account? <a href="/auth/register" class="underline decoration-sky-500">Register!</a> </p>
      </div>
    </div>
    <div class="bg-red w-full h-full font-bold">Hello, world</div>
  </main>
</body>

</html>
