<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
  <div class="flex flex-col w-full justify-between h-screen bg-blue-50">
    <jsp:include page="header.jsp" />
    <div class="flex justify-between min-h-screen items-center  min-w-screen mx-16  gap-x-4">
      <div class="flex flex-col justify-between gap-y-18 flex-1 ">
        <form class="" action="/journals/add-journal" method="post">
          <div class="border-l-2 border-l-black">
            <input class="flex  p-2 m-2 text-2xl focus:border-none" type="text" name="title"
              placeholder="Enter the title of the Journal" />
          </div>

          <div class="border-l-2 border-l-black h-64 p-2">
            <textarea class="flex p-2 m-2 text-2xl focus:border-none h-full w-full" name="content"
              placeholder="Journal content.."></textarea>
          </div>

          <div class="flex justify-end gap-x-4 bg-black text-white w-16 text-center p-1 m-2">
            <input type="submit" value="Submit">
          </div>
        </form>
      </div>
    </div>
    <jsp:include page="footer.jsp" />
  </div>
</body>
