<%@page import="students.StudentDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Edit profile</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
            />
        <link rel="stylesheet" href="css/editProfile.css" />
    </head>
    <body>
        <link
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
            rel="stylesheet"
            />
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

                <div class="col">
                    <div class="row">
                        <div class="col mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="e-profile">
                                        <div class="row">
                                            <div
                                                class="col-12 col-sm-auto mb-3"
                                                >
                                                <div
                                                    class="mx-auto"
                                                    style="width: 140px"
                                                    >
                                                    <div
                                                        class="d-flex justify-content-center align-items-center rounded"
                                                        style="
                                                        height: 140px;
                                                        background-color: rgb(
                                                        233,
                                                        236,
                                                        239
                                                        );
                                                        "
                                                        >
                                                        <span
                                                            style="
                                                            color: rgb(
                                                            166,
                                                            168,
                                                            170
                                                            );
                                                            font: bold 8pt
                                                            Arial;
                                                            "
                                                            >140x140</span
                                                        >
                                                    </div>
                                                </div>
                                            </div>
                                            <div
                                                class="col d-flex flex-column flex-sm-row justify-content-between mb-3"
                                                >
                                                <div
                                                    class="text-center text-sm-left mb-2 mb-sm-0"
                                                    >
                                                    <h4
                                                        class="pt-sm-2 pb-1 mb-0 text-nowrap"
                                                        >
                                                        John Smith
                                                    </h4>

                                                    <div class="mt-2">
                                                        <button
                                                            class="btn btn-primary"
                                                            type="button"
                                                            />
                                                        <i
                                                            class="fa fa-fw fa-camera"
                                                            ></i>
                                                        <span
                                                            >Change
                                                            Photo</span
                                                        >
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="tab-content pt-3">
                                            <div class="tab-pane active">
                                                <form
                                                    class="form"
                                                    novalidate=""
                                                    >
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="row">
                                                                <div
                                                                    class="col"
                                                                    >
                                                                    <div
                                                                        class="form-group"
                                                                        >
                                                                        <label
                                                                            for="editFullname"
                                                                            >Full
                                                                            Name</label
                                                                        >
                                                                        <input
                                                                            id="editFullname"
                                                                            class="form-control"
                                                                            type="text"
                                                                            name="name"
                                                                            placeholder="John Smith"
                                                                            value="John Smith"
                                                                            />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div
                                                                    class="col"
                                                                    >
                                                                    <div
                                                                        class="form-group"
                                                                        >
                                                                        <label
                                                                            for="editEmail"
                                                                            >Email</label
                                                                        >
                                                                        <input
                                                                            id="editEmail"
                                                                            class="form-control"
                                                                            type="text"
                                                                            placeholder="user@example.com"
                                                                            />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div
                                                                class="row"
                                                                ></div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div
                                                            class="col-12 col-sm-6 mb-3"
                                                            >
                                                            <div class="mb-2">
                                                                <b
                                                                    >Change
                                                                    Password</b
                                                                >
                                                            </div>
                                                            <div class="row">
                                                                <div
                                                                    class="col"
                                                                    >
                                                                    <div
                                                                        class="form-group"
                                                                        >
                                                                        <label
                                                                            for="currentPassword"
                                                                            >Current
                                                                            Password</label
                                                                        >
                                                                        <input
                                                                            id="currentPassword"
                                                                            class="form-control"
                                                                            type="password"
                                                                            placeholder="********"
                                                                            />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div
                                                                    class="col"
                                                                    >
                                                                    <div
                                                                        class="form-group"
                                                                        >
                                                                        <label
                                                                            for="newPassword"
                                                                            >New
                                                                            Password</label
                                                                        >
                                                                        <input
                                                                            id="newPassword"
                                                                            class="form-control"
                                                                            type="password"
                                                                            placeholder="********"
                                                                            />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div
                                                                    class="col"
                                                                    >
                                                                    <div
                                                                        class="form-group"
                                                                        >
                                                                        <label
                                                                            for="confirmPassword"
                                                                            >Confirm
                                                                            Password</label
                                                                        >
                                                                        <input
                                                                            id="confirmPassword"
                                                                            class="form-control"
                                                                            type="password"
                                                                            placeholder="********"
                                                                            />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div
                                                            class="col d-flex justify-content-end"
                                                            >
                                                            <button
                                                                class="btn btn-secondary"
                                                                type="submit"
                                                                style="
                                                                margin-right: 10px;
                                                                "
                                                                >
                                                                Cancel
                                                            </button>
                                                            <button
                                                                class="btn btn-primary"
                                                                type="submit"
                                                                >
                                                                Save Changes
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col">
        <div class="row">
            <div class="col mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="e-profile">
                            <div class="row">
                                <div
                                    class="col-12 col-sm-auto mb-3"
                                    >
                                    <div
                                        class="mx-auto"
                                        style="width: 140px"
                                        >
                                        <div
                                            class="d-flex justify-content-center align-items-center rounded"
                                            style="
                                            height: 140px;
                                            background-color: rgb(
                                            233,
                                            236,
                                            239
                                            );
                                            "
                                            >
                                            <span
                                                style="
                                                color: rgb(
                                                166,
                                                168,
                                                170
                                                );
                                                font: bold 8pt
                                                Arial;
                                                "
                                                >140x140</span
                                            >
                                        </div>
                                    </div>
                                </div>
                                <div
                                    class="col d-flex flex-column flex-sm-row justify-content-between mb-3"
                                    >
                                    <div
                                        class="text-center text-sm-left mb-2 mb-sm-0"
                                        >
                                        <h4
                                            class="pt-sm-2 pb-1 mb-0 text-nowrap"
                                            >
                                            <%= student.getFirstName()%>
                                        </h4>

                                        <div class="mt-2">
                                            <button
                                                class="btn btn-primary"
                                                type="button">
                                                <i class="fa fa-fw fa-camera"></i>
                                                <span>Change Photo</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-content pt-3">
                                <div class="tab-pane active">
                                    <form
                                        class="form"
                                        novalidate=""
                                        >
                                        <input hidden="" name="controller" value="Student">
                                        <div class="row">
                                            <div class="col">
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="editFirstName"
                                                                >First name</label
                                                            >
                                                            <input
                                                                id="editFirstName"
                                                                class="form-control"
                                                                type="text"
                                                                name="firstName"
                                                                placeholder="First name"
                                                                value="<%= student.getFirstName()%>"
                                                                />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="editLastname"
                                                                >Last name</label
                                                            >
                                                            <input
                                                                id="editLastName"
                                                                class="form-control"
                                                                type="text"
                                                                name="lastName"
                                                                placeholder="Last name"
                                                                value="<%= student.getLastName()%>"
                                                                />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="editEmail"
                                                                >Email</label
                                                            >
                                                            <input
                                                                id="editEmail"
                                                                class="form-control"
                                                                type="text"
                                                                placeholder="Email"
                                                                name="email"
                                                                value="<%= student.getEmail()%>"/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="editPhoneNumber"
                                                                >Phone number</label
                                                            >
                                                            <input
                                                                id="editPhoneNumber"
                                                                class="form-control"
                                                                type="text"
                                                                placeholder="Phone number"
                                                                name="phoneNumber"
                                                                value="<%= student.getPhoneNumber()%>"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div
                                                class="col-12 col-sm-6 mb-3"
                                                >
                                                <div class="mb-2">
                                                    <b
                                                        >Change
                                                        Password</b
                                                    >
                                                </div>
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="currentPassword"
                                                                >Current
                                                                Password</label
                                                            >
                                                            <input
                                                                id="currentPassword"
                                                                class="form-control"
                                                                type="password"
                                                                name="password"
                                                                placeholder="********"
                                                                />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="newPassword"
                                                                >New
                                                                Password</label
                                                            >
                                                            <input
                                                                id="newPassword"
                                                                class="form-control"
                                                                type="password"
                                                                name="newPassword"
                                                                placeholder="********"
                                                                />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div
                                                        class="col"
                                                        >
                                                        <div
                                                            class="form-group"
                                                            >
                                                            <label
                                                                for="confirmPassword"
                                                                >Confirm
                                                                Password</label
                                                            >
                                                            <input
                                                                id="confirmPassword"
                                                                class="form-control"
                                                                type="password"
                                                                name="confirm"
                                                                placeholder="********"
                                                                />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div
                                                class="col d-flex justify-content-end"
                                                >
                                                <button
                                                    class="btn btn-secondary"
                                                    type="submit"
                                                    style="margin-right: 10px;"
                                                    name="action"
                                                    value="CancelEditProfile"
                                                    >
                                                    Cancel
                                                </button>
                                                <button
                                                    class="btn btn-primary"
                                                    type="submit"
                                                    name="action"
                                                    value="EditProfile"
                                                    >
                                                    Save Changes
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
