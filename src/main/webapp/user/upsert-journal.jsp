<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
    <div class="flex justify-between  gap-x-4 m-20 w-screen">
        <div class="flex flex-col justify-between gap-y-18 flex-1 p-32">
            <form action="<%= request.getContextPath() %>/journal" method="post">
                <div class="border-l-2 border-l-black">
                    <input
                        class="flex  p-2 m-2 text-2xl focus:border-none"
                        type="text"
                        name="title"
                        placeholder="Enter the title of the Journal"
                    />
                </div>

                <div class="border-l-2 border-l-black h-64 p-2">
                    <textarea
                        class="flex p-2 m-2 text-2xl focus:border-none h-full w-full"
                        name="content"
                        placeholder="Journal content.."></textarea>
                </div>

                <div class="flex justify-center gap-x-4 bg-black text-white w-16 text-center p-1">
                    <input  type="submit" value="Submit">
                </div>
            </form>
        </div>
    </div>
</body>