<html>
    <head>
        <title>Welcome to my ToDo web appllication</title>
    </head>
    <body>
        <h2>Here are your upcoming goals, Best of Luck!</h2>
        <div>Welcome ${name}</div>
        <!--with the help of todo services.java-->
        <div>Your ToDo's are</div>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Completed?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetdate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach> <!--jstl enhanced for loop-->
            </tbody>
        </table>        
    </body>
</html>