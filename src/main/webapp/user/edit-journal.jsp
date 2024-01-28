<%@ page import="com.project.domain.Journal" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
<%@include file="./header.jsp" %>

<% Journal journal = (Journal) request.getAttribute("journal"); %>
<div class="flex flex-col w-full justify-between h-screen">
    <jsp:include page="header.jsp" />
    <div class="flex justify-between  gap-x-4">
        <div class="flex flex-col justify-between gap-y-18 flex-1 ">
            <h1>Edit your journal</h1>
            <form onsubmit()=>{editJournal(<%= journal.id %>)}
                <div class="border-l-2 border-l-black">
                    <input
                            class="flex  p-2 m-2 text-2xl focus:border-none"
                            type="text"
                            name="title"
                            placeholder="Enter the title of the Journal"
                            defaultValue=""
                    />
                </div>

                <div class="border-l-2 border-l-black h-64 p-2">
                    <textarea
                            class="flex p-2 m-2 text-2xl focus:border-none h-full w-full"
                            name="content"
                            placeholder="Journal content.."></textarea>
                            defaultValue=""
                </div>

                <div class="flex justify-center gap-x-4 bg-black text-white w-16 text-center p-1">
                    <input  type="submit" value="Submit">
                </div>
            </form>
        </div>
    </div>
    <script>
        function editJournal(id) {
            const title = document.querySelector("input[name='title']").value;
            const content = document.querySelector("textarea[name='content']").value;
            const data = {
                title,
                content
            }
            fetch(`http://localhost:8080/journal/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            })
                .then(res => res.json())
                .then(data => {
                    console.log(data);
                })
                .catch(err => console.log(err));
        }
    <jsp:include page="footer.jsp" />
</div>
</body>