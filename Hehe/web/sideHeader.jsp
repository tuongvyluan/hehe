<%-- 
    Document   : sideHeader
    Created on : Jul 13, 2022, 8:33:12 PM
    Author     : ADMIN
--%>

<!-- Coding by CodingLab | www.codinglabweb.com -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!----======== CSS ======== -->
        <link rel="stylesheet" href="css/styleSideNavBar.css">

        <!----===== Boxicons CSS ===== -->
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

        <title>Dashboard Sidebar Menu</title> 
    </head>
    <body>
        <nav class="sidebar close">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="images/logo-removebg-preview.png" alt="">
                    </span>

                    <div class="text logo-text">
                        <span class="name">Hehe Code</span>

                    </div>
                </div>

            </header>

            <div class="menu-bar">
                <div class="menu">
                    <ul class="menu-links">
                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-book-open icon' ></i>
                                <span class="text nav-text">Show lesson</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class='bx bx-stopwatch icon' ></i>
                                <span class="text nav-text">History</span>
                            </a>
                        </li>



                    </ul>
                </div>

                <div class="bottom-content">
                    <li class="">
                        <a href="#">
                            <i class='bx bx-log-out icon' ></i>
                            <span class="text nav-text">Back to course</span>
                        </a>
                    </li>


                </div>
            </div>

        </nav>


    </body>
</html>
