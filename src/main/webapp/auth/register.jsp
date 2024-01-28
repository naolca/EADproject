<!doctype html>
<html lang="en">

<head>
  <title>E-Journal | Register</title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="w-full h-100vh text-gray-900">
  <div class="relative isolate px-6 pt-14 lg:px-8">
    <div class="absolute inset-x-0 -top-40 -z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80" aria-hidden="true">
      <div
        class="relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]"
        style="
              clip-path: polygon(
                74.1% 44.1%,
                100% 61.6%,
                97.5% 26.9%,
                85.5% 0.1%,
                80.7% 2%,
                72.5% 32.5%,
                60.2% 62.4%,
                52.4% 68.1%,
                47.5% 58.3%,
                45.2% 34.5%,
                27.5% 76.7%,
                0.1% 64.9%,
                17.9% 100%,
                27.6% 76.8%,
                76.1% 97.7%,
                74.1% 44.1%
              );
            "></div>
    </div>
    <main class="w-full h-full lg:flex lg:flex-row">
      <div class="w-full h-full flex flex-col">
        <div class="w-full flex flex-col justify-center items-center">
          <h2 class="text-4xl font-bold text-gray-900">Welcome!</h2>
          <p class="font-bold text-gray-600">Please fill in your information!</p>
        </div>
        <div class="w-full flex flex-col justify-center items-center">
          <form action="/auth/register" method="POST">
            <div class="input-row py-2">
              <label class="block text-gray-700 text-md">First Name </label>
              <input type="text" name="firstName" id="firstName"
                class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg"
                placeholder="e.g. John" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-700 text-md">Last Name</label>
              <input type="text" name="lastName" id="lastName"
                class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg"
                placeholder="e.g. Doe" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-700 text-md">Email Address</label>
              <input type="email" name="email" id="email"
                class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg"
                placeholder="e.g. john.doe@example.com" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-700 text-md">Password</label>
              <input type="password" name="password" id="password"
                class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg" />
            </div>
            <div class="input-row py-2"><label class="block text-gray-700 text-md">Confirm Password</label>
              <input type="password" name="password" id="password"
                class="block w-full border font-bold border-gray-600 rounded-md px-2 py-1 text-lg" />
            </div>
            <button type="submit"
              class="w-full bg-gray-900 px-2 py-1 text-gray-50 rounded-md shadow-md text-2xl font-bold">Register</button>
            <% String error=(String) request.getAttribute("error"); if (error !="" && error !=null) { %>
              <p class="text-red-600 font-bold">
                <%=error%>
              </p>
              <% } %>
          </form>
          <p> Already have an account? <a href="/auth/login" class="underline decoration-sky-500">Log In!</a> </p>
        </div>
        <div
          class="absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]"
          aria-hidden="true">
          <div
            class="relative left-[calc(50%+3rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]"
            style="
              clip-path: polygon(
                74.1% 44.1%,
                100% 61.6%,
                97.5% 26.9%,
                85.5% 0.1%,
                80.7% 2%,
                72.5% 32.5%,
                60.2% 62.4%,
                52.4% 68.1%,
                47.5% 58.3%,
                45.2% 34.5%,
                27.5% 76.7%,
                0.1% 64.9%,
                17.9% 100%,
                27.6% 76.8%,
                76.1% 97.7%,
                74.1% 44.1%
              );
            "></div>
        </div>
      </div>
      <div class="bg-red w-full h-full font-bold">Hello, world</div>
    </main>
</body>

</html>
