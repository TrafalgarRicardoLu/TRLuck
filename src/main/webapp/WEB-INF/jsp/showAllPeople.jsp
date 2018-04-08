<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Collapsible sidebar using Bootstrap 3</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="../../assests/bootstrap/css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="../../assests/main/style.css">
    <link rel="stylesheet" href="../../assests/font-awesome/css/font-awesome.min.css">
    <script>
        function deleteConfirm() {
            var c = confirm("Are you sure to delete the person?");
            if(c == true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<div class="wrapper">
 <!-- Sidebar Holder -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>Universal System</h3>
        </div>

        <ul class="list-unstyled components">
            <li>
                <a href="index.html">Home</a>
            </li>
            <li>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">Person</a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li><a href="/showAllPeople">Show All Person</a></li>
                    <li><a href="addNewPerson.html">Add Person</a></li>
                </ul>
            </li>
        </ul>
    </nav>

    <!-- Page Content Holder -->
    <div id="content">

        <nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                        <i></i>
                        <span>Toggle Sidebar</span>
                    </button>
                </div>
            </div>
        </nav>
        <div id="article">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Sex</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="Person" items="${People}">
                    <tr>
                        <td>${Person.pid}</td>
                        <td>${Person.pname}</td>
                        <td>${Person.age}</td>
                        <td>${Person.sex}</td>
                        <td><a href="/deletePerson?deletedPid=${Person.pid}" class="fa fa-times-circle-o" onclick="return deleteConfirm()"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>


<!-- jQuery CDN -->
<script src="../../assests/bootstrap/js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap Js CDN -->
<script src="../../assests/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });
    });
</script>
</body>
</html>
