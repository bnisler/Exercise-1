<%@include file="head.jsp"%>
<html>
    <body>
        <h2>User Display Exercise - Week 1</h2>
        <a href = "searchUser">Go to the User Search</a>

        <br />

        <form method="get" action="/searchUser">
            <label>Search last name: </label>
            <input type="text" name="lastName" />
            <br />
            <input type="submit" value="Search" />
        </form>
    </body>
</html>