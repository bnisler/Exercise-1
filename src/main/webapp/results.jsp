<%@include file="head.jsp"%>

<html><body>

<%--TODO Pretty up the results! --> complete--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table>
        <thead>
            <tr>
                <th>UserID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>UserAge</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.getUserAge()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
