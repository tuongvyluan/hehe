function submit() {
    const controller = System.getProperty("user.dir") + "/MainController";
    const data = {
        action: "LoginStudent",
        email: $('input#email'),
        password: $('input#password')
    };
    $.post(controller, data)
}