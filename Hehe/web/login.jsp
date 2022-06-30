<<<<<<< HEAD
<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>

        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>

        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->


        <title>Login </title>
    </head>
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
=======

>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
    <body>
        <header>
            <%@ include file="header.jsp" %>
        </header>
        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/loginBackground.jpg');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" >
                        <span class="login100-form-title p-b-49">
                            Login
                        </span>

<<<<<<< HEAD
<<<<<<< HEAD
                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="username" type="email" id="mail" required="" title="The domain portion of the email address is invalid (the portion after the @)." pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$" placeholder="Type your username">
                            <span class="error" aria-live="polite"></span>
=======
=======
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
                        <!-- pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$"
                                 -->
                        <div class="wrap-input100 validate-input m-b-23" data-validate="Email is required">
                            <span class="label-input100">Email</span>
                            <input value="${param.email}" id="email" class="input100" type="text" name="email"
                                   placeholder="Type your email"
                                title="The domain portion of the email address is invalid (the portion after the @).">
<<<<<<< HEAD
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
=======
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">Password</span>
<<<<<<< HEAD
<<<<<<< HEAD
                            <input class="input100" type="password" name="pass" required="" placeholder="Type your password">
=======
                            <input value="${param.password}" id="password" class="input100" type="password"
                                name="password" placeholder="Type your password">
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
=======
                            <input value="${param.password}" id="password" class="input100" type="password"
                                name="password" placeholder="Type your password">
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <div class="text-right p-t-8 p-b-31">
                            <a href="#">
                                Forgot password?
                            </a>
                        </div>

                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn">
                                    Login
                                </button>
                            </div>
                        </div>

                        <div class="txt1 text-center p-t-54 p-b-20">
                            <span>
                                Or Login Using
                            </span>
                        </div>

                        <div class="flex-c-m">
                            <a href="#" class="login100-social-item bg3">
                                <i class="fa fa-google"></i>
                            </a>
                        </div>

                        <div class="flex-col-c p-t-100">
                            <span class="txt1 p-b-17">
                                Don't have an account ?
                            </span>

                            <a href="#" class="txt2">
                                CLICK HERE TO CREATE
                            </a>
                        </div>
                    </form>
                </div>
            </div>
<<<<<<< HEAD
<<<<<<< HEAD
        </div>
        <footer>
            <%@ include file="footer.jsp" %>
        </footer>
        <script src="js/validate.js"></script>
    </body>
</html>
=======
=======
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
            <footer>
                <%@ include file="footer.jsp" %>
            </footer>
            <script src="js/validate.js"></script>
    </body>

<<<<<<< HEAD
    </html>
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
=======
    </html>
>>>>>>> dc5aa5848397d557150439374146fcfe5975f38d
