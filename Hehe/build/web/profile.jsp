<%@page import="students.StudentDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Profile</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
        />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
        />
        <link rel="stylesheet" href="css/profile.css" />
    </head>
    <body>
        <%
            //Prevent everyone else except the login student go to this page
            StudentDTO student;
            if (session.getAttribute("LOGIN_STUDENT") != null) {
                student = (StudentDTO) session.getAttribute("LOGIN_STUDENT");
            } else {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="container">
            <div class="row flex-lg-nowrap">
                <div class="col-12 col-lg-auto mb-3" style="width: 200px">
                    <div class="card p-3">
                        <div class="e-navlist e-navlist--active-bg">
                            <ul class="nav">
                                <li class="nav-item">
                                    <a
                                        class="nav-link px-2 active"
                                        href="./profile.html"
                                        ><i
                                            class="fa-solid fa-user-astronaut"
                                        ></i
                                        ><span> Profile</span></a
                                    >
                                </li>
                                <li class="nav-item">
                                    <a
                                        class="nav-link px-2"
                                        href="./editProfile.html"
                                        target="__blank"
                                        ><i
                                            class="fa-regular fa-pen-to-square"
                                        ></i
                                        ><span> Edit</span></a
                                    >
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- <div class="col"> -->
                <div class="col bootdey flex-grow-1 container-p-y">
                    <div class="card mb-4">
                        <div class="card-body">
                            <table class="table user-view-table m-0">
                                <tbody>
                                    <tr>
                                        <div class="media align-items-center">
                                            <img
                                                src="https://bootdey.com/img/Content/avatar/avatar1.png"
                                                alt=""
                                                class="d-block ui-w-100 rounded-circle"
                                            />
                                            <div class="media-body ml-4">
                                                <h4
                                                    class="font-weight-bold mb-0"
                                                >
                                                    <%= student.getFirstName() + ' ' + student.getLastName() %>
                                                </h4>
                                            </div>
                                        </div>
                                    </tr>
                                    <tr>
                                        <td>Registered:</td>
                                        <td>01/23/2017</td>
                                    </tr>
                                    <tr>
                                        <td>Latest activity:</td>
                                        <td>01/23/2018 (14 days ago)</td>
                                    </tr>
                                    <tr>
                                        <td>Role:</td>
                                        <td>User</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="card">
                        <div class="row no-gutters row-bordered"></div>
                        <hr class="border-light m-0" />
                        <div class="card-body">

                            <h6 class="mt-4 mb-3">Personal info</h6>

                            <table class="table user-view-table m-0">
                                <tbody>
                                    <tr>
                                        <td>Birthday:</td>
                                        <td><%= student.getDob().toString() %></td>
                                    </tr>
                                </tbody>
                            </table>

                            <h6 class="mt-4 mb-3">Contacts</h6>

                            <table class="table user-view-table m-0">
                                <tbody>
                                    <tr>
                                        <td>E-mail:</td>
                                        <td><%= student.getEmail() %></td>
                                    </tr>
                                    <tr>
                                        <td>Phone:</td>
                                        <td><%= student.getPhoneNumber() %></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- </div> -->
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
