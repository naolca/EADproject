<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
  <title>E-Journal</title>
</head>
<body class="font-sans bg-black text-white">

<!-- Navigation -->
<nav class="bg-white p-4 shadow-md">
  <div class="container mx-auto flex justify-between items-center">
    <a href="#" class="text-black text-2xl font-bold">E-Journal</a>
    <a href="/auth/login" class="text-black font-semibold ">Sign Up</a>
  </div>
</nav>

<!-- Hero Section -->
<header class="bg-black text-white text-center py-20 shadow-lg">
  <div class="container mx-auto">
    <h1 class="text-5xl font-extrabold mb-4">Welcome to E-Journal</h1>
    <p class="text-lg">Capture your thoughts, ideas, and memories with our intuitive journaling platform.</p>
    <div class="mt-8">
      <a href="/auth/login" class="bg-white text-black px-6 py-3 rounded-full font-semibold hover:bg-gray-300 shadow-md">Get Started</a>
    </div>
  </div>
</header>

<!-- Features Section -->
<section class="container mx-auto py-16">
  <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
    <div class="bg-white p-6 rounded-lg shadow-md">
      <h2 class="text-xl font-semibold mb-4 text-black">Simple and Intuitive</h2>
      <p class="text-black">Start writing your thoughts instantly with our user-friendly interface.</p>
    </div>
    <div class="bg-white p-6 rounded-lg shadow-md">
      <h2 class="text-xl font-semibold mb-4 text-black">Secure and Private</h2>
      <p class="text-black">Your journal entries are kept private and secure. Your data is important to us.</p>
    </div>
    <div class="bg-white p-6 rounded-lg shadow-md">
      <h2 class="text-xl font-semibold mb-4 text-black">Access Anywhere</h2>
      <p class="text-black">Access your journals from any device, anywhere in the world.</p>
    </div>
  </div>
</section>

<!-- CTA Section -->
<section class="bg-black text-white py-16">
  <div class="container mx-auto text-center">
    <h2 class="text-3xl font-extrabold mb-4">Ready to start journaling?</h2>
    <p class="text-lg mb-8">Join thousands of users who have discovered the joy of journaling with us.</p>
    <a href="/auth/login" class="bg-white text-black px-8 py-3 rounded-full font-semibold hover:bg-gray-300 shadow-md shadow-red-500">Sign Up Now</a>
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
