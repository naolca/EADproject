<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <title>E-Journal</title>
  </head>

  <body class="font-sans bg-white text-white">

    <!-- Navigation -->
    <nav class="bg-gray-900 p-4 shadow-md">
      <div class="container mx-auto flex justify-between items-center">
        <a href="#" class="text-white text-2xl font-bold">E-Journal</a>
        <a href="/auth/login" class="text-white font-semibold ">Sign Up</a>
      </div>
    </nav>

    <!-- Hero Section -->
    <header class="bg-white text-white text-center py-20">
      <div class="container mx-auto">
        <h1 class="text-5xl font-extrabold mb-4 text-gray-900">Welcome to E-Journal</h1>
        <p class="text-lg text-gray-700">Capture your thoughts, ideas, and memories with our intuitive journaling
          platform.</p>
        <div class="mt-8">
          <a href="/auth/login"
            class="bg-white text-black px-6 py-3 rounded-full font-semibold hover:bg-gray-300 shadow-md">Get Started</a>
        </div>
      </div>
    </header>

    <!-- Features Section -->
    <section class="container mx-auto py-16">
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
        <div class="bg-gray-900 p-6 rounded-lg shadow-lg">
          <h2 class="text-xl font-semibold mb-4 text-white">Simple and Intuitive</h2>
          <p class="text-gray-100">Start writing your thoughts instantly with our user-friendly interface.</p>
        </div>
        <div class="bg-gray-900 p-6 rounded-lg shadow-lg">
          <h2 class="text-xl font-semibold mb-4 text-white">Secure and Private</h2>
          <p class="text-gray-100">Your journal entries are kept private and secure. Your data is important to us.</p>
        </div>
        <div class="bg-gray-900 p-6 rounded-lg shadow-lg">
          <h2 class="text-xl font-semibold mb-4 text-white">Access Anywhere</h2>
          <p class="text-gray-100">Access your journals from any device, anywhere in the world.</p>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="bg-white text-white py-16">
      <div class="container mx-auto text-center">
        <h2 class="text-3xl font-extrabold mb-4 text-gray-900">Ready to start journaling?</h2>
        <p class="text-lg mb-8 text-gray-600">Join thousands of users who have discovered the joy of journaling with us.
        </p>
        <a href="/auth/login"
          class="bg-white text-gray-800 px-8 py-3 rounded-full font-semibold hover:bg-gray-300 shadow-md shadow-red-500">Sign
          Up Now</a>
      </div>
    </section>

    <!-- Footer -->
    <footer class="bg-transparent text-white py-8">
      <div class="container mx-auto text-center">
        <p>&copy; 2024 E-Journal. All rights reserved.</p>
      </div>
    </footer>

  </body>

  </html>
